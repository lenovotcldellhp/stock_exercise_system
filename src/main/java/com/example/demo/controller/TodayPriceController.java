package com.example.demo.controller;

import com.example.demo.Greeting;
import com.example.demo.Stock;
import com.example.demo.StockPrice;
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
@Controller
public class TodayPriceController {
    public String stockcode;
    Stock stock1=new Stock();
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private TodayPriceService todayPriceService;
    @GetMapping("/todayprice")
    public String todaypriceForm(Model model) {

        model.addAttribute("stock", stock1);
        System.out.println("%%%%%%%%%%%%%");
     //   System.out.println()
        System.out.println(model.toString());
      //  System.out.println(stock1.getStockcode());
        //  getFiledName(model);
        return "todayprice";
    }

    public void gettingStockcode(@ModelAttribute Stock stock2) {

        System.out.println(stock2.getStockcode());
    }
    @PostMapping("/todayprice")
    public String todaypriceSubmit(Model model,@ModelAttribute Stock stock){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(stock.getStockcode());
        System.out.println("#####################");
        //System.out.println(this.gettingStockcode);
   // public String todaypriceSubmit(@ModelAttribute List<StockPrice> stockPriceList) {
        //输出stock对象里的内容
      //  System.out.println(stock.getStockcode());
        //System.out.println(greeting.getContent());

        List <StockPrice> stockPriceList=todayPriceService.getList(stock.getStockcode(),"2018-06-27");
        //6月19日上午：现在正在集合竞价，无法获取实时价格，所以还是得用15日数据
        System.out.println(stockPriceList.size());
     //   System.out.println(stockPriceList.get(2).getPrice());
        model.addAttribute("stockPriceList", stockPriceList);

        return "todaypriceresult";
    }



    /*
    @PostMapping("/todayprice")
    public String todaypriceSubmit(@ModelAttribute Stock stock){
        return "todaypriceresult";
    }*/



    /*
    @PostMapping("/greeting")
    public String todaypriceSubmit(@ModelAttribute StockPrice stockPrice) {
        //输出greeting对象里的内容
     //   System.out.println(greeting.getId());
      //  System.out.println(greeting.getContent());
        System.out.println("今日价格处理Controller");
        return "result";
    }
    */

/*
    @GetMapping("/todayprice")
    public String student(Model model) throws ParseException {

        List pricelist = todayPriceService.getList("sh600519","2018-06-05");
        System.out.println();

            return "todayprice";
    }
*/
    public void setStockcode(String stockcode){
        this.stockcode=stockcode;
    }
}
