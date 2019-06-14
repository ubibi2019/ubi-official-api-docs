<?php

    ini_set('date.timezone','Asia/Shanghai');

    openssl_pkcs12_read(file_get_contents("xxxxxxxxxx.p12"),$key,"证书密码");

    $private_key = $key["pkey"];


    $data =  array(
        "langKey"=>"ZH_CN",
        "timestamp"=>get_total_millisecond()
    );

    ksort($data);

    $o = "";
    foreach ( $data as $k => $v )
    {
        $o.= "$k=" . urlencode( $v ). "&" ;
    }

    $sign_str = substr($o,0,-1);

    print_r("<br>等待签名的：".$sign_str."\n");

    openssl_sign($sign_str,$singture,$private_key,"sha256");

    $singture = (base64_encode($singture));

    print_r("<br>签名后的：singture=".$singture."\n");

    $data["signature"] = $singture;

    $res = request_post("https://api.ubi.bi/pie/api/base/secret/v1/assetsList",$data,array(
        "APIKEY: 写入您的apikey"
    ));

    print_r("<br>得到的结果");
    print_r($res);

/*
     *
     *返回字符串的毫秒数时间戳
     */
function get_total_millisecond()
{
//    $time = explode (" ", microtime () );
//    $time = $time [1] . ($time [0] * 1000);
//    $time2 = explode ( ".", $time );
//    $time = $time2 [0];
//    return $time-10000;


    $time = request_get("https://api.ubi.bi/pie/api/base/secret/v1/time");

    $time = json_decode($time,true);

    return intval($time["data"]["serverTime"]);
}


/**
 * 模拟post进行url请求
 * @param string $url
 * @param array $post_data
 */
function request_post($url = '', $post_data = array(),$headers =  array()) {
    if (empty($url) || empty($post_data)) {
        return false;
    }

    $o = "";
    foreach ( $post_data as $k => $v )
    {
        $o.= "$k=" . urlencode( $v ). "&" ;
    }
    $post_data = substr($o,0,-1);

    $postUrl = $url;
    $curlPost = $post_data;
    $ch = curl_init();//初始化curl
    curl_setopt($ch, CURLOPT_URL,$postUrl);//抓取指定网页
    !empty($headers)?curl_setopt($ch, CURLOPT_HTTPHEADER, $headers):curl_setopt($ch, CURLOPT_HEADER, $headers);//设置header
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);//要求结果为字符串且输出到屏幕上
    curl_setopt($ch, CURLOPT_POST, 1);//post提交方式
    curl_setopt($ch, CURLOPT_POSTFIELDS, $curlPost);
    $data = curl_exec($ch);//运行curl
    curl_close($ch);

    return $data;
}


function request_get($url,$headers = array())
{
    $curl = curl_init(); // 启动一个CURL会话
    curl_setopt($curl, CURLOPT_URL, $url);
//    $_rand_ip = Rand_IP();
//    array_push($headers,'X-FORWARDED-FOR:'.$_rand_ip, 'CLIENT-IP:'.$_rand_ip);
    !empty($headers)?curl_setopt($curl, CURLOPT_HTTPHEADER, $headers):curl_setopt($curl, CURLOPT_HEADER, $headers);//设置header
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
    curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false); // 跳过证书检查
    curl_setopt($curl, CURLOPT_SSL_VERIFYHOST, false);  // 从证书中检查SSL加密算法是否存在
    $tmpInfo = curl_exec($curl);     //返回api的json对象
    //关闭URL请求
    curl_close($curl);
    return $tmpInfo;    //返回json对象
}