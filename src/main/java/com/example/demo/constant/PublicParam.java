package com.example.demo.constant;

public class PublicParam {

    public final static String SECRET = "Dpkr_OJBXU2TgqRzf0I5LMIp4jyNZOEO2OnEZkS_xy5zGwQsOyid8vBRzM8GUBFL";//由RRP分配，对加密后的数据进行md5签名

    public final static String AES_KEY = "WMs44epafkcATAvAqRfEcMEZAZWk20XT";//由RRP分配，对data数据进行加解密

    public final static String RRP_PUBLIC_URL = "http://localhost:8000/mapi/action";//RRP的接口地址

    public final static String CALL_BACK_URL = "http://localhost:8080/rrp/callBack";//接收rrp异步回调地址

    public final static String MERCHANT_ACCOUNT = "xunyou";//商户账号

    public final static String DEPOSIT = "deposit";//充值接口action值

    public final static String WITHDRAW = "withdraw";//提现接口action值

    public final static String QUERY_BANK_LIST = "query_banklist";//查询通道接口action值

    public final static String QUERY_ORDER = "query_order";//查询订单接口action值

}
