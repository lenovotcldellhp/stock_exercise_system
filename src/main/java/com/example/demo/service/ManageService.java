package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ManageService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setBalance(float balance) {//更新用户的本金信息
        String balancestr = String.valueOf(balance);
        String insertSql = "update user set balance=" + balancestr + "where username='xps';";
        int rows = jdbcTemplate.update(insertSql);
    }

    public void addStock(String stockcode,String stockname){//加股票
        String sql="insert into stocks(stockcode,stockname) values '"+stockcode+"','"+stockname+"';";
        int rows = jdbcTemplate.update(sql);
    }

    public void deleteStock(String stockcode){//删股票
        String sqldel="delete from stocks where stockcode='"+stockcode+"';";
        int rows=jdbcTemplate.update(sqldel);
    }
}
