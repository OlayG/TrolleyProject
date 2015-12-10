package com.example.ogure.trolleyproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.example.ogure.trolleyproject.Adapter.StationsAdapter;
import com.example.ogure.trolleyproject.Model.Bus;
import com.example.ogure.trolleyproject.Model.Station;
import com.example.ogure.trolleyproject.Service.StationService;
import com.example.ogure.trolleyproject.Service.StationServiceProvider;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class StationActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Gets the rv from the xml file (activity_main.xml)
        mRecyclerView = (RecyclerView) findViewById(R.id.rv1);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        loadRV1();
    }

    private void loadRV1 () {
        Intent startingIntent = getIntent();
        String pos = startingIntent.getStringExtra("position");
        String station_name = startingIntent.getStringExtra("station_name"); // or whatever.
        String trolley_name = startingIntent.getStringExtra("trolley_name");
        getSupportActionBar().setTitle(trolley_name);

        StationService stationService = StationServiceProvider.createService(StationService.class);
        Call<List<Station>> call = stationService.listStations();

        call.enqueue(new Callback<List<Station>>() {
            @Override
            public void onResponse(Response<List<Station>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    mAdapter = new StationsAdapter(response.body());
                    mRecyclerView.setAdapter(mAdapter);
                } else {
                    Log.d("Oops Something is wrong", response.message());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("ERROR", t.getMessage());
            }
        });
    }
}



