package com.mrpesiik.cryptlistapp.model;

import android.app.Activity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateCurrencyManager {
    private final String API_URL = "https://api.coinmarketcap.com/v1/ticker/?convert=RUB&limit=10";
    GsonBuilder gsonBuilder;
    HttpURLConnection urlConnection;
    String result = "";
    //JSONArray jsonArray;

    public UpdateCurrencyManager() {
        gsonBuilder = new GsonBuilder();
    }

    public void updateSwipeLayout(Activity activity, SwipeRefreshLayout swipeRefreshLayout) {

    }

    public ArrayList<CryptoCurrency> makeCryptoCurrenciesListFromApiWithRetrofit(Activity activity){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
               .addConverterFactory(GsonConverterFactory.create())
                .build();

        ArrayList<CryptoCurrency> cryptoCurrencies = new ArrayList<>();
        ICurrency iCurrency = retrofit.create(ICurrency.class);

        Call<JSONArray> call = iCurrency.getCryptoCurrencies();

        call.enqueue(new Callback<JSONArray>() {
            @Override
            public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
            JSONArray jsonArray = response.body();
                for(int i = 0; i< jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                        String id = jsonObject.getString("id");
                        String name = jsonObject.getString("name");
                        String symbol = jsonObject.getString("symbol");
                        Integer rank = jsonObject.getInt("rank");
                        double priceRUB = jsonObject.getDouble("price_rub");
                        double priceUSD = jsonObject.getDouble("price_usd");
                        CryptoCurrency cryptoCurrency = new CryptoCurrency(id, name, symbol, rank, priceRUB, priceUSD);
                        cryptoCurrencies.add(cryptoCurrency);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<JSONArray> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return cryptoCurrencies;
    }
}




