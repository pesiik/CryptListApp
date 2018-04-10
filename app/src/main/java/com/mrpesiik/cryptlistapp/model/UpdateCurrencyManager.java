package com.mrpesiik.cryptlistapp.model;

import android.app.Activity;
import android.provider.Settings;
import android.support.v4.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.internal.util.ArrayListSupplier;

public class UpdateCurrencyManager {
    private final String API_URL = "https://api.coinmarketcap.com/v1/ticker/?convert=RUB&limit=10";
    GsonBuilder gsonBuilder;
    HttpURLConnection urlConnection;

    public UpdateCurrencyManager() {
        gsonBuilder = new GsonBuilder();
    }

    public void updateSwipeLayout(Activity activity, SwipeRefreshLayout swipeRefreshLayout) {

    }

    private ArrayList<Cryptocurrency> ParseCryptFromJson() {
        ArrayList<Cryptocurrency> cryptocurrencies = new ArrayList<>();

        return cryptocurrencies;
    }

    private JsonArray getJsonFromApi() {

        BufferedReader reader;

        try {
            URL url = new URL(API_URL);
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer stringBuffer = new StringBuffer();

                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuffer.append(line);
                }

                String result = stringBuffer.toString();
                //JsonArray jsonArray = new JsonArray(result);

                return new JsonArray();
            } catch (IOException ioExc) {

            }

        } catch (MalformedURLException malformedException) {
            malformedException.printStackTrace();
        }
        return null;
    }
}

