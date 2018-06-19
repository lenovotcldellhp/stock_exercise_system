package com.example.demo.service;


import com.example.demo.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.demo.StockPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<History> getHistory(String stockcode){

        System.out.println("******************************");
        String sql = "SELECT * FROM stock_history WHERE stockcode like '"+stockcode+"';";
        //String sql = "SELECT price,time FROM stockdata WHERE time like '"+date+"%';";
      //  System.out.println("SQLSQLSQLSQLSQLSQLSQLSQLSQLSQL");
        System.out.println(sql);
        return (List<History>) jdbcTemplate.query(sql, new RowMapper<History>(){

            @Override//重写方法的注解
            public History mapRow(ResultSet rs, int rowNum) throws SQLException {
                History history = new History();//新建一个history对象
                //     history.setStockcode(rs.getString("stockcode"));
                history.setStockcode(stockcode);
                history.setOpen(rs.getFloat("open"));
                history.setClose(rs.getFloat("close"));
                history.setHighest(rs.getFloat("highest"));
                history.setLowest(rs.getFloat("lowest"));
                history.setDate(rs.getString("date"));


               // history.setPrice(rs.getFloat("price"));
              //  System.out.println(rs.getFloat("price"));
//
              //  history.setStockcode(stockcode);
                //  stock.setHolding(rs.getInt("holding"));
                //     System.out.println(rs);

             //   System.out.println(rs.getString("time"));
             //   history.setTime(rs.getString("time"));
                //  System.out.println(rs.getString("stockname"));
                // System.out.println(rs.getInt("holding"));

                return history;
                //  return null;
            }

        });

    }
}
