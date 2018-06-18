package com.example.demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.demo.StockPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class TodayPriceService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<StockPrice> getList(String stockcode, String date){
        System.out.println("******************************");
        String sql = "SELECT price,time FROM stockdata WHERE time like '"+date+"%' and stockcode like '"+stockcode+"';";
        //String sql = "SELECT price,time FROM stockdata WHERE time like '"+date+"%';";
        System.out.println("SQLSQLSQLSQLSQLSQLSQLSQLSQLSQL");
        System.out.println(sql);
        return (List<StockPrice>) jdbcTemplate.query(sql, new RowMapper<StockPrice>(){

            @Override//重写方法的注解
            public StockPrice mapRow(ResultSet rs, int rowNum) throws SQLException {
                StockPrice stockprice = new StockPrice();//新建一个stockprice对象
           //     stockprice.setStockcode(rs.getString("stockcode"));

                stockprice.setPrice(rs.getFloat("price"));
                System.out.println(rs.getFloat("price"));

                stockprice.setStockcode(stockcode);
              //  stock.setHolding(rs.getInt("holding"));
                //     System.out.println(rs);

                  System.out.println(rs.getString("time"));
                stockprice.setTime(rs.getString("time"));
                //  System.out.println(rs.getString("stockname"));
                // System.out.println(rs.getInt("holding"));

                return stockprice;
                //  return null;
            }

        });
    }


}
