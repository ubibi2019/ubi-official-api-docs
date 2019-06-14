using RestSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Timers;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;

using System.Web;
using System.IO;

using Org.BouncyCastle.Pkcs;
using Org.BouncyCastle.X509;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Security;
using Org.BouncyCastle.Crypto.Parameters;

using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace LoginTest
{
    class Program
    {
        static void Main(string[] args)
        {

            var client = new RestClient("https://api.ubi.bi");
            var request = new RestRequest("/pie/api/base/secret/v1/assetsList", Method.POST);
            request.AddHeader("APIKEY", "填写您的APIKEY");

            //TimeSpan ts = DateTime.UtcNow - new DateTime(1970, 1, 1, 0, 0, 0, 0);
            //String t = Convert.ToInt64(ts.TotalMilliseconds).ToString();
            String t = get_timer();
            Console.WriteLine(t);

            Dictionary<string, Object> dicPar = new Dictionary<string, Object>
            {
                { "langKey", "EN" },
                { "timestamp", t }
            };

            var list = dicPar.Keys.ToList();
            list.Sort();

            request.RequestFormat = DataFormat.Json;

            System.Text.StringBuilder queryBuilder = new System.Text.StringBuilder();
            foreach (var item in list)
            {
                queryBuilder.Append('&');
                queryBuilder.Append(item);
                queryBuilder.Append('=');
                queryBuilder.Append(dicPar[item]);
            }
            queryBuilder.Remove(0, 1);
            Console.WriteLine(queryBuilder.ToString());
            string signature = SignData(Encoding.ASCII.GetBytes(queryBuilder.ToString()));
            Console.WriteLine("signature=" + signature);
            request.AddParameter("langKey", "EN");
            request.AddParameter("timestamp", t);
            request.AddParameter("signature", signature);
            Console.WriteLine("request=" + request.ToString());
            var res = client.Execute(request);
            var content = res.Content;
            Console.WriteLine(content);
        }

        public static string SignData(byte[] dataToBeSigned)
        {
            try
            {
                var path = @"p12绝对路径";
                var password = "p12证书密码";

                FileStream fileStream = null;
                try
                {
                    fileStream = new FileStream(path, FileMode.Open);
                    Pkcs12Store store = new Pkcs12Store(fileStream, password.ToCharArray());

                    string pName = null;
                    foreach (string n in store.Aliases)
                    {
                        if (store.IsKeyEntry(n))
                        {
                            pName = n;
                            //break;
                        }
                    }

                    AsymmetricKeyParameter key = store.GetKey(pName).Key;

                    ISigner normalSig = SignerUtilities.GetSigner("SHA256WithRSA");
                    normalSig.Init(true, key);
                    normalSig.BlockUpdate(dataToBeSigned, 0, dataToBeSigned.Length);
                    byte[] normalResult = normalSig.GenerateSignature(); //签名结果
                    string signature = Convert.ToBase64String(normalResult);
                    return signature;

                }
                finally
                {
                    if (fileStream != null)
                        fileStream.Close();
                }
            }
            catch (Exception ex)
            {
                return ex.ToString();
            }
        }

        public static string get_timer()
        {
            var client = new RestClient("https://api.ubi.bi");
            var request = new RestRequest("https://api.ubi.bi/pie/api/base/secret/v1/time", Method.GET);
            var res = client.Execute(request);
            var jsonText = res.Content;
            JObject data = (JObject)JsonConvert.DeserializeObject(jsonText);
            data = (JObject)JsonConvert.DeserializeObject(data["data"].ToString());
            return data["serverTime"].ToString();
        }
    }
}
