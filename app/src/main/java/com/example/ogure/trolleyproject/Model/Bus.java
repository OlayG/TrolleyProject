package com.example.ogure.trolleyproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ogure on 11/30/2015.
 */
public class Bus implements Serializable {

    @SerializedName("id")
    private int mStationId;
    @SerializedName("name")
    private String mStationName;
    @SerializedName("code")
    private String mStationCode;
    @SerializedName("tag_uid")
    private String mStationTag_uid;
    @SerializedName("last_spotted_at")
    private String mStationLast_spot_time;
    @SerializedName("last_spotted_station")
    private int mStationLast_spot_station;
    @SerializedName("stations")
    private List<stations> stationsList;

    public int getmStationId() {
        return mStationId;
    }

    public void setmStationId(int mStationId) {
        this.mStationId = mStationId;
    }

    public List<stations> getStationsList() {
        return stationsList;
    }

    public void setStationInfo(List<stations> stationsList) {
        this.stationsList = stationsList;
    }

    public int getmStationLast_spot_station() {
        return mStationLast_spot_station;
    }

    public void setmStationLast_spot_station(int mStationLast_spot_station) {
        this.mStationLast_spot_station = mStationLast_spot_station;
    }

    public String getmStationLast_spot_time() {
        return mStationLast_spot_time;
    }

    public void setmStationLast_spot_time(String mStationLast_spot_time) {
        this.mStationLast_spot_time = mStationLast_spot_time;
    }

    public String getmStationTag_uid() {
        return mStationTag_uid;
    }

    public void setmStationTag_uid(String mStationTag_uid) {
        this.mStationTag_uid = mStationTag_uid;
    }

    public String getmStationCode() {
        return mStationCode;
    }

    public void setmStationCode(String mStationCode) {
        this.mStationCode = mStationCode;
    }

    public String getmStationName() {
        return mStationName;
    }

    public void setmStationName(String mStationName) {
        this.mStationName = mStationName;
    }

    public class stations {
        @SerializedName("id")
        private int stationID;
        @SerializedName("name")
        private String stationName;
        @SerializedName("lat")
        private double stationLat;
        @SerializedName("long")
        private double stationLong;
        @SerializedName("_pivot_bus_id")
        private int mStationPiviotBusId;
        @SerializedName("_pivot_station_id")
        private int mStationPiviotStationId;

        public int getmStationPiviotStationId() {
            return mStationPiviotStationId;
        }

        public void setmStationPiviotStationId(int mStationPiviotStationId) {
            this.mStationPiviotStationId = mStationPiviotStationId;
        }

        public int getmStationPiviotBusId() {
            return mStationPiviotBusId;
        }

        public void setmStationPiviotBusId(int mStationPiviotBusId) {
            this.mStationPiviotBusId = mStationPiviotBusId;
        }

        public double getStationLong() {
            return stationLong;
        }

        public void setStationLong(double stationLong) {
            this.stationLong = stationLong;
        }

        public double getStationLat() {
            return stationLat;
        }

        public void setStationLat(double stationLat) {
            this.stationLat = stationLat;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public int getStationID() {
            return stationID;
        }

        public void setStationID(int stationID) {
            this.stationID = stationID;
        }
    }
}
