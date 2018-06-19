package com.example.demo.controller;

import com.example.demo.History;
import com.example.demo.Stock;
import com.example.demo.service.HistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HistoryController {

    Stock stock1=new Stock();
    private static final Logger logger= LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private HistoryService historyService;

    @GetMapping("/history")
    public String todaypriceForm(Model model) {

        model.addAttribute("stock", stock1);
        System.out.println("%%%%%%%%%%%%%");
        //   System.out.println()
        System.out.println(model.toString());
        //  System.out.println(stock1.getStockcode());
        //  getFiledName(model);
        return "history";
    }

    @PostMapping("/history")
    public String todaypriceSubmit(Model model,@ModelAttribute Stock stock){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(stock.getStockcode());
        System.out.println("#####################");
        //System.out.println(this.gettingStockcode);
        // public String todaypriceSubmit(@ModelAttribute List<StockPrice> stockPriceList) {
        //输出stock对象里的内容
        //  System.out.println(stock.getStockcode());
        //System.out.println(greeting.getContent());

        List<History> stockHistoryList=historyService.getHistory(stock.getStockcode());

        System.out.println(stockHistoryList.size());
        //   System.out.println(stockHistoryList.get(2).getPrice());
        System.out.println(stock.getStockcode());
        model.addAttribute("stockHistoryList", stockHistoryList);

        return "historyresult";
    }


}
