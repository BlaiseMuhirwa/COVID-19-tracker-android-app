package com.blaisemuhirwa.covid_19trackerandroidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterStatistics extends RecyclerView.Adapter<AdapterStatistics.StatsHolder> {
    private Context context;
    private ArrayList<ModelStatistics> statisticsList;

    public AdapterStatistics(Context context, ArrayList<ModelStatistics> statisticsList) {
        this.context = context;
        this.statisticsList = statisticsList;
    }

    @NonNull
    @Override
    public StatsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /* inflate layout raw_statistics.xml */
        View view = LayoutInflater.from(context).inflate(R.layout.raw_statistics, parent, false);

        return new StatsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatsHolder holder, int position) {
        /* retrieve data */
        ModelStatistics modelStatistics = statisticsList.get(position);

        String country = modelStatistics.getCountry();
        String totalConfirmed = modelStatistics.getTotalConfirmed();
        String totalDeaths = modelStatistics.getTotalDeaths();
        String newConfirmed = modelStatistics.getNewConfirmed();
        String newDeaths = modelStatistics.getNewDeaths();
        String totalRecovered = modelStatistics.getTotalRecovered();
        String newRecovered = modelStatistics.getNewRecovered();

        /* set data */
        holder.CountryTextView.setText(country);
        holder.casesTextView.setText(totalConfirmed);
        holder.deathsTextView.setText(totalDeaths);
        holder.todayCasesTextView.setText(newConfirmed);
        holder.todayDeathsTextView.setText(newDeaths);
        holder.recoveredTextView.setText(totalRecovered);
        holder.recoveredTodayTextView.setText(newRecovered);
    }

    @Override
    public int getItemCount() {
        return statisticsList.size();
    }

    class StatsHolder extends RecyclerView.ViewHolder {
        /* user interface fields */
        TextView CountryTextView;
        TextView casesTextView;
        TextView todayCasesTextView;
        TextView deathsTextView;
        TextView todayDeathsTextView;
        TextView recoveredTextView;
        TextView recoveredTodayTextView;

        public StatsHolder(@NonNull View itemView) {
            super(itemView);

            /* initialize user-interface views */
            CountryTextView = itemView.findViewById(R.id.CountryTextView);
            casesTextView = itemView.findViewById(R.id.casesTextView);
            todayCasesTextView = itemView.findViewById(R.id.todayCasesTextView);
            deathsTextView = itemView.findViewById(R.id.deathsTextView);
            todayDeathsTextView = itemView.findViewById(R.id.todayDeathsTextView);
            recoveredTextView = itemView.findViewById(R.id.recoveredTextView);
            recoveredTodayTextView = itemView.findViewById(R.id.recoveredTodayTextView);

        }
    }
}
