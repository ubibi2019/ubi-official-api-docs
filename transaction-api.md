
Create buy order（signature）
---------------------

>   **Description:**

-   挂单

>   **Request URL:**

-   https://api.ubi.bi/pie/api/business/secret/v1/createBuyOrder

>   **Request Method:**

-   POST

>   **Parameters:**

| **Name**      | **Mandatory** | **Type**       | **Description**                                                                      |
|-----------------|----------|----------------|-------------------------------------------------------------------------------|
| **langKey**     | no      | string         | language type：ZH_CN/EN                                                        |
| **basicToken**  | yes     | string         | trading token                                                                     |
| **bazaarId**    | yes     | Long           | market                                                                          |
| **targetToken** | yes     | string         | target token                                                                      |
| **quantity**    | yes     | BigDecimal     | quantity                                                 |
| **price**       | yes     | BigDecimal     | price                                          |
| **orderType**   | yes     | string         | order type： MARKET_PRICE, LIMIT_PRICE, SURPLUS_LOSS |
| **stopPrice**   | no      | BigDecimal     | trigger price                                                                  |
| **timestamp**   | yes     | Long           | timestamp（ms）                                                                  |

>   **Response:**

```
{ "err": 0,
	"code": "02_01_0_001_01_017",
	"msg": "操作成功",
	"data": { "code": "102101538191530739495556727098314752",
	"statusName": "0",
	"tradePairId": 23,
	"tradePairName": "ETH/USDT",
	"orderTypeName": "1",
	"directionName": "0",
	"price": 210.18,
	"totalAmount": 210.18,
	"actualAmount": 0,
	"actualQuantity": 0,
	"quantity ": 1,
	"fee": null,
	"trigger": null,
	"operator": "www@fff.com",
	"gmtCreate": 1538191530853,
	"gmtModify": 1538191530853
	},
	"count": 0
}
```

>   **Response parameters description**

| **Name** | **Type** | **Description** |
|------------|----------|----------|





Create sell order（signature）
---------------------

>   **Description:**

-   Create sell order

>   **Request URL:**

-   https://api.ubi.bi/pie/api/business/secret/v1/createSaleOrder

>   **Request Method:**

-   POST

>   **Parameters:**

| **Name**      | **Mandatory** | **Type**   | **Description**                                                                        |
|-----------------|----------|------------|---------------------------------------------------------------------------------|
| **langKey**     | no     | string     | language type：ZH_CN/EN                                                           |
| **basicToken**  | yes      | string     | trading token                                                                        |
| **bazaarId**    | yes      | Long       | market                                                                            |
| **targetToken** | yes      | string     | target token                                                                        |
| **quantity**    | yes      | BigDecimal | quantity                                                                            |
| **price**       | yes      | BigDecimal | price                                                                            |
| **orderType**   | yes      | string     | order type: *MARKET_PRICE, *LIMIT_PRICE, *SURPLUS_LOSS |
| **stopPrice**   | no     | BigDecimal | trigger price                                                                        |
| timestamp       | yes      | Long       | timestamp(ms)                                                                     |

>   **Response:**

```
{
  "err": 0,
  "code": "02_01_0_001_01_017",
  "msg": "操作成功",
  "data": {
    "code": "102101538191530739495556727098314752",
    "statusName": "0",
    "tradePairId": 23,
    "tradePairName": "ETH/USDT",
    "orderTypeName": "1",
    "directionName": "0",
    "price": 210.18,
    "totalAmount": 210.18,
    "actualAmount": 0,
    "actualQuantity": 0,
    "quantity": 1,
    "fee": null,
    "trigger": null,
    "operator": "www@ff.com",
    "gmtCreate": 1538191530853,
    "gmtModify": 1538191530853
  },
  "count": 0
}
```
>   **Response parameters description**

| **Name** | **Type** | **Description** |
|------------|----------|----------|


Personal asset query（signature）
-----------------------------

>   **Description:**

-   Personal asset query

>   **Request URL:**

-   https://api.ubi.bi/pie/api/base/secret/v1/assetsList

>   **Request Method:**

-   POST

>   **Parameters:**

| **Name**  | **Mandatory** | **Type**                 | **Description**    |
|-------------|----------|--------------------------|-------------|
| **langKey** | no     | String  | language：ZH_CN/EN     |
| **timestamp**   | yes      | Long                     | timestamp(ms) |

>   **Response:**

```
 { 
     "err" : 0, 
     "code" : "02_01_0_001_01_008", 
     "msg" : "Success", 
     "data" : { 
          "totalUsdtVal" : 0, 
          "totalBtcVal" : 0, 
          "listPersonAssets" : { 
               "0" : { 
                    "tokenName" : "MTN", 
                    "subAccountId" : 213, 
                    "refId" : "24", 
                    "balance" : 100001, 
                    "balanceBalanceVal" : 0, 
                    "status" : "3", 
                    "isReceived" : 0, 
                    "isSend" : 0, 
                    "freezeBalance" : 0, 
                    "freezeBalanceVal" : 0, 
                    "totalBalance" : 100001, 
                    "totalBalanceVal" : 0, 
                    "btcBalance" : 0, 
                    "btcBalanceVal" : 0, 
                    "sendFee" : { 
                    }, 
                    "listTradePair" : { 
                         "0" : { 
                              "bazaarId" : 3, 
                              "targetToken" : "EOS", 
                              "id" : 26, 
                              "basicToken" : "MTN", 
                              "status" : 0 
                         }, 
                    }, 
                    "payTitle" : { 
                    }, 
                    "payExtTitle" : { 
                    }, 
                    "payDec" : { 
                    }, 
                    "btcEstimate" : 0 
               }, 
          } 
     }, 
     "count" : 0 
 }
```
>   **Response parameters description**

| **Name**        | **Type**   | **Description**                                                  |
|-------------------|------------|-----------------------------------------------------------|
| err               | String     | 0: success, 1: failure                                                  |
| code              | String     | system response code                                              |
| msg               | String     | message                                                  |
| totalUsdtVal      | BigDecimal | total usdt valuation of all tokens                                   |
| totalBtcVal       | BigDecimal | all token BTC valuation                                           |
| tokenName         | string     | token name                                                  |
| subAccountId      | Integer    | token account Id                                                |
| refId             | String     | token Id                                                   |
| balance           | BigDecimal | balance                                                      |
| balanceBalanceVal | BigDecimal | legal currency balance                                                  |
| status            | string     | token status（0-Application 1-Auditing 2-Passed 3-Online 4-Auditing failed） |
| isReceived        | Integer    | recharge status（0-on 1-off）                                    |
| isSend            | Integer    | isSend（0-on 1-off）                        |
| freezeBalance     | BigDecimal | freeze Balance                                                  |
| freezeBalanceVal  | BigDecimal | freeze balance currency valuation                                         |
| totalBalance      | BigDecimal | total balance                                               |
| totalBalanceVal   | BigDecimal | total balance valuation                                  |
| btcBalance        | BigDecimal | btc balance of total token                                        |
| btcBalanceVal     | BigDecimal | legal currency valuation of btc balance                              |
| listTradePair     | Array      | list of trading pair                            |
| sendFee           | BigDecimal | fee                                               |
| payTitle          | string     | recharge title                                               |
| payExtTitle       | string     | ext title                                                  |
| payDec            | string     | recharge description                                             |
| btcEstimate       | BigDecimal | one token corresponds to a Btc valuation                                |




Query the order that the user is currently trading (signature)
-----------------------------------

>   **Description:**

-   Query the order that the user is currently trading

>   **Request URL:**

-   https://api.ubi.bi/pie/api/business/secret/v1/getOrders

>   **Request Method:**

-   POST

>   **Parameters:**

| **Name**        | **Mandatory** | **Type** | **Description**                                 |
|-------------------|----------|----------|------------------------------------------|
| **langKey**       | no     | string   | language type：ZH_CN/EN                    |
| **page**          | no     | Int      | start page                                    |
| **size**          | no     | string   | page size                               |
| **basicToken**    | no     | string   | trading token                                 |
| **targetToken**   | no     | string   | target token                                 |
| **directionEnum** | no     | string   | trade direction: INCOME,DISBURSE |
| **stime**         | no     | Long     | start time                 |
| **etime**         | no     | Long     | end time                   |
| timestamp         | yes      | Long     | timestamp（ms）                               |

**Response:**


``` 
 { 
     "err" : 0, 
     "code" : "02_01_0_001_01_008", 
     "msg" : "查询成功", 
     "data" : { 
          "total" : 3, 
          "size" : 10, 
          "current" : 1, 
          "records" : { 
               "0" : { 
                    "code" : "102101537946921989494530763639754752", 
                    "statusName" : "0", 
                    "tradePairId" : 26, 
                    "tradePairName" : "MTN/EOS", 
                    "orderTypeName" : "0", 
                    "directionName" : "1", 
                    "price" : 0, 
                    "totalAmount" : 23, 
                    "actualAmount" : 0, 
                    "actualNum" : 0, 
                    "quantity" : 23, 
                    "fee" : "0", 
                    "condition" : { 
                    }, 
                    "operator" : "1013064101@qq.com", 
                    "gmtCreate" : 1537946922000, 
                    "gmtModify" : 1537946922000 
               }, 
          }, 
          "pages" : 1 
     }, 
     "count" : 0 
 } 

```

>   **Response parameters description**

| **Name**    | **Type**         | **Description**                                                 |
|---------------|------------------|----------------------------------------------------------|
| err           | String           | 0: success, 1: failure                                                     |
| code          | String           | system response code                                             |
| msg           | String           | message                                                 |
| pages         | Int              | current page                                                 |
| code          | String           | order code                                                 |
| statusName    | String           | order status,0: Delegate 1: Completed 2: Partial transaction 3: Cancelled 4: Undo failed|
| tradePairId   | Int              | trade pair Id                                                 |
| tradePairName | String           | trade pair name                                              |
| orderTypeName | 订单类型           | order type(0: market price, 1: limit price, 2: take profit stop loss)                     |
| directionName | String           | trade direction                                                 |
| amount        | BigDecimal       | amount                                                 |
| totalAmount   | Lon BigDecimal g | total amount                                             |
| actualNum     | BigDecimal       | autuall number                                            |
| num           | BigDecimal       | number                                                 |
| fee           | String           | fee                                                   |
| condition     | String           | condition                   |
| operator      | String           | operator                                                   |
| gmtCreate     | Long             | create time                                                 |
| gmtModify     | Long             | update time                                                 |




Query user history order (signature)
-----------------------------

>   **Description:**

-   Query user history order order 

>   **Request URL:**

-   https://api.ubi.bi/pie/api/business/secret/v1/getHisOrders

>   **Request Method:**

-   POST

>   **Parameters:**

| **Name**        | **Mandatory** | **Type** | **Description**                                 |
|-------------------|----------|----------|------------------------------------------|
| **langKey**       | no     | string   | language type：ZH_CN/EN                    |
| **page**          | no     | Int      | start page                                   |
| **size**          | no     | Long     | page size                             |
| **basicToken**    | no     | string   | trading token                                 |
| **targetToken**   | no     | string   | target token                                 |
| **bazaarId**      | no     | Long     | trade market Id                               |
| **directionEnum** | no     | string   | trade direction: INCOME,DISBURSE |
| **stime**         | no     | Long     | start time                   |
| **etime**         | no     | Long     | end time                   |
| timestamp         | yes      | Long    | timestamp(ms)                              |

**Response:**
``` 
 { 
     "err" : 0, 
     "code" : "02_01_0_001_01_008", 
     "msg" : "查询成功", 
     "data" : { 
          "total" : 3, 
          "size" : 10, 
          "current" : 1, 
          "records" : { 
               "0" : { 
                    "code" : "102101537946921989494530763639754752", 
                    "statusName" : "0", 
                    "tradePairId" : 26, 
                    "tradePairName" : "MTN/EOS", 
                    "orderTypeName" : "0", 
                    "directionName" : "1", 
                    "price" : 0, 
                    "totalAmount" : 23, 
                    "actualAmount" : 0, 
                    "actualNum" : 0, 
                    "quantity" : 23, 
                    "fee" : "0", 
                    "condition" : { 
                    }, 
                    "operator" : "1013064101@qq.com", 
                    "gmtCreate" : 1537946922000, 
                    "gmtModify" : 1537946922000 
               }, 
          }, 
          "pages" : 1 
     }, 
     "count" : 0 
 } 

```


Cancel order (signature)
-----------------

>   **Description:**

-   Cancel order

>   **Request URL:**

-   https://api.ubi.bi/pie/api/business/secret/v1/undoOrder

>   **Request Method:**

-   POST

>   **Parameters:**

| **Name**  | **Mandatory** | **Type** | **Description**              |
|-------------|----------|----------|-----------------------|
| **langKey** | no     | string   | language type：ZH_CN/EN |
| **code**    | yes      | string   | order Id                |
| **timestamp**   | yes      | Long     | timestamp(ms)           |

**Response:**


``` 
 { 
     "err" : 0, 
     "code" : "02_01_0_001_01_017", 
     "msg" : "操作成功", 
     "data" : { 
     }, 
     "count" : 0 
 } 

```



>   **Response parameters description**


Cancel batch order (signature)
----------------------------

>   **Description:**

-   Cancel batch order

>   **Request URL:**

-   https://api.ubi.bi/pie/api/business/secret/v1/undoOrders

>   **Request Method:**

-   POST

>   **Parameters:**

| **Name**  | **Mandatory** | **Type** | **Description**              |
|-------------|----------|----------|-----------------------|
| **langKey** | no     | string   | language type：ZH_CN/EN |
| **symbol**       | yes      | string   | symbol,e.g. EOS_USDT    |
| **timestamp**    | yes      | Long     | timestamp(ms)           |

**Response:**

```
{
  "err": 0,
  "code": "02_01_0_001_01_017",
  "msg": "操作成功",
  "data": null,
  "count": 0
}
```

>   **Response parameters description**
