package com.example.demo.controller;

import com.example.demo.BuyResult;
import com.example.demo.Greeting;
import com.example.demo.Stockbuy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.service.BuyService;


@Controller
public class BuyController {

    @Autowired
    private BuyService buyservice;

    public BuyResult buyResult;
    public int count;
    public String stockcode;
    public Stockbuy stockbuy;

    @GetMapping("/buy")
    public String buyForm(Model model){//交易表单接收
        Stockbuy buy=new Stockbuy();
       // float balance=buyservice.getBalance();
        model.addAttribute("buy",buy);
      //  model.addAttribute("balance",balance);
       // model.addAttribute("stockcode",stockcode);//股票号码输入
       // model.addAttribute("count",count);//股票购买量输入
        //buyservice.getBalance();//getBalance确认工作正常
        //buyservice.setBalance(122500);//setBalance确认工作正常
        //buyservice.getHolding("sh600519");//getHolding确认工作正常
      //  buyservice.setHolding("sh600519",10);//setHolding确认工作正常
      //  buyservice.getNewestprice("sh603321");//getNewestprice确认工作正常

        return "buy";
    }


    @PostMapping("/buy")
    public String buySubmit(Model model,@ModelAttribute Stockbuy buy) {
        //输出greeting对象里的内容
      // System.out.println(buy.getStockcode());//工作正常
      //  System.out.println(buy.getCount());//工作正常
        System.out.println("使用第一个表单处理买卖的Controller");
        String stockcode=buy.getStockcode();//要买卖的股票号码
        String countstr=buy.getCount();//要买卖的股票数量，字符串形式
        int count=Integer.valueOf(countstr);//要买卖的股票数量，数字形式

        float price=buyservice.getNewestprice(stockcode);//购买时，该股票的最新价格
        float balance=buyservice.getBalance();//首先，得到用户当前的本金数额
        int origin_count=buyservice.getHolding(stockcode);//这支股票原有的持有量
        float money=count*price;//本次交易（如果能完成的话）所需花费的金额


        BuyResult buyResult=new BuyResult();
        buyResult.setCount(count);

        buyResult.setMoney(money);
        buyResult.setPrice(price);
        buyResult.setStockcode(stockcode);
        buyResult.setType("买入");

        //首先，我们要判断一下现有的本金够不够买这么多股票
        if(balance<money){//如果现有余额不够买这些股票
            buyResult.setResult("交易失败：您的现有本金已不足以购买这些股票。");
        }
        if(balance>=money){//如果余额足够，则继续
            //新的股票持有量=原持有量+要买的量
            int new_count=origin_count+count;

            //新的本金=原本金-花掉的钱
            float new_balance=balance-money;

            //接下来存储这两个数据
            buyservice.setHolding(stockcode,new_count);
            buyservice.setBalance(new_balance);

            //提示文字
            buyResult.setResult("交易成功。");
        }

        int new_count;//交易后的股票数量


      //  buyResult.setResult("假装交易进行的很成功");

        model.addAttribute("buyResult",buyResult);

        return "buyresult";
    }
  //  @PostMapping("/buy")
   // public String buySubmit(Model model, @ModelAttribute )

}
