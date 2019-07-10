package com.example.demo.pojo;

public class PublicReqVO {

    public String merchantAccount; //商户账号

    public String action; //接口名称：业务行为;对应四种业务类型英文名称代表

    public String data; //业务参数:json格式;业务参数json包经过AES机密后的信息

    public String sign; //签名:使用MD5加密的签名

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "PublicReqVO{" +
                "merchantAccount='" + merchantAccount + '\'' +
                ", action='" + action + '\'' +
                ", data='" + data + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
