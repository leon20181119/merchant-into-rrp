package com.example.demo.pojo;

public class DepositVO {

    public String merchantOrderNo; //商户订单号

    public String orderPrice; //充值金额

    public int channel; //通道

    public String callBackURL; //回调地址


    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public int getChannel() {
        return channel;
    }

    public String getCallBackURL() {
        return callBackURL;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public void setCallBackURL(String callBackURL) {
        this.callBackURL = callBackURL;
    }

    @Override
    public String toString() {
        return "DepositVO{" +
                "merchantOrderNo='" + merchantOrderNo + '\'' +
                ", orderPrice='" + orderPrice + '\'' +
                ", channel='" + channel + '\'' +
                ", callBackURL='" + callBackURL + '\'' +
                '}';
    }
}
