package com.blaisemuhirwa.covid_19trackerandroidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterStatistics extends RecyclerView.Adapter<AdapterStatistics.StatsHolder> implements Filterable {
    private Context context;
    public ArrayList<ModelStatistics> statisticsList;
    public ArrayList<ModelStatistics> filterList;
    private StatisticsFilter filter;

    public AdapterStatistics(Context context, ArrayList<ModelStatistics> statisticsList) {
        this.context = context;
        this.statisticsList = statisticsList;
        this.filterList = statisticsList;
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

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new StatisticsFilter(this, filterList);
        }
        return filter;
    }

    static class StatsHolder extends RecyclerView.ViewHolder {
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
            CountryTextView = itemView.findViewById(R.id.tvCountry);
            casesTextView = itemView.findViewById(R.id.tvTotalCases);
            todayCasesTextView = itemView.findViewById(R.id.tvCasesToday);
            deathsTextView = itemView.findViewById(R.id.tvTotalDeaths);
            todayDeathsTextView = itemView.findViewById(R.id.tvDeathsToday);
            recoveredTextView = itemView.findViewById(R.id.tvTotalRecoveries);
            recoveredTodayTextView = itemView.findViewById(R.id.tvRecoveriesToday);

        }
    }
}
