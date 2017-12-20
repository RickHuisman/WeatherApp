package com.example.rickh.weatherapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rickh.weatherapp.data.Channel;
import com.example.rickh.weatherapp.service.WeatherService;
import com.example.rickh.weatherapp.service.WeatherServiceCallback;

public class MainActivity extends AppCompatActivity implements WeatherServiceCallback {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    private WeatherService service;

    private String location = "";

    DataFromActivityToFragment dataFromActivityToFragment;

    private String test = "Hello World!"; // TODO

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mViewPager = (ViewPager) findViewById(R.id.container);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        dataFromActivityToFragment.sendData("Hi");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);

            final LayoutInflater inflater = MainActivity.this.getLayoutInflater();
            final View root = inflater.inflate(R.layout.dialog_search_weather, null);

            dialogBuilder.setView(root)
                    .setTitle("Enter city name")
                    // Add action buttons
                    .setPositiveButton("Search", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            EditText mCityName = (EditText) root.findViewById(R.id.EditTextCity);

                            location = mCityName.getText().toString();

                            if (!location.isEmpty()) {
                                prepareSearch(location);
                            }
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    }).show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void prepareSearch(String location) {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Finding info");
        progressDialog.show();

        service = new WeatherService(this);
        service.refreshWeather(location);
    }

    @Override
    public void serviceSuccess(Channel channel) {
        Log.d("Test", String.valueOf(channel.getItem().getCondition().getTemperature()));
        progressDialog.cancel();
    }

    @Override
    public void serviceFailure(Exception exception) {
        Log.d("serviceFailure", exception.getMessage());
    }

    public interface DataFromActivityToFragment {
        void sendData(String data);
    }
}
