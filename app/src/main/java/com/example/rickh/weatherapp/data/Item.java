/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Yoel Nunez <dev@yoelnunez.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 */
package com.example.rickh.weatherapp.data;

import org.json.JSONException;
import org.json.JSONObject;

public class Item implements JSONPopulator {
    private Condition condition;
    private Forecast forecast;


    public Forecast getForecast() {
        return forecast;
    }

    public Condition getCondition() {
        return condition;
    }


    @Override
    public void populate(JSONObject data) throws JSONException {
        condition = new Condition();
        forecast = new Forecast();

        condition.populate(data.optJSONObject("condition"));
        forecast.populate(data.optJSONArray("forecast"));
    }

    @Override
    public JSONObject toJSON() {
        JSONObject data = new JSONObject();
        try {
            data.put("condition", condition.toJSON());
            data.put("forecast", forecast.toJSON());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
}