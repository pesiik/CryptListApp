package com.mrpesiik.cryptlistapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import com.mrpesiik.cryptlistapp.model.CryptoCurrency;
import com.mrpesiik.cryptlistapp.model.CryptoCurrencyAdapter;
import com.mrpesiik.cryptlistapp.model.UpdateCurrencyManager;

import java.util.ArrayList;

public class CryptActivity extends AppCompatActivity {

    CryptoCurrencyAdapter adapter;
    UpdateCurrencyManager currencyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypt);
        currencyManager = new UpdateCurrencyManager();
        ListView listView = (ListView)findViewById(R.id.currency_list);
        ArrayList<CryptoCurrency> cryptoCurrencies = new ArrayList<>();
        currencyManager.makeCryptoCurrenciesListFromApiWithRetrofit(this, cryptoCurrencies);
        adapter= new CryptoCurrencyAdapter(this, R.layout.crypto_currency_item, R.id.id_currency, cryptoCurrencies, this);
        listView.setAdapter(adapter);
    }


}
