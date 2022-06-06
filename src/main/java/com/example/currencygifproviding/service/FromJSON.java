package com.example.currencygifproviding.service;

import lombok.experimental.UtilityClass;
import org.json.JSONException;
import org.json.JSONObject;

@UtilityClass
public class FromJSON {
    public static String getURL(JSONObject jsonObject){
        try {
            jsonObject = jsonObject.getJSONArray("data").getJSONObject(0).getJSONObject("images").getJSONObject("original");
            return  jsonObject.getString("url");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static double getPrice(JSONObject jsonObject, String currencyName){
        try {
            jsonObject = jsonObject.getJSONObject("rates");
            return Double.parseDouble(jsonObject.getString(currencyName));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }
}
