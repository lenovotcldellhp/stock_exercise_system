package com.example.demo.service.impl;

import com.example.demo.Stock;
import com.example.demo.dao.IStockDAO;
import com.example.demo.service.IStockService;

import java.util.List;

public class StockServiceImpl implements IStockService {

    IStockDAO stockDAO;
    @Override
    public int add(Stock stock) {
       // return 0;
        return stockDAO.add(stock);
    }

    @Override
    //不需要为stock表提供update功能，因此这个函数不予实现
    public int update(Stock stock) {
        return 0;
    }

    @Override
    public int delete(String code) {
        //return 0;
        return stockDAO.delete(code);
    }

    @Override
    //不需要为stock表提供view功能，因此这个函数不予实现
    public int view(Stock stock) {
        return 0;
    }

    @Override
    //不需要为stock表提供按序号查找股票详情功能（因为业务逻辑都基于股票号），因此这个函数不予实现
    public Stock findStockByCode(String code) {
        return null;
    }

    @Override
    public List<Stock> findStockList() {
       // return null;
        return stockDAO.findStockList();
    }
}
