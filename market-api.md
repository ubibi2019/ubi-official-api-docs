Get server time
-----------------

>   **Description:**

-   Get server time

>   **Request URL:**

-   https://api.ubi.bi/pie/api/base/secret/v1/time

>   **Request Method:**

-   GET

>   **Parameters:**

| **Name** | **Mandatory** | **Type** | **Description** |
|------------|----------|----------|----------|

>   **Response:**

```
 {
 	"err": 0,
 	"code": "02_01_0_001_01_008",
 	"msg": "Success",
 	"data": {
 		"serverTime": 1560419234126
 	},
 	"count": 0
 }
```

Get market quotes for all trading pairs
-----------------

>   **Description:**

-   Get market quotes for all trading pairs

>   **Request URL:**

-   https://api.ubi.bi/pie/api/business/v1/market/getBriefMarketInfos

>   **Request Method:**

-   POST

>   **Parameters:**

| **Name** | **Mandatory** | **Type** | **Description** |
|------------|----------|----------|----------|


>   **Response:**

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



Market query
-----------------

>   **Description:**

-   get market data

>   **Request URL:**

-   https://api.ubi.bi/pie/api/business/home/v1/queryTradeBazaar

>   **Request Method:**

-   GET

>   **Parameters:**

| **Name** | **Mandatory** | **Type** | **Description** |
|------------|----------|----------|----------|


>   **Response:**

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



Quotation query
--------------

>   **Description:**

-   Quotation query

>   **Request URL:**

-   https://api.ubi.bi/pie/api/business/home/v1/ticker

>   **Request Method:**

-   POST

>   **Parameters:**

| **Name:**  | **Mandatory** | **Type** | **Description**              |
|-------------|----------|----------|-----------------------|
| **langKey** | no       | string   | language type:ZH_CN/EN |
| **symbol**  | yes       | string   | Symbol, for example EOS_USDT     |

>   **Response:**

```
{
  "err": 0,
  "code": "02_01_0_001_01_008",
  "msg": "Success",
  "data": {
    "totalVolume": 49.05033323,//Total traded base asset volume
    "totalAmount": 1709.17,//Total traded quote asset volume
    "lowPrice": 30.24,
    "price": 30.24,
    "highPrice": 38.54,
    "openPrice": 38.54 
  },
  "count": 0
}
```


Depth query
--------------

>   **Description:**

-   Depth query

>   **Request URL:**

-   https://api.ubi.bi/pie/api/business/trade/v1/getDepth

>   **Request Method:**

-   POST

>   **Parameters:**

| **Name:**  | **Mandatory** | **Type** | **Description**              |
|-------------|----------|----------|-----------------------|
| **langKey** | no       | string   | language type:ZH_CN/EN |
| **symbol**      | yes       | string   | symbol, for example EOS_USDT     |

>   **Response:**

```
{
  "err": 0,
  "code": "02_01_0_001_01_008",
  "msg": "Success",
  "data": {
    "asks": [ // Asks to be updated
      [
        194, // Price level to be updated
        1  // Quantity
      ]
    ],
    "bids": [ // Bids to be updated
      [
        192, // Price level to be updated
        1 // Quantity
      ]
    ]
  },
  "count": 0
}
```

