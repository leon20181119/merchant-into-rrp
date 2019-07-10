package com.example.demo.pojo;

/**
 * rrp回调时请求平台传递的参数
 */
public class CallBackReqVO {

    public String merchantAccount;

    public String result;

    public String sign;

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "CallBackReqVO{" +
                "merchantAccount='" + merchantAccount + '\'' +
                ", result='" + result + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
