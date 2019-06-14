UBi.Bi API总则
====

本接口采用http协议通信，接口主节点为https://api.ubi.bi 所有返回为JSON数据格式。接口分为公共接口和安全签名接口。安全签名接口，请求头必须包含APIKEY，APIKEY的值为平台给用户生成的APIKEY，传输时必须使用平台颁发的证书加密，数据必须使用证书的私钥签名。签名数据为请求的所有数，按字母顺进行排序后签名。签名后的数据以signature为参数作为请求数据的一部分传输给服务端。

返回数据格式说明
```
{
	"err": 0, //成功失败标志 0：成功，1：失败
	"code": "02_01_0_001_01_008", //返回的code
	"msg": "查询成功",//返回的消息
	"data": {
		"address": "0x00000000000000000000000000",
		"paymentId": "",
		"minConfirm": 10,
		"expireTime": 1538117994000
	},
	"count": 0 //返回数据的条数
}
```

**接口调用demo：**
- [php](./demo/demo.php)
- [python](./demo/demo.py)
- [java](./demo/java)
