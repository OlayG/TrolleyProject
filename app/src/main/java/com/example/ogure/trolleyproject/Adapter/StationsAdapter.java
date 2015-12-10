package com.example.ogure.trolleyproject.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ogure.trolleyproject.Model.Station;
import com.example.ogure.trolleyproject.R;
import java.util.List;

/**
 * Created by ogure on 12/3/2015.
 */
public class StationsAdapter extends RecyclerView.Adapter<StationsAdapter.ViewHolder> {

    private static List<Station> mStations;



    public StationsAdapter(List<Station> stations) {
        mStations = stations;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView TvStationName;
        public TextView TvArrivalTime;
        public CardView mCardView;
        public TextView stationID;


        public ViewHolder(View itemView) {
            super(itemView);

            TvArrivalTime = (TextView) itemView.findViewById(R.id.trolley_time);
            TvStationName = (TextView) itemView.findViewById(R.id.station_name);
            stationID = (TextView) itemView.findViewById(R.id.station_id);
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
        Station stationLoc = mStations.get(position);

        holder.TvStationName.setText(stationLoc.getmStationName());
        holder.stationID.setText(String.valueOf(stationLoc.getmStationId()));
        holder.TvArrivalTime.setText(stationLoc.getTimestamp());
        holder.mCardView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return mStations.size();
    }
}