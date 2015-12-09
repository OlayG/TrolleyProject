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

    public int getmStationId() {
        return mStationId;
    }

    public Station(int mStationId, String mStationName, double mStationLat, double mStationLong) {
        this.mStationId = mStationId;
        this.mStationName = mStationName;
        this.mStationLat = mStationLat;
        this.mStationLong = mStationLong;
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

    //PARCELABLE
/*    public Station(Parcel parcel) {
        setmStationId(parcel.readInt());
        setmStationName(parcel.readString());
        setmStationLat(parcel.readDouble());
        setmStationLong(parcel.readDouble());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mStationId);
        dest.writeString(mStationName);
        dest.writeDouble(mStationLat);
        dest.writeDouble(mStationLong);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator<Station>() {
        @Override
        public Station createFromParcel(Parcel source) {
            return new Station(source);
        }

        @Override
        public Station[] newArray(int size) {
            return new Station[size];
        }
    };

    public void readFromParcel(Parcel in) {
        mStationId = in.readInt();
        mStationName = in.readString();
        mStationLat = in.readDouble();
        mStationLong = in.readDouble();
    }*/
}
