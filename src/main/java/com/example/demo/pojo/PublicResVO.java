package com.example.demo.pojo;

public class PublicResVO {

    public int code; //返回码

    public String errMsg; //返回描述

    public String result; //返回业务参数:json格式

    public String sign; //签名

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
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
        return "PublicResVO{" +
                "code=" + code +
                ", errMsg='" + errMsg + '\'' +
                ", result='" + result + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
