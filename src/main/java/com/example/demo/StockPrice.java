package com.example.demo;

public class StockPrice {
    private String stockcode;
    private float price;
    private String time;
    public String getStockcode(){
        return this.stockcode;
    }

    public float getPrice(){
        return this.price;
    }

    public void setStockcode(String stockcode){
        this.stockcode=stockcode;
    }

    public void setPrice(float price){
        this.price=price;
    }

    public String getTime(){
        return this.time;
    }
    public void setTime(String time){
        this.time=time;
    }
}
