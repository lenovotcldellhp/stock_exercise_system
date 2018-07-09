package com.example.demo.controller;


import com.example.demo.service.NewsService;
import com.example.demo.service.RecordService;
//import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/news")//输出交易记录
    public String student(Model model) throws ParseException {
        List indexlist = newsService.getList();
        int i = 0;
        //   for(i=0;i<indexlist.size();i++){
        //      System.out.println(indexlist.get(i));
        // }
        // Stock stock=new Stock();
        model.addAttribute("indexlist", indexlist);
        //   model.addAttribute("stock",new Stock());

        //   Stockbuy buy=new Stockbuy();

        //   model.addAttribute("buy",buy);//用于买入表单
        //  User user=new User();
        //  user.setBalance(buyservice.getBalance());
        //   model.addAttribute("user",user);//用于显示剩余本金

        return "news";

    }
}
