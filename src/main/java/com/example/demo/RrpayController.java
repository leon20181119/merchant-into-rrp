package com.example.demo;


import com.example.demo.pojo.*;
import com.example.demo.service.RrpApiService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@RestController //该注解使项目支持Rest
@SpringBootApplication
@RequestMapping(value = "/rrpay") //该注解表示该controller类下的所有的方法都公用的一级上下文根
public class RrpayController {

    /**
     * 处理deposit 表单提交过来的数据
     */
    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public String deposit(DepositVO depositVO) {
        RrpApiService service = new RrpApiService();
        return service.deposit(depositVO);
    }


    /**
     * 提现
     */
    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public String withdraw(WithdrawVO withdrawVO) {

        RrpApiService service = new RrpApiService();

        return service.withdraw(withdrawVO);
    }

    /**
     * 查询通道
     */
    @RequestMapping(value = "/queryBankList", method = RequestMethod.GET)
    public String queryBankList() {

        RrpApiService service = new RrpApiService();
        return service.queryBankList();
    }

    /**
     * 查询订单
     */
    @RequestMapping(value = "/queryOrder", method = RequestMethod.POST)
    public String queryOrder(QueryOrderVO queryOrderVO) {

        RrpApiService service = new RrpApiService();

        return service.queryOrder(queryOrderVO);
    }

    /**
     * 接收rrp回调
     */
    @RequestMapping(value = "/callBack", method = RequestMethod.POST)
    public String queryOrder(CallBackReqVO callBackReqVO) {

        RrpApiService service = new RrpApiService();

        return service.callBack(callBackReqVO);
    }

}




