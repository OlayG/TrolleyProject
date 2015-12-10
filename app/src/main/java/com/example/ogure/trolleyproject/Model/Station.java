package com.example.ogure.trolleyproject.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ogure on 11/28/2015.
 */
public class Station implements Serializable {

    @SerializedName("id")
    public int mStationId;
    @SerializedName("name")
    public String mStationName;
    @SerializedName("lat")
    public double mStationLat;
    @SerializedName("long")
    public double mStationLong;
    @SerializedName("prediction")
    public String timestamp;

    public int getmStationId() {
        return mStationId;
    }

    public Station(int mStationId, String mStationName, double mStationLat, double mStationLong, String timestamp) {
        this.mStationId = mStationId;
        this.mStationName = mStationName;
        this.mStationLat = mStationLat;
        this.mStationLong = mStationLong;
        this.timestamp = timestamp;
    }

    public void setmStationId(int mStationId) {
        this.mStationId = mStationId;
    }

    public String getmStationName() {
        return mStationName;
    }

    public void setmStationName(String mStationName) {
        this.mStationName = mStationName;
    }

    public double getmStationLat() {
        return mStationLat;
    }

    public void setmStationLat(double mStationLat) {
        this.mStationLat = mStationLat;
    }

    public double getmStationLong() {
        return mStationLong;
    }

    public void setmStationLong(double mStationLong) {
        this.mStationLong = mStationLong;
    }

    public String getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
