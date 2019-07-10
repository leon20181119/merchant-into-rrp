package com.example.demo.pojo;

public class WithdrawVO {

    public String merchantOrderNo; //商户订单号

    public String cardNo;//用户卡号

    public String cardName;//银行卡开卡人姓名

    public int channel; //通道

    public String orderPrice; //订单金额

    public String callBackURL; //回调地址

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getCallBackURL() {
        return callBackURL;
    }

    public void setCallBackURL(String callBackURL) {
        this.callBackURL = callBackURL;
    }



    @Override
    public String toString() {
        return "WithdrawVO{" +
                "merchantOrderNo='" + merchantOrderNo + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", cardName='" + cardName + '\'' +
                ", channel=" + channel +
                ", orderPrice='" + orderPrice + '\'' +
                ", callBackURL='" + callBackURL + '\'' +
                '}';
    }
}
