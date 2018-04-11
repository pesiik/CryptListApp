package com.mrpesiik.cryptlistapp.model;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrpesiik.cryptlistapp.R;

import java.util.ArrayList;
import java.util.List;


public final class CryptoCurrencyAdapter extends ArrayAdapter<CryptoCurrency> {

    Activity activity;
    ArrayList<CryptoCurrency> cryptoCurrencies;

    public CryptoCurrencyAdapter(@NonNull Context context, int resource, int textViewResourceId, List<CryptoCurrency> objects, Activity activity) {
        super(context, resource, textViewResourceId, objects);

        this.activity= activity;
        cryptoCurrencies = new ArrayList<>(objects);
       //Comparator<CryptoCurrency> comparator = (o1, o2) -> o1.compareTo(o2);
       //objects.sort(comparator); todo
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;

        if(row == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            row = inflater.inflate(R.layout.crypto_currency_item, parent, false);
        }
        ImageView icon = (ImageView) row.findViewById(R.id.icon);
        icon.setImageResource(R.drawable.btc);

        TextView idCurrency = (TextView)row.findViewById(R.id.id_currency);
        idCurrency.setText(cryptoCurrencies.get(position).getId());


        return row;
    }
}
