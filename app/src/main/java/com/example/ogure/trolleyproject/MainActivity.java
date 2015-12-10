package com.example.ogure.trolleyproject;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.ogure.trolleyproject.Adapter.MainAdapter;
import com.example.ogure.trolleyproject.Model.Bus;
import com.example.ogure.trolleyproject.Service.StationService;
import com.example.ogure.trolleyproject.Service.StationServiceProvider;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Gets the rv from the xml file (activity_main.xml)
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimary)));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MapsActivity.class);
                startActivity(intent);

                view.getContext().startActivity(intent);

                Snackbar.make(view, "Select a Trolley", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        loadRV();


    }


    public void loadRV() {
        StationService stationService = StationServiceProvider.createService(StationService.class);
        Call<List<Bus>> call = stationService.listTrolley();
        call.enqueue(new Callback<List<Bus>>() {
            @Override
            public void onResponse(Response<List<Bus>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    mAdapter = new MainAdapter(response.body());
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
