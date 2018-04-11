package com.mrpesiik.cryptlistapp.model;



import org.json.JSONArray;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ICurrency {


    Call<JSONArray> getCryptoCurrencies();
}
