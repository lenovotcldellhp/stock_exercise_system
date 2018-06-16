package com.example.demo.service;

import com.example.demo.Stock;

import java.util.List;

public interface IStockService {
    int add(Stock stock);
    int update(Stock stock);
    int delete(String code);
    int view(Stock stock);
    Stock findStockByCode(String code);
    List<Stock> findStockList();


}
