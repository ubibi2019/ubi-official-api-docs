获取所有市场交易对行情
-----------------

>   **简要描述：**

-   获取所有市场交易对行情

>   **请求URL：**

-   https://api.ubi.bi/pie/api/business/v1/market/getBriefMarketInfos

>   **请求方式：**

-   POST

>   **参数：**

| **参数名** | **必选** | **类型** | **说明** |
|------------|----------|----------|----------|


>   **返回示例**

``` 
 {
     "IsSuccess": true,
     "ErrorMsg": null,
     "Data": [
         {
             "Price": 0.001076,
             "TotalVolume": 566016.1,
             "TotalAmount": 623.89,
             "Market": "etc_btc"
         },
         {
             "Price": 4.4677,
             "TotalVolume": 10776493.42,
             "TotalAmount": 46514368.33,
             "Market": "eos_usdt"
         },
         {
             "Price": 0.000409,
             "TotalVolume": 1598090.05,
             "TotalAmount": 690.03,
             "Market": "omg_btc"
         },
         {
             "Price": 0.00010475,
             "TotalVolume": 7974361,
             "TotalAmount": 921.71,
             "Market": "arn_btc"
         },
         {
             "Price": 0.00037775,
             "TotalVolume": 2978760,
             "TotalAmount": 1156.37,
             "Market": "mana_eth"
         }
         ...
     ],
     "Code": 0
 }
```




市场查询接口
-----------------

>   **简要描述：**

-   查询市场

>   **请求URL：**

-   https://api.ubi.bi/pie/api/business/home/v1/queryTradeBazaar

>   **请求方式：**

-   GET

>   **参数：**

| **参数名** | **必选** | **类型** | **说明** |
|------------|----------|----------|----------|


>   **返回示例**

``` 
 { 
     "err" : 0, 
     "code" : "02_01_0_001_01_008", 
     "msg" : "Success", 
     "data" : { 
          "0" : { 
               "id" : 1, 
               "name" : "BTC" 
          }, 
          "1" : { 
               "id" : 2, 
               "name" : "ETH" 
          }, 
          "2" : { 
               "id" : 3, 
               "name" : "EOS" 
          }, 
          "3" : { 
               "id" : 4, 
               "name" : "BUC" 
          }, 
          "4" : { 
               "id" : 5, 
               "name" : "USDT" 
          }, 
     }, 
     "count" : 0 
 } 
```




行情接口
--------------

>   **简要描述：**

-   查询行情

>   **请求URL：**

-   https://api.ubi.bi/pie/api/business/home/v1/ticker

>   **请求方式：**

-   POST

>   **参数：**

| **参数名**  | **必选** | **类型** | **说明**              |
|-------------|----------|----------|-----------------------|
| **langKey** | 否       | string   | 语言枚举：ZH_CN或者EN |
| **symbol**      | 是       | string   | 交易对 例EOS_USDT     |

>   **返回示例**

```
{
  "err": 0,
  "code": "02_01_0_001_01_008",
  "msg": "Success",
  "data": {
    "totalVolume": 49.05033323,//成交量
    "totalAmount": 1709.17,//成交金额
    "lowPrice": 30.24,//最低价格
    "price": 30.24,//当前价格
    "highPrice": 38.54,//最高价格
    "openPrice": 38.54 //开盘价格
  },
  "count": 0
}
```


深度接口
--------------

>   **简要描述：**

-   查询深度(深度接口有交易才能数据)


>   **请求URL：**

-   https://api.ubi.bi/pie/api/business/trade/v1/getDepth

>   **请求方式：**

-   POST

>   **参数：**

| **参数名**  | **必选** | **类型** | **说明**              |
|-------------|----------|----------|-----------------------|
| **langKey** | 否       | string   | 语言枚举：ZH_CN或者EN |
| **symbol**      | 是       | string   | 交易对 例EOS_USDT     |

>   **返回示例**

```
{
  "err": 0,
  "code": "02_01_0_001_01_008",
  "msg": "Success",
  "data": {
    "asks": [
      [
        194,
        1
      ]
    ],
    "bids": [
      [
        192,
        1
      ]
    ]
  },
  "count": 0
}
```


>   **返回参数说明**

| **参数名** | **必选** | **类型** | **说明**                            |
|------------|----------|----------|-------------------------------------|
| asks       | 是       | Array    | 代表卖方 194代表卖的价格 1 卖的数量 |
| bids       | 是       | Array    | 代表买方 192代表买的价格 1 买的数量 |

