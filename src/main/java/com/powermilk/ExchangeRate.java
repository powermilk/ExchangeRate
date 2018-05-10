package com.powermilk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Comparator;
import java.util.Optional;

public class ExchangeRate {

    private static URL url;
    private static InputStreamReader reader;
    private static ExchangeDataPOJO exchangeDataPOJO;

    private final Comparator<RatePOJO> comparator = (Comparator.comparingDouble(RatePOJO::getMid));

    public ExchangeRate(String urlAddress) throws IOException {
        try {
            url = new URL(urlAddress);
            reader = new InputStreamReader(url.openStream());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            exchangeDataPOJO = gson.fromJson(reader, ExchangeDataPOJO.class);
            System.out.println(exchangeDataPOJO);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public ExchangeRate(FileReader reader) {
        exchangeDataPOJO = new Gson().fromJson(reader, ExchangeDataPOJO.class);
    }

    double getMin() throws Exception {
        Optional<RatePOJO> value = exchangeDataPOJO.getRates().stream().min(comparator);

        if (value.isPresent()) {
            return value.get().getMid();
        }

        throw new Exception("I can't get minimal value");
    }

    double getMax() throws Exception {
        Optional<RatePOJO> value = exchangeDataPOJO.getRates().stream().max(comparator);

        if (value.isPresent()) {
            return value.get().getMid();
        }

        throw new Exception("I can't get maximum value");
    }
}
