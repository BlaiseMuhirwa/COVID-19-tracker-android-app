package com.blaisemuhirwa.covid_19trackerandroidapp;

import android.widget.Filter;

import java.util.ArrayList;

public class StatisticsFilter extends Filter {

    private AdapterStatistics adapter;
    private ArrayList<ModelStatistics> filterList;

    public StatisticsFilter(AdapterStatistics adapter, ArrayList<ModelStatistics> filterList) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {

        FilterResults results = new FilterResults();
        /* check the validity of the constraint */
        if (charSequence != null && charSequence.length() > 0) {
            charSequence = charSequence.toString().toUpperCase();

            /* store filtered records */
            ArrayList<ModelStatistics> filteredModels = new ArrayList<>();
            for (int stat = 0; stat < filterList.size(); stat++) {
                if (filterList.get(stat).getCountry().toUpperCase().contains(charSequence)) {
                    filteredModels.add(filterList.get(stat));
                }
            }

            results.count = filteredModels.size();
            results.values = filteredModels;
        }
        else {
            results.count = filterList.size();
            results.values = filterList;
        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

    }
}
