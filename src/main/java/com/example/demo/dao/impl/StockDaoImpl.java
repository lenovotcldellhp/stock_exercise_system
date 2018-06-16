package com.example.demo.dao.impl;

import com.example.demo.Stock;
import com.example.demo.dao.IStockDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.List;
//对数据库stock表的操作函数，提供：获取所有股票的名称及编号、插入股票信息、删除股票信息功能
public class StockDaoImpl implements IStockDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;//创建一个JdbcTemplate类的对象用于本次数据库操作
//增加股票
    @Override
    public int add(Stock stock) {
        return jdbcTemplate.update("insert into stocks(stockcode, stockname) values(?, ?)",stock.getStockcode(),stock.getStockname());
     //   return 0;
    }
//不需要为stock表提供update功能，因此这个函数不予实现
    @Override
    public int update(Stock stock) {
         return 0;
    }
//删除股票
    @Override
    public int delete(String code) {
        return jdbcTemplate.update("DELETE from stocks account where stockcode=?",code);
        // return 0;
    }

//因为并不需要获取Stock类的对象，因此这个函数不予实现
    @Override
    public int view(Stock stock) {
        return 0;
    }
//因为并不需要“按序号找股票详情”功能（所有业务逻辑直接用股票序号），所以这个函数不予实现
    @Override
    public Stock findStockByCode(String code) {
        return null;
    }
//一次列出表中所有的股票详情（股票号和股票名）
    @Override
    public List<Stock> findStockList() {
       // return null;
        List<Stock> list = jdbcTemplate.query("select * from stocks", new Object[]{}, new BeanPropertyRowMapper(Stock.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            System.out.println("未能得到股票数据！");
            return null;
        }
    }
}
