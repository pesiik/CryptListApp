package com.mrpesiik.cryptlistapp.model;

import android.app.Activity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.Toast;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateCurrencyManager {
    private final String API_URL = "https://api.coinmarketcap.com/";
    GsonBuilder gsonBuilder;
    HttpURLConnection urlConnection;
    String result = "";
    //JSONArray jsonArray;

    public UpdateCurrencyManager() {
        gsonBuilder = new GsonBuilder();
    }

    public void updateSwipeLayout(Activity activity, SwipeRefreshLayout swipeRefreshLayout) {

    }

    public void makeCryptoCurrenciesListFromApiWithRetrofit(Activity activity, ArrayList<CryptoCurrency> cryptoCurrencies){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ICurrency iCurrency = retrofit.create(ICurrency.class);

        Call<List<CryptoCurrency>> call = iCurrency.getCryptoCurrencies();

        call.enqueue(new Callback<List<CryptoCurrency>>() {
            @Override
            public void onResponse(Call<List<CryptoCurrency>> call, Response<List<CryptoCurrency>> response) {

                List<CryptoCurrency> cryptoCurrenciesBuffer = response.body();
                for(int i = 0; i< cryptoCurrenciesBuffer.size(); i++) {
                    try {
                        CryptoCurrency cryptoCurrency = cryptoCurrenciesBuffer.get(i);
                        cryptoCurrencies.add(cryptoCurrency);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }

            @Override
            public void onFailure(Call<List<CryptoCurrency>> call, Throwable t) {
                String message = t.getMessage();
                String message2 = call.toString();
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}




