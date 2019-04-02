


接口说明
===========

建立买单（签名）
---------------------

>   **简要描述：**

-   挂单

>   **请求URL：**

-   https://api.ubi.bi/pie/api/business/secret/v1/createBuyOrder

>   **请求方式：**

-   POST

>   **参数：**

| **参数名**      | **必选** | **类型**       | **说明**                                                                      |
|-----------------|----------|----------------|-------------------------------------------------------------------------------|
| **langKey**     | 否       | string         | 语言 枚举：ZH_CN或者EN                                                        |
| **basicToken**  | 是       | string         | 交易代币                                                                      |
| **bazaarId**    | 是       | Long           | 市场                                                                          |
| **targetToken** | 是       | string         | 目标代币                                                                      |
| **quantity**    | 是   | BigDecimal | 数量（市价时购买仓位）                                                   |
| **price**       | 是   | BigDecimal | 金额（市价时不需要传这个参数）                                            |
| **orderType**   | 是   | string     | 订单类型枚举 MARKET_PRICE:市价, LIMIT_PRICE:限价, SURPLUS_LOSS:"止盈止损" |
| **stopPrice**   | 否   | BigDecimal | 触发价格                                                                  |
| **timestamp**       | 是       | Long           | 时间戳 毫秒                                                                   |

>   **返回示例**

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

>   **返回参数说明**

| **参数名** | **类型** | **说明** |
|------------|----------|----------|




建立卖单（签名）
---------------------

>   **简要描述：**

- 卖单

>   **请求URL：**

-   https://api.ubi.bi/pie/api/business/secret/v1/createSaleOrder

>   **请求方式：**

-   POST

>   **参数：**

| **参数名**      | **必选** | **类型**   | **说明**                                                                        |
|-----------------|----------|------------|---------------------------------------------------------------------------------|
| **langKey**     | 否       | string     | 语言枚举：ZH_CN或者EN                                                           |
| **basicToken**  | 是       | string     | 交易代币                                                                        |
| **bazaarId**    | 是       | Long       | 市场                                                                            |
| **targetToken** | 是       | string     | 目标代币                                                                        |
| **quantity**    | 是       | BigDecimal | 数量                                                                            |
| **price**       | 是       | BigDecimal | 金额                                                                            |
| **orderType**   | 是       | string     | 订单类型枚举 *MARKET_PRICE:*市价, *LIMIT_PRICE:*限价, *SURPLUS_LOSS:*"止盈止损" |
| **stopPrice**   | 否       | BigDecimal | 触发价格                                                                        |
| timestamp       | 是       | Long       | 时间戳 毫秒                                                                     |

>   **返回示例**

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
>   **返回参数说明**

| **参数名** | **类型** | **说明** |
|------------|----------|----------|

个人资产查询接口（签名）
-----------------------------

>   **简要描述：**

-   个人资产查询接口

>   **请求URL：**

-   https://api.ubi.bi/pie/api/base/secret/v1/assetsList

>   **请求方式：**

-   POST

>   **参数：**

| **参数名**  | **必选** | **类型**                 | **说明**    |
|-------------|----------|--------------------------|-------------|
| **langKey** | 否       | String 枚举：ZH_CN或者EN | 语言        |
| **timestamp**   | 是       | Long                     | 时间戳 毫秒 |

>   **返回示例**

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
>   **返回参数说明**

| **参数名**        | **类型**   | **说明**                                                  |
|-------------------|------------|-----------------------------------------------------------|
| err               | String     | 0为成功                                                   |
| code              | String     | 系统返回code                                              |
| msg               | String     | 提示消息                                                  |
| totalUsdtVal      | BigDecimal | 所有代币的总usdt估值                                      |
| totalBtcVal       | BigDecimal | 所有代币Btc估值                                           |
| tokenName         | string     | 代币名称                                                  |
| subAccountId      | Integer    | 代币账户Id                                                |
| refId             | String     | 代币Id                                                    |
| balance           | BigDecimal | 余额                                                      |
| balanceBalanceVal | BigDecimal | 法币余额                                                  |
| status            | string     | 代币状态（0 申请中 1 审核中 2审核通过 3已上线 4审核失败） |
| isReceived        | Integer    | 充值状态（0开启1关闭）                                    |
| isSend            | Integer    | 提币状态（0开启1关闭）                                    |
| freezeBalance     | BigDecimal | 冻结余额                                                  |
| freezeBalanceVal  | BigDecimal | 冻结余额法币估值                                          |
| totalBalance      | BigDecimal | 账户总额度                                                |
| totalBalanceVal   | BigDecimal | 账户总额度对就就法币估值                                  |
| btcBalance        | BigDecimal | 总的代币的btc估值                                         |
| btcBalanceVal     | BigDecimal | 对应货币的btc计算出法币估值                               |
| listTradePair     | Array      | 代币支持报有交易对信息                                    |
| sendFee           | BigDecimal | 提币手续费                                                |
| payTitle          | string     | 充值标题                                                  |
| payExtTitle       | string     | 扩展标题                                                  |
| payDec            | string     | 充值简述                                                  |
| btcEstimate       | BigDecimal | 一个代币对应一个Btc估值                                   |


获取当前用户的委托挂单（签名）
-----------------------------------

>   **简要描述：**

-   查询用户目前正在交易订单情况

>   **请求URL：**

-   https://api.ubi.bi/pie/api/business/secret/v1/getOrders

>   **请求方式：**

-   POST

>   **参数：**

| **参数名**        | **必选** | **类型** | **说明**                                 |
|-------------------|----------|----------|------------------------------------------|
| **langKey**       | 否       | string   | 语言枚举：ZH_CN或者EN                    |
| **page**          | 否       | Int      | 起始页                                   |
| **size**          | 否       | string   | 每页记录数                               |
| **basicToken**    | 否       | string   | 交易代币                                 |
| **targetToken**   | 否       | string   | 目标代币                                 |
| **directionEnum** | 否       | string   | 交易方向枚举 INCOME:买入, DISBURSE：卖出 |
| **stime**         | 否       | Long     | 查询开始时间（时间戳）                   |
| **etime**         | 否       | Long     | 查询结束时间（时间戳）                   |
| timestamp         | 是       | Long     | 时间戳毫秒                               |

**返回示例**


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

>   **返回参数说明**

| **参数名**    | **类型**         | **说明**                                                 |
|---------------|------------------|----------------------------------------------------------|
| err           | String           | 0为成功                                                  |
| code          | String           | 系统返回code                                             |
| msg           | String           | 提示消息                                                 |
| pages         | Int              | 当前页数                                                 |
| code          | String           | 订单code                                                 |
| statusName    | String           | 订单状态0:委托中 1:已成交 2:部分成交 3:已撤消 4:撤销失败 |
| tradePairId   | Int              | 交易对Id                                                 |
| tradePairName | String           | 交易对名称                                               |
| orderTypeName | 订单类型         | 订单类型(0:市价、1:限价、2:止盈止损)                     |
| directionName | String           | 交易方向                                                 |
| amount        | BigDecimal       | 委托单价                                                 |
| totalAmount   | Lon BigDecimal g | 实际成交金额                                             |
| actualNum     | BigDecimal       | 实际成交数量                                             |
| num           | BigDecimal       | 委托数量                                                 |
| fee           | String           | 手续费                                                   |
| condition     | String           | 触发条件（价格、时间）后续提出单独处理                   |
| operator      | String           | 操作人                                                   |
| gmtCreate     | Long             | 委托时间                                                 |
| gmtModify     | Long             | 更新时间                                                 |

查询用户历史委托（签名）
-----------------------------

>   **简要描述：**

-   查询用户历史订单(已成交、部分成交、已撤销)

>   **请求URL：**

-   https://api.ubi.bi/pie/api/business/secret/v1/getHisOrders

>   **请求方式：**

-   POST

>   **参数：**

| **参数名**        | **必选** | **类型** | **说明**                                 |
|-------------------|----------|----------|------------------------------------------|
| **langKey**       | 否       | string   | 语言枚举：ZH_CN或者EN                    |
| **page**          | 否       | Int      | 起始页                                   |
| **size**          | 否       | Long     | 每页记录数                               |
| **basicToken**    | 否       | string   | 交易代币                                 |
| **targetToken**   | 否       | string   | 目标代币                                 |
| **bazaarId**      | 否       | Long     | 交易市场Id                               |
| **directionEnum** | 否       | string   | 交易方向 枚举 INCOME:买入 DISBURSE：卖出 |
| **stime**         | 否       | Long     | 查询开始时间（时间戳）                   |
| **etime**         | 否       | Long     | 查询结束时间（时间戳）                   |
| timestamp         | 是       | Long     | 时间戳 毫秒                              |

**返回示例**
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


撤单（签名）
-----------------

>   **简要描述：**

-   撤销订单

>   **请求URL：**

-   https://api.ubi.bi/pie/api/business/secret/v1/undoOrder

>   **请求方式：**

-   POST

>   **参数：**

| **参数名**  | **必选** | **类型** | **说明**              |
|-------------|----------|----------|-----------------------|
| **langKey** | 否       | string   | 语言枚举：ZH_CN或者EN |
| **code**    | 是       | string   | 订单号                |
| **timestamp**   | 是       | Long     | 时间戳 毫秒           |

**返回示例**


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



>   **返回参数说明**


交易对批量撤单（签名）
----------------------------

>   **简要描述：**

-   撤销委托中的订单

>   **请求URL：**

-   https://api.ubi.bi/pie/api/business/secret/v1/undoOrders

>   **请求方式：**

-   POST

>   **参数：**

| **参数名**  | **必选** | **类型** | **说明**              |
|-------------|----------|----------|-----------------------|
| **langKey** | 否       | string   | 语言枚举：ZH_CN或者EN |
| **symbol**       | 是       | string   | 交易对例如EOS_USDT    |
| **timestamp**    | 是       | Long     | 时间戳 毫秒           |

**返回示例**

```
{
  "err": 0,
  "code": "02_01_0_001_01_017",
  "msg": "操作成功",
  "data": null,
  "count": 0
}
```

>   **返回参数说明**
