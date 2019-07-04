# 引用依赖
require 'openssl'
require 'Base64'
require 'open-uri'
require 'net/http'
require 'net/https'
require 'json'

def demo_start

  # 证书路径及证书密码
  p12 = OpenSSL::PKCS12.new(File.read('/Users/xxxxxx/Downloads/xxxxxxxxxxxx.p12'), "xxxxxxx")

  # 得到key用来签名
  key = p12.key

  ########################## 例子 ： 查询我的资产API ###########################
  # 参数hash
  params = Hash.new
  params['langKey'] = 'ZH_CN'
  params['timestamp'] = get_total_millisecond
  # 对hash进行字母排序
  params = Hash[params.sort_by {|key,value| key}]
  # 组合成key=val&key1=val1 形式的字符串
  rsa_string = '' #待签名的字符串
  params.each do |k, v|
    rsa_string += "#{k}=#{v}&"
  end
  rsa_string = rsa_string.chop

  # 开始签名 结果需要BASE64编码
  digest = OpenSSL::Digest::SHA256.new
  params['signature'] = Base64.encode64(key.sign(digest, rsa_string.encode("UTF-8"))).gsub!("\n", '')
  puts params

  # 请求接口
  uri = URI.parse("https://api.ubi.bi/pie/api/base/secret/v1/assetsList")
  req = Net::HTTP::Post.new(uri)
  req['APIKEY'] = 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
  req.set_form_data(params)
  res = Net::HTTP.start(uri.hostname, uri.port,:use_ssl => uri.scheme == 'https') {|https|
    https.request(req)
  }

  # 返回接口
  puts res.body
  ############################################################################
end


# 根据服务器时间校正本地时间，请自行处理，不建议每次都去读取服务器时间
def get_total_millisecond
  uri = URI("https://api.ubi.bi/pie/api/base/secret/v1/time")
  response = Net::HTTP.get_response(uri)
  JSON.parse(response.body)["data"]["serverTime"]
end

# 开始调用
demo_start