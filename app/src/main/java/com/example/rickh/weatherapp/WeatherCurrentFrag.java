package com.example.rickh.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rickh.weatherapp.data.Channel;
import com.example.rickh.weatherapp.service.WeatherServiceCallback;

/**
 * Created by rickhuisman on 19-12-17.
 */

public class WeatherCurrentFrag extends Fragment implements MainActivity.DataFromActivityToFragment {

    private TextView tv;

    private Button buttonTest;

    String test = "This is a test!";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.weather_current_frag, container, false);

        tv = (TextView) root.findViewById(R.id.test);
        buttonTest = (Button) root.findViewById(R.id.button);

        return root;
    }

    @Override
    public void sendData(String data) {
        tv.setText(data);
    }
}
