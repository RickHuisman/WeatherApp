package com.example.rickh.weatherapp.data;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by rickh on 12/20/2017.
 */

public class Channel implements JSONPopulator {
    private Units units;
    private Item item;
    private Location location;


    public Units getUnits() {
        return units;
    }

    public Item getItem() {
        return item;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public void populate(JSONObject data) throws JSONException {

        units = new Units();
        units.populate(data.optJSONObject("units"));

        item = new Item();
        item.populate(data.optJSONObject("item"));

        location = new Location();
        location.populate(data.optJSONObject("location"));
    }

    @Override
    public JSONObject toJSON() {

        JSONObject data = new JSONObject();

        try {
            data.put("units", units.toJSON());
            data.put("item", item.toJSON());
            data.put("requestLocation", location);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return data;
    }
}
