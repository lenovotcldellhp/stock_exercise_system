package com.example.demo.controller;

import com.example.demo.Stock;
import com.example.demo.Stockbuy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.service.RecordService;
import java.text.ParseException;
import java.util.List;


/*
@GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());

      //  getFiledName(model);
        return "greeting";
    }
 */

@Controller
public class RecordController {
    @Autowired
    private RecordService recordService;
    @GetMapping("/record")//输出交易记录
    public String student(Model model) throws ParseException {
        List indexlist = recordService.getList();
        int i=0;
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

        return "record";
    }
}
