package com.example.demo.controller;

import com.example.demo.Greeting;
import com.example.demo.Stock;
import com.example.demo.service.IndexService;
import com.example.demo.service.TodayPriceService;
import org.springframework.stereotype.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.List;

import com.example.demo.controller.TodayPriceController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {
   // Model model;
   // model.addAttribute("stock", new Stock());
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
/*
@GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());

      //  getFiledName(model);
        return "greeting";
    }
 */
    @Autowired
    private IndexService indexService;
    private TodayPriceService todayPriceService;
    @GetMapping("/index")//首页中输出股票信息表的controller
    public String student(Model model) throws ParseException {
        List indexlist = indexService.getList();
        int i=0;
        for(i=0;i<indexlist.size();i++){
            System.out.println(indexlist.get(i));
        }
       // Stock stock=new Stock();
        model.addAttribute("indexlist", indexlist);
        model.addAttribute("stock",new Stock());
        return "index";
    }

   // @PostMapping("/todayprice")//处理“今日折线图查看”表单的controller
    public String todaySubmit(@ModelAttribute Stock stock1) {//ModelAttribute后跟参数是action
        //输出greeting对象里的内容
       // System.out.println(greeting.getId());
        //System.out.println(greeting.getContent());
        System.out.println("使用今日价格处理Controller");
        System.out.println(stock1.getStockcode());
        List pricelist=todayPriceService.getList(stock1.getStockcode(),"2018-6-15");
        //这是从表单里得到的Stockcode字符串
       // TodayPriceController.setStockcode(stock1.getStockcode());
        return "todayprice";
    }

    @PostMapping("/historyprice")//处理“历史K线图查看”表单的controller
    public String historySubmit(@ModelAttribute Stock stock2) {//ModelAttribute后跟参数是action
        //输出greeting对象里的内容
        // System.out.println(greeting.getId());
        //System.out.println(greeting.getContent());
        System.out.println("使用历史价格处理Controller");
        System.out.println(stock2.getStockcode());
        return "historyprice";
    }
}

