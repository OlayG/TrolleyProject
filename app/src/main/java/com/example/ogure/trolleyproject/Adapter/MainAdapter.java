package com.example.ogure.trolleyproject.Adapter;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import com.example.ogure.trolleyproject.GlobalVar.Globals;
import com.example.ogure.trolleyproject.Model.Bus;
import com.example.ogure.trolleyproject.R;
import com.example.ogure.trolleyproject.StationActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogure on 11/28/2015.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private static List<Bus> mStations;
    private static List<Bus.stations> mBusStations;



    public MainAdapter(List<Bus> stations) {
        mStations = stations;
        mBusStations = new ArrayList<>();
        for (Bus bus : stations) {
            mBusStations.addAll(bus.getStationsList());
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public Button TvRouteName;
//        public ImageView IvImageView;
        public CardView mCardView;

        public ViewHolder(View itemView) {
            super(itemView);

            TvRouteName = (Button) itemView.findViewById(R.id.route_name);
//            IvImageView = (ImageView) itemView.findViewById(R.id.trolley_photo);
            mCardView = (CardView) itemView.findViewById(R.id.cv);
            mCardView.setOnClickListener(this);
            TvRouteName.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Bus s = mStations.get(position);
            Bus.stations og = mBusStations.get(position);

            Globals g = Globals.getInstance();
            g.setData(position);

            Intent i = new Intent(v.getContext(), StationActivity.class);
            i.putExtra("position", position);
            i.putExtra("station_name", og.getStationName());
            i.putExtra("trolley_name", s.getmStationName());
            v.getContext().startActivity(i);

        }
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.rv_card_item, parent, false);

                ViewHolder viewHolder = new ViewHolder(v);
                return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {
        Bus stationPos = mStations.get(position);
        Bus.stations bsPos = mBusStations.get(position);


               //holder.TvStationName.setText(bsPos.getStationName());


        holder.TvRouteName.setText(stationPos.getmStationName());
        //holder.IvImageView.setImageResource(R.drawable.kean_logo_1);
        holder.mCardView.setTag(position);


    }

    @Override
    public int getItemCount() {
        return mStations.size();
    }
}