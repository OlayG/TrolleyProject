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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogure on 12/3/2015.
 */
public class StationsAdapter extends RecyclerView.Adapter<StationsAdapter.ViewHolder> {

    private List<Station> stationArray;

    public StationsAdapter(List<Station> stations) {
        stationArray = stations;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView TvStationName, TvTrolleyTime;
        public ImageView IvImageView;
        public CardView mCardView;



        public ViewHolder(View itemView) {
            super(itemView);

            //TvRouteName = (TextView) itemView.findViewById(R.id.route_name);
            TvTrolleyTime = (TextView) itemView.findViewById(R.id.trolley_time);
            TvStationName = (TextView) itemView.findViewById(R.id.station_name);
            IvImageView = (ImageView) itemView.findViewById(R.id.station_photo);
            mCardView = (CardView) itemView.findViewById(R.id.cv1);
        }
    }

    @Override
    public StationsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_card_item2, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StationsAdapter.ViewHolder holder, int position) {
        Station station = stationArray.get(position);


            holder.TvStationName.setText(station.getmStationName());
            holder.TvTrolleyTime.setText((int) station.getTimestamp());
            holder.IvImageView.setImageResource(R.drawable.kean_logo_1);
            holder.mCardView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return stationArray.size();
    }
}