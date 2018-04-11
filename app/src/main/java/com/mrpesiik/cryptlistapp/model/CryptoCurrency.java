package com.mrpesiik.cryptlistapp.model;

import android.support.annotation.NonNull;

import java.io.Serializable;

public final class CryptoCurrency implements Comparable<CryptoCurrency>, Serializable {

    private String id;
    private String name;
    private String symbol;
    private Integer rank; //место в топе
    private double priceRUB;
    private double priceUSD;

    public CryptoCurrency(String id, String name, String symbol, Integer rank, double priceRUB, double priceUSD){
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
        this.priceRUB = priceRUB;
        this.priceUSD = priceUSD;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public double getPriceRUB() {
        return priceRUB;
    }

    public double getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(double priceUSD) {
        this.priceUSD = priceUSD;
    }

    @Override
    public int compareTo(@NonNull CryptoCurrency o) {
        return getRank().compareTo(o.getRank());
    }
}
