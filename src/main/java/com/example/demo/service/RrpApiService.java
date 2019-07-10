package com.example.demo.service;

import com.alibaba.fastjson.JSON;
import com.example.demo.constant.PublicParam;
import com.example.demo.pojo.*;
import com.example.demo.tools.AESUtil;
import com.example.demo.tools.HttpReqUtil;
import com.example.demo.tools.Md5Util;
import com.example.demo.tools.RecordNoUtils;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RrpApiService {


    /**
     * 充值
     *
     * @param depositVO
     * @return
     */
    public String deposit(DepositVO depositVO) {

        PublicReqVO req = new PublicReqVO();

        req.action = PublicParam.DEPOSIT;
        req.merchantAccount = PublicParam.MERCHANT_ACCOUNT;

        //--------------商户接入rrp接口时，这些个必填参数自行处理，这里写死只是为了便于演示demo
        depositVO.merchantOrderNo = RecordNoUtils.get();
        depositVO.channel=2;
        depositVO.callBackURL=PublicParam.CALL_BACK_URL;
        //--------------

        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("MerchantOrderNo", depositVO.merchantOrderNo);
        paramMap.put("Channel", depositVO.channel);
        paramMap.put("OrderPrice", depositVO.orderPrice);
        paramMap.put("CallBackUrl", depositVO.callBackURL);

        req.data = getReqEncryptData(paramMap);
        req.sign = getReqSign(req);

        JSONObject resJson = sendPost(req);

        String res = getRes(resJson);
        return res;

    }

    /**
     * 提现
     *
     * @param withdrawVO
     * @return
     */
    public String withdraw(WithdrawVO withdrawVO) {


        PublicReqVO req = new PublicReqVO();

        req.action = PublicParam.WITHDRAW;
        req.merchantAccount = PublicParam.MERCHANT_ACCOUNT;

        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("MerchantOrderNo", withdrawVO.merchantOrderNo);
        paramMap.put("CardNo", withdrawVO.cardNo);
        paramMap.put("CardName", withdrawVO.cardName);
        paramMap.put("Channel", withdrawVO.channel);
        paramMap.put("OrderPrice", withdrawVO.orderPrice);
        paramMap.put("CallBackUrl", withdrawVO.callBackURL);

        req.data = getReqEncryptData(paramMap);
        req.sign = getReqSign(req);

        JSONObject resJson = sendPost(req);

        String res = getRes(resJson);
        return res;
    }

    /**
     * 查询通道
     *
     * @param
     * @return
     */
    public String queryBankList() {


        PublicReqVO req = new PublicReqVO();

        req.action = PublicParam.QUERY_BANK_LIST;
        req.merchantAccount = PublicParam.MERCHANT_ACCOUNT;

        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("UserLevel", "");//非必填

        req.data = getReqEncryptData(paramMap);
        req.sign = getReqSign(req);

        JSONObject resJson = sendPost(req);

        String res = getRes(resJson);
        return res;
    }

    /**
     * 查询订单
     *
     * @param
     * @return
     */
    public String queryOrder(QueryOrderVO queryOrderVO) {

        PublicReqVO req = new PublicReqVO();

        req.action = PublicParam.QUERY_ORDER;
        req.merchantAccount = PublicParam.MERCHANT_ACCOUNT;

        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("MerchantOrderNo", queryOrderVO.merchantOrderNo);

        req.data = getReqEncryptData(paramMap);
        req.sign = getReqSign(req);

        JSONObject resJson = sendPost(req);

        String res = getRes(resJson);
        return res;
    }

    /**
     * 接收回调
     * 商户收到回调后, 如果没有问题（回调带来的参数值经过md5加密后计算出的sign与回调带来的sign相同，则认为没有问题，sign计算见下面备注）, 需要回传SUCCESS
     *
     * @param
     * @return
     */
    public String callBack(CallBackReqVO callBackReqVO) {

        System.out.println("rrp callback req param:" + callBackReqVO);

        if (!callBackReqVO.merchantAccount.isEmpty() && !callBackReqVO.sign.isEmpty() && !callBackReqVO.result.isEmpty()) {

            String reqResultData = "";
            try {
                //解密result
                reqResultData = AESUtil.decrypt(PublicParam.AES_KEY, callBackReqVO.result);
            } catch (Exception e) {
                System.out.println(e);
            }

            JSONObject reqJson = JSONObject.fromObject(reqResultData);

            Map<String,Object> paramMap = new HashMap<>();
            paramMap.put("MerchantOrderNo",reqJson.getString("MerchantOrderNo"));
            paramMap.put("OrderState",reqJson.getString("OrderState"));
            paramMap.put("OrderPrice",reqJson.getString("OrderPrice"));
            paramMap.put("OrderRealPrice",reqJson.getString("OrderRealPrice"));
            paramMap.put("Code",reqJson.getInt("Code"));
            paramMap.put("Time",reqJson.getString("Time"));
            paramMap.put("Message",reqJson.getString("Message"));
            paramMap.put("OrderType",reqJson.getInt("OrderType"));
            paramMap.put("MerchantFee",reqJson.getString("MerchantFee"));
            paramMap.put("CompleteTime",reqJson.getString("CompleteTime"));
            paramMap.put("DealTime",reqJson.getString("DealTime"));

            String encryptData=getReqEncryptData(paramMap);

            //获取sign
            String sign = Md5Util.md5Sign("MerchantAccount="+PublicParam.MERCHANT_ACCOUNT+"&Result="+encryptData+"&Key="+PublicParam.SECRET);
            if (sign.equals(callBackReqVO.sign)){
                System.out.println("callBack success.");
                //处理业务逻辑
                return "SUCCESS";
            }




            System.out.println("callBack decrypt req reqResultData:" + reqResultData);
        }

        return "";
    }

    /**
     * 得到加密业务参数的data
     *
     * @param paramMap
     * @return
     */
    public static String getReqEncryptData(Map<String, Object> paramMap) {
        System.out.println("getReqEncryptData.paramMap to String:" + JSON.toJSONString(paramMap));
        String encryptData = "";
        try {
            encryptData = AESUtil.encodeHexStr(AESUtil.encrypt(PublicParam.AES_KEY, JSON.toJSONString(paramMap)), false);
            System.out.println(("getReqEncryptData.encryptData:" + encryptData));
        } catch (Exception e) {
            System.out.println(e);
        }
        return encryptData;
    }

    /**
     * 得到Sign
     *
     * @param req
     * @return
     */
    public static String getReqSign(PublicReqVO req) {
        //使用seckey对除sign以外的公共参数进行md5加密生成sign值
        String toSignStr = "Action=" + req.action + "&Data=" + req.data + "&MerchantAccount=" + req.merchantAccount + "&Key=" + PublicParam.SECRET;
        String reqSign = Md5Util.md5Sign(toSignStr).toUpperCase();
        System.out.println("getReqSign.reqSign:" + reqSign);
        return reqSign;
    }

    /**
     * 发送请求并接收响应
     */
    public static JSONObject sendPost(PublicReqVO req) {
        String postParam = "Action=" + req.action + "&Data=" + req.data + "&MerchantAccount=" + req.merchantAccount + "&Sign=" + req.sign;
        //发送请求到rrp
        String res = HttpReqUtil.sendPost(PublicParam.RRP_PUBLIC_URL, postParam, false);
        System.out.println("sendPost.rrp.res:" + res);
        JSONObject resJson = JSONObject.fromObject(res);
        System.out.println("res str to json:" + resJson);
        return resJson;
    }

    /**
     * 接收响应并处理
     */
    public static String getRes(JSONObject resJson) {
        //处理rrp的成功响应
        if (resJson.getInt("Code") == 0) {

            PublicResVO publicResVO = new PublicResVO();

            publicResVO.code = resJson.getInt("Code");
            publicResVO.sign = resJson.getString("Sign");
            publicResVO.result = resJson.getString("Result");
            publicResVO.errMsg = resJson.getString("ErrMsg");

            //对比签名正确
            if (AESUtil.verifySign(publicResVO)) {
                //解密响应
                try {
                    String resData = AESUtil.decrypt(PublicParam.AES_KEY, publicResVO.result);
                    System.out.println("res.data :" + resData);
                    return resData;
                } catch (Exception e) {
                    System.out.println(e);
                    return resJson.toString();
                }
            }

        } else {
            System.out.println("====================rrp response failed========================" + "Code:" + resJson.getString("Code") + ";ErrMsg:" + resJson.getString("ErrMsg"));
            return resJson.toString();
        }
        return resJson.toString();
    }


}
