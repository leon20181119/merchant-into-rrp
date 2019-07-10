package com.example.demo.pojo;

public class CallBackVO {

    public String merchantOrderNo; //商户订单号

    public String orderState; //订单状态

    public String orderPrice; //订单金额

    public String orderRealPrice; //实际金额

    public int code; //请求返回码

    public String time; //平台传送的当前时间

    public String message; //附加信息

    public String orderType; //请求类型 充值为1，提现为2

    public String merchantFee; //手续费

    public String completeTime; //完成时间

    public String DealTime; //到账时间

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderRealPrice() {
        return orderRealPrice;
    }

    public void setOrderRealPrice(String orderRealPrice) {
        this.orderRealPrice = orderRealPrice;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getMerchantFee() {
        return merchantFee;
    }

    public void setMerchantFee(String merchantFee) {
        this.merchantFee = merchantFee;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    public String getDealTime() {
        return DealTime;
    }

    public void setDealTime(String dealTime) {
        DealTime = dealTime;
    }

    @Override
    public String toString() {
        return "CallBackVO{" +
                "merchantOrderNo='" + merchantOrderNo + '\'' +
                ", orderState='" + orderState + '\'' +
                ", orderPrice='" + orderPrice + '\'' +
                ", orderRealPrice='" + orderRealPrice + '\'' +
                ", code=" + code +
                ", time='" + time + '\'' +
                ", message='" + message + '\'' +
                ", orderType='" + orderType + '\'' +
                ", merchantFee='" + merchantFee + '\'' +
                ", completeTime='" + completeTime + '\'' +
                ", DealTime='" + DealTime + '\'' +
                '}';
    }
}
