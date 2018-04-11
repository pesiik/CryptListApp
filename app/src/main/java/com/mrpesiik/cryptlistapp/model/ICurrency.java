package com.mrpesiik.cryptlistapp.model;



import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ICurrency {

    @GET("v1/ticker/?convert=RUB&limit=10")
    Call<List<CryptoCurrency>> getCryptoCurrencies();
}
