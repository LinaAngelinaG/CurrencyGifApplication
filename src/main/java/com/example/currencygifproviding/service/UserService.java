package com.example.currencygifproviding.service;

import com.example.currencygifproviding.client.CurrencyClient;
import com.example.currencygifproviding.client.GifClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UserService {
    @Autowired
    private CurrencyClient currencyClient;
    @Autowired
    private GifClient gifClient;
    private final String[] rating = {"g", "pg", "pg-13", "r"};
    private final int gifOffsetMax = 400;

    public String isGreaterThanYesterday(String currencyName) {
        double priceNow = getPriceForToday(currencyName);
        double priceTomorrow = getPriceForTomorrow(currencyName);
        return getResponseFromGifClient(priceNow, priceTomorrow);
    }

    private String getResponseFromGifClient(double priceNow, double priceTomorrow) {
        try {
            String q = Double.valueOf(priceNow) - Double.valueOf(priceTomorrow) >= 0 ? "rich" : "broke";
            int rand = (int) (Math.random() * gifOffsetMax);
            Gson gson = new Gson();
            JSONObject json = new JSONObject(gson.toJson(gifClient.getGifFromCuurencyMovement(q, rand, rating[rand % rating.length])));
            return FromJSON.getURL(json);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private double getPriceForToday(String curName) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneOffset.UTC);
            Gson gson = new Gson();
            JSONObject json = new JSONObject(
                    gson.toJson(
                            currencyClient.getPrice(
                                    dtf.format(ZonedDateTime.now().plusDays(-1)) + ".json")));
            return FromJSON.getPrice(json, curName);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private double getPriceForTomorrow(String curName) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneOffset.UTC);
            Gson gson = new Gson();
            JSONObject json = new JSONObject(
                    gson.toJson(
                            currencyClient.getPrice(
                                    dtf.format(ZonedDateTime.now()) + ".json")));
            return FromJSON.getPrice(json, curName);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

}