
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        TreeMap<String, Object> treemap = new TreeMap<String, Object>();

        treemap.put("langKey", "EN");
        treemap.put("timestamp", get_timestamp());

        StringBuilder queryBuilder = new StringBuilder();
        for (String field : treemap.keySet()) {

            queryBuilder.append('&');
            queryBuilder.append(field);
            queryBuilder.append('=');
            queryBuilder.append(treemap.get(field));

        }
        queryBuilder.deleteCharAt(0);
        String request_str = queryBuilder.toString();
        try {
            String ssl_file = "p12的绝对路径";
            String sign_str = CertificateUtil.sign(request_str.getBytes(), ssl_file, "证书密码");
//            System.out.println(CertificateUtil.sign(request_str.getBytes("US-ASCII"), ssl_file, "证书密码"));
//            System.out.println(CertificateUtil.sign(request_str.getBytes("ISO-8859-1"), ssl_file, "证书密码"));
//            System.out.println(CertificateUtil.sign(request_str.getBytes("UTF-8"), ssl_file, "证书密码"));
//            System.out.println(CertificateUtil.sign(request_str.getBytes("UTF-16BE"), ssl_file, "证书密码"));
//            System.out.println(CertificateUtil.sign(request_str.getBytes("UTF-16LE"), ssl_file, "证书密码"));

            treemap.put("signature", sign_str);

            System.out.println("\n请求的参数=");
            System.out.println(treemap);

            String res = HttpRequest.post("https://api.ubi.bi/pie/api/base/secret/v1/assetsList")
                .header("APIKEY", "填写您的apkey").form(treemap).execute().body();

            System.out.println("\n请求结果:\n"+res);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    //获取服务器时间- 建议：与服务器时间比对，然后得到与本地时间的差距，再取纠正后的本地时间，不建议每一次都从服务器拿时间。
    private static String get_timestamp() {
        String res = HttpRequest.get("https://api.ubi.bi/pie/api/base/secret/v1/time")
//                .header(Header.USER_AGENT, "Hutool http")
                .execute().body();
        JSONObject data = new JSONObject(res);
        System.out.println();
        Object _res = data.get("data");
//        System.out.print(_res);
        data = new JSONObject(_res);
//        System.out.println(data.get("serverTime"));
        return data.get("serverTime").toString();
    }
}