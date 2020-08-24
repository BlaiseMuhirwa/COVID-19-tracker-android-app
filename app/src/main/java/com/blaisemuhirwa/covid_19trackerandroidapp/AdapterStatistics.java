package com.blaisemuhirwa.covid_19trackerandroidapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterStatistics {

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
