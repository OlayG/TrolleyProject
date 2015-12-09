package com.example.ogure.trolleyproject.Service;

import com.example.ogure.trolleyproject.Model.Bus;
import com.example.ogure.trolleyproject.Model.Station;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by ogure on 11/28/2015.
 */
public interface StationService {

    @GET("routes")
    Call<List<Bus>> listTrolley();

    @GET("routes")
    Call<List<Bus.stations>> listStations();

    /*@GET("stations")
    Call<List<Station>> listStations();*/
}
