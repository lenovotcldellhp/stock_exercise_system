package com.example.demo;

public class Stock {
    private String stockcode;
    private String stockname;
    private int holding;
    private float newest_price;

    public void setNewest_price(float newest_price){
        this.newest_price=newest_price;
    }

    public float getNewest_price(){
        return this.newest_price;
    }

    public String getStockcode() {

        return stockcode;
    }

    public void setStockcode(String stockcode) {

        this.stockcode = stockcode;
    }

    public String getStockname() {

        return stockname;
    }

    public void setStockname(String stockname) {

        this.stockname = stockname;
    }

    public int getHolding(){
        return holding;
    }

    public void setHolding(int holding){
        this.holding=holding;
    }
}
