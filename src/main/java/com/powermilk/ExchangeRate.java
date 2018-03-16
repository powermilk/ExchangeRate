package com.powermilk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Comparator;

public class ExchangeRate {

    private static URL url;
    private static InputStreamReader reader;
    private static ExchangeDataPOJO exchangeDataPOJO;

    private final Comparator<RatePOJO> comp = (Comparator.comparingDouble(RatePOJO::getMid));

    public ExchangeRate(String urlAddress) {
        try {
            url = new URL(urlAddress);
            reader = new InputStreamReader(url.openStream());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            exchangeDataPOJO = gson.fromJson(reader, ExchangeDataPOJO.class);
            System.out.println(exchangeDataPOJO);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public ExchangeRate(FileReader reader) {
        exchangeDataPOJO = new Gson().fromJson(reader, ExchangeDataPOJO.class);
    }

    public double getMin() {
        return exchangeDataPOJO.getRates().stream().min(comp).get().getMid();
    }

    public double getMax() {
        return exchangeDataPOJO.getRates().stream().max(comp).get().getMid();
    }
}
