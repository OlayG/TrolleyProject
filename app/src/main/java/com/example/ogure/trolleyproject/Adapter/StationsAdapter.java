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
import com.example.ogure.trolleyproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogure on 12/3/2015.
 */
public class StationsAdapter extends RecyclerView.Adapter<StationsAdapter.ViewHolder> {

    private static List<Bus> mStations;
    private static List<Bus.stations> mBusStations;



    public StationsAdapter(List<Bus> stations) {
        mStations = stations;
        mBusStations = new ArrayList<>();
        for (Bus bus : stations) {
            mBusStations.addAll(bus.getStationsList());
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView TvStationName;
        public ImageView IvImageView;
        public CardView mCardView;



        public ViewHolder(View itemView) {
            super(itemView);

            //TvRouteName = (TextView) itemView.findViewById(R.id.route_name);
            TvStationName = (TextView) itemView.findViewById(R.id.station_name);
            IvImageView = (ImageView) itemView.findViewById(R.id.station_photo);
            mCardView = (CardView) itemView.findViewById(R.id.cv1);
            mCardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Bus.stations og = mBusStations.get(position);

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

    @Override
    public void onBindViewHolder(StationsAdapter.ViewHolder holder, int position) {

        Globals g = Globals.getInstance();
        position = g.getData();

            Bus.stations trolleyPos = mBusStations.get(position);
            holder.TvStationName.setText(trolleyPos.getStationName());
            holder.IvImageView.setImageResource(R.drawable.kean_logo_1);
            holder.mCardView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return mStations.size();
    }
}