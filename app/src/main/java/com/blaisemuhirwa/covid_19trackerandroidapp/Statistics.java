package com.blaisemuhirwa.covid_19trackerandroidapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class Statistics extends Fragment {
    /* url for the api used for getting real-time data */
    private static final String STATISTICS_API = "https://api.covid19api.com/summary";
    /* context for fragment */
    Context context;
    /* user interface views */
    private ProgressBar progressBar;
    private EditText searchInput;
    private ImageButton sortButton;
    private RecyclerView statsRecyclerView;

    public Statistics() {

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /* Inflate the layout for this fragment */
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);

        progressBar = view.findViewById(R.id.progressBar);
        searchInput = view.findViewById(R.id.searchInput);
        sortButton = view.findViewById(R.id.sortButton);
        statsRecyclerView = view.findViewById(R.id.statsRecyclerView);

        progressBar.setVisibility(View.GONE);

        return view;
    }

    private void loadStatisticsData() {
        progressBar.setVisibility(View.VISIBLE);

        /* call to the STATISTICS_API */
        StringRequest stringRequest = new StringRequest(Request.Method.GET, STATISTICS_API, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                handleJSONResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                /* handle failed get request:
                    - hide progress bar
                    - display the error message
                 */
                progressBar.setVisibility(View.GONE);
                Toast.makeText(context, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        /* add requests to queue */
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    private void handleJSONResponse(String response) {

    }

}












