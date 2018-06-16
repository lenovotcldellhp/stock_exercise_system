package com.example.demo.dao;

import com.example.demo.Stock;

import java.util.List;
//股票数据库操作接口
public interface IStockDAO {
    int add(Stock stock);
    int update(Stock stock);
    int delete(String code);
    int view(Stock stock);
    Stock findStockByCode(String code);
    List<Stock> findStockList();



}
