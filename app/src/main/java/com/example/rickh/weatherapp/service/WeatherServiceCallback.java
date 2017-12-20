package com.example.rickh.weatherapp.service;

import com.example.rickh.weatherapp.data.Channel;


public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);

    void serviceFailure(Exception exception);
}
