package com.example.demo.controller;

import com.example.demo.BuyResult;
import com.example.demo.Stock;
import com.example.demo.User;
import com.example.demo.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ManageController {
    @Autowired
    private ManageService manageService;

    @GetMapping("/manage")
    public String addStock(Model model){
        Stock stock=new Stock();
        User user=new User();
        model.addAttribute("stock",stock);
        model.addAttribute("user",user);
        return "manage";
    }

    @PostMapping("/addstock")
    public String addStockSubmit(Model model, @ModelAttribute Stock addstock){
        String stockcode=addstock.getStockcode();
        String stockname=addstock.getStockname();
        float password=addstock.getNewest_price();//借用"newest_price"字段当作管理密码
        BuyResult buyResult=new BuyResult();

        System.out.println(stockcode);
        System.out.println(stockname);

        buyResult.setStockcode(stockcode);
        buyResult.setType("添加股票");

        if(password==233333) {//密码正确
            buyResult.setResult("操作完成");

             manageService.addStock(stockcode,stockname);
        }
        if(password!=233333){//密码错误
            buyResult.setResult("操作失败，因为您输入的管理密码有误。");

            // manageService.addStock(stockcode,stockname);
        }
        buyResult.setPrice(0000000000000000000000000000000000);


        model.addAttribute("buyResult",buyResult);
        return "buyresult";
    }

    @PostMapping("/delstock")
    public String delStockSubmit(Model model, @ModelAttribute Stock addstock){
        String stockcode=addstock.getStockcode();
        String stockname=addstock.getStockname();
        float password=addstock.getNewest_price();//借用"newest_price"字段当作管理密码
        BuyResult buyResult=new BuyResult();

        System.out.println(stockcode);
        System.out.println(stockname);

        buyResult.setStockcode(stockcode);
        buyResult.setType("删除股票");

        if(password==233333) {//密码正确
            buyResult.setResult("操作完成");
            manageService.deleteStock(stockcode);
           // manageService.addStock(stockcode,stockname);
        }
        if(password!=233333){//密码错误
            buyResult.setResult("操作失败，因为您输入的管理密码有误。");

            // manageService.addStock(stockcode,stockname);
        }
        buyResult.setPrice(0000000000000000000000000000000000);


        model.addAttribute("buyResult",buyResult);
        return "buyresult";
    }

    @PostMapping("/setbalance")
    public String delStockSubmit(Model model, @ModelAttribute User user){
        float balance=user.getBalance();
        String password=user.getUsername();//借用"username"字段当作管理密码
        BuyResult buyResult=new BuyResult();

      //  System.out.println(stockcode);
      //  System.out.println(stockname);

        buyResult.setStockcode("不存在的，这次是修改本金，所以没有股票号。");
        buyResult.setType("修改本金");
        System.out.println("====PASSWORD======");
        System.out.println(password);

        if(password.equals("233333")) {//密码正确
            buyResult.setResult("操作完成");
            manageService.setBalance(balance);
            // manageService.addStock(stockcode,stockname);
        }
        else{//密码错误
            buyResult.setResult("操作失败，因为您输入的管理密码有误。");

            // manageService.addStock(stockcode,stockname);
        }
        buyResult.setMoney(balance);
        buyResult.setPrice(0000000000000000000000000000000000);


        model.addAttribute("buyResult",buyResult);
        return "buyresult";
    }

}
