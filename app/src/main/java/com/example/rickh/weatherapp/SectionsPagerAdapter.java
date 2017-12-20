package com.example.rickh.weatherapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by rickh on 12/20/2017.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                WeatherCurrentFrag weatherCurrentFrag = new WeatherCurrentFrag();
                return weatherCurrentFrag;
            case 1:
                WeatherForecastFrag weatherForecastFrag = new WeatherForecastFrag();
                return weatherForecastFrag;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
