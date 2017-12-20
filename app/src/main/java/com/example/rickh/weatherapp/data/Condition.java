package com.example.rickh.weatherapp.data;

import org.json.JSONException;
import org.json.JSONObject;

public class Condition implements JSONPopulator {
    private String code;
    private int temperature;
    private String description;

    public String getCode() {
        return code;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void populate(JSONObject data) {
        code = data.optString("code");
        temperature = data.optInt("temp");
        description = data.optString("text");
    }

    @Override
    public JSONObject toJSON() {
        JSONObject data = new JSONObject();

        try {
            data.put("code", code);
            data.put("temp", temperature);
            data.put("text", description);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return data;
    }
}
