package com.example.rickh.weatherapp.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Forecast {
    private int LowTemp;
    private int HighTemp;
    private String text="fix";
    private String date=null;
    private String day;

    public ArrayList<String> getTextList() {
        return Textlist;
    }

    public ArrayList<String> getTempHighlist() {
        return tempHighlist;
    }

    public ArrayList<String> getTempLowlist() {
        return tempLowlist;
    }

    public ArrayList<String> getDayList() {
        return dayList;
    }

    ArrayList<String> tempHighlist = new ArrayList<String>();
    ArrayList<String> tempLowlist = new ArrayList<String>();
    ArrayList<String> Textlist = new ArrayList<String>();
    ArrayList<String> dayList = new ArrayList<String>();


    public int getHighTemp() {
        return HighTemp;
    }

    public int getLowTemp() {
        return LowTemp;
    }

    public String getDay() {
        return day;
    }

    public String getDescription() {
        return text;
    }

    // @Override
    public void populate(JSONArray data) throws JSONException {

        try {
            for(int i=0;i<data.length();i++){
                JSONObject jDayForecast = data.getJSONObject(i);
                text =  jDayForecast.getString("text");
                Textlist.add(i,jDayForecast.getString("text"));
                //     LowTemp = jDayForecast.getInt("low");
                tempLowlist.add(i,jDayForecast.getString("low"));
                //     HighTemp = jDayForecast.getInt("high");
                tempHighlist.add(i,jDayForecast.getString("high"));
                //  day = jDayForecast.getString("day");
                dayList.add(i, jDayForecast.getString("day"));
            }


        } catch (Exception e) {

        }


    }

    // @Override
    public JSONObject toJSON() {
        JSONObject data = new JSONObject();

        try {
            //  data.put("code", code);
            data.put("high", HighTemp);
            data.put("low", LowTemp);
            data.put("day", day);
            //  data.put("low", Lowtemp);
            data.put("text", text);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return data;
    }


}

