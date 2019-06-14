#!/usr/bin/env python3
#encoding:utf-8


# 依赖:
# sudo pip3 install pyOpenSSL

'''
接口调用说明：

1. 客户端调用API 的时候，双方的时间必须满足：服务器时间-10s <（客户端）接口请求时间 <=服务器时间

2. 实际调用API 前，先调用 校时接口（https://api.ubi.bi/pie/api/base//secret/v1/time）
   获取服务器的时间作为参考，如果客户端时间超前于服务器时间，请代码上处理下，比如将本地时间减去若干秒

3. 请求 API 的时候，参数格式是标准的 html 表单的格式，即body 部分 的形式为：  key1=value1&key2=value2

4. 请求 API 的时候，需要用私钥对参数字符串进行签名，然后将签名结果附加到参数字符串里，比如：
   key1=value1&key2=value2&signature=DeaY4vvCqIk%2F6JzwFmCYzBv...

5. 签名时，参数需要排序，按照参数key 进行按字母升序排序，比如 
   这是正确的： key1=value1&key2=value2&key3=value3
   这是错误的： key1=value1&akey2=value2&key3=value3， 因为 akey2 以a 开头，应在第一个： akey2=value2&key1=value1&key3=value3

6. 签名后，签名结果需要 urlencode 一下，然后才附加到参数字符串里，因为：
   签名结果是二进制的，要base64 编码，base64 编码一般以 = 等号结尾，这个会影响参数传递
   因此要urlencode
'''

from   OpenSSL import crypto
import time
import urllib.request
import base64
import json

# 指定证书文件
p12crt_f   = "xxxxxxxx.p12"
# 指定证书的密码（提取私钥的时候用到）
p12passwd  = 'xxxxxxx'
# API 接口（下面这个接口是查询信息用的）
testurl    = "https://api.ubi.bi/pie/api/base/secret/v1/assetsList"

# 获取服务器端的时间
srvr_tm_api = "https://api.ubi.bi/pie/api/base//secret/v1/time"

# apikey(你可以理解成你的账号下面的，用于访问API 的 子账号)
apikey     = "xxxxxxxxxxxxxx"


# 1. 加载p12 证书
p12_fd = open(p12crt_f,"rb")
p12crt = crypto.load_pkcs12(p12_fd.read(),p12passwd)
p12_fd.close()


# 2. 获取私钥
privkey = p12crt.get_privatekey()


# 3. 签名请求参数
# 3.0 获取服务器时间
svr_time   = 0
local_time = int(time.time()*1000)
res        = urllib.request.urlopen(srvr_tm_api)
res        = str(res.read().strip(),encoding="utf-8")
res        = json.loads(res)
srvr_time  = res["data"]["serverTime"]
if local_time > srvr_time:
    print("Local timestamp:{} is larger than server's timestamp:{}".format(local_time,srvr_time))
    print("Use the server's timestamp.")
    local_time = srvr_time

# 3.1 参数构造(参数key 应该以首字母由低到高排序) <-----------------注意这里的排序
args = "langKey=EN&timestamp={}".format(local_time)

# 3.2 签名                               /-------------------------注意这里的签名算法： sha256
signature = crypto.sign(privkey,args,'sha256')
sig_b64   = base64.b64encode(signature)
sig_url   = urllib.parse.urlencode([("a",sig_b64)]).split('=')[1] # urlencode 一下
# 3.3 将签名后的参数注入请求参数中
args = args + "&signature={}".format(sig_url)

# 4. 发送请求
req = urllib.request.Request(testurl,data=bytes(args,encoding="utf-8"),headers={"APIKEY":apikey},method="POST")
print(req.get_full_url())
res = str(urllib.request.urlopen(req).read().strip(),encoding="utf-8")
print(res)


