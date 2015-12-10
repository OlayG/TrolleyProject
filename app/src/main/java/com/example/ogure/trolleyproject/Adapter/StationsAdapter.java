package com.example.ogure.trolleyproject.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ogure.trolleyproject.GlobalVar.Globals;
import com.example.ogure.trolleyproject.Model.Bus;
import com.example.ogure.trolleyproject.Model.Station;
import com.example.ogure.trolleyproject.R;
import com.github.curioustechizen.ago.RelativeTimeTextView;


import java.util.Date;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogure on 12/3/2015.
 */
public class StationsAdapter extends RecyclerView.Adapter<StationsAdapter.ViewHolder> {

    private static List<Station> mStations;



    public StationsAdapter(List<Station> stations) {
        mStations = stations;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView TvStationName;
        public TextView TvArrivalTime;
//      public ImageView IvImageView;
        public CardView mCardView;
        public TextView stationID;
        public RelativeTimeTextView relativeTime;


        public ViewHolder(View itemView) {
            super(itemView);

            //TvRouteName = (TextView) itemView.findViewById(R.id.route_name);
            relativeTime = (RelativeTimeTextView)itemView.findViewById(R.id.timestamp);
//            TvArrivalTime = (TextView) itemView.findViewById(R.id.trolley_time);
            TvStationName = (TextView) itemView.findViewById(R.id.station_name);
            //IvImageView = (ImageView) itemView.findViewById(R.id.);
            stationID = (TextView) itemView.findViewById(R.id.station_id);
            mCardView = (CardView) itemView.findViewById(R.id.cv1);
            mCardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Station s = mStations.get(position);

            Toast.makeText(v.getContext(), position , Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public StationsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_card_item2, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }


    private static final long NOW = new Date().getTime();

    public static class RowItem{
        public String info;
        public long timestamp;

        RowItem(String info, long timestamp){
            this.info = info;
            this.timestamp = timestamp;
        }
    }

    public int getRand() {
        final int min = 1;
        final int max = 40;
        Random r = new Random();
        final int random = r.nextInt((max - min) + 1) + min;
        return random;
    }

    @Override
    public void onBindViewHolder(StationsAdapter.ViewHolder holder, int position) {

        Station stationLoc = mStations.get(position);
//         holder.TvArrivalTime.setText((String) stationLoc.getTimestamp());

        holder.TvStationName.setText(stationLoc.getmStationName());
        holder.stationID.setText(String.valueOf(stationLoc.getmStationId()));
        holder.relativeTime.setReferenceTime(new Date(System.currentTimeMillis() + (getRand()) * 60 * 1000).getTime());
        holder.mCardView.setTag(position);


    }

    @Override
    public int getItemCount() {
        return mStations.size();
    }
}