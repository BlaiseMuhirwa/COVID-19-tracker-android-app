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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


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
    private ArrayList<ModelStatistics> statsList;
    private AdapterStatistics adapter;

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
        loadStatisticsData();
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
        statsList = new ArrayList<>();

        try {
            /* Create a JSON object from the response we get using the api
                Required: response
                Created:
                    - new confirmed cases
                    - total confirmed cases
                    - new deaths
                    - total deaths
                    - new recovered
                    - total recovered
            */
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("Countries");
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setDateFormat("dd/MM/yyyy hh:mm a");
            Gson gson = gsonBuilder.create();

            /* getting data */
            for (int i = 0; i < jsonArray.length(); i++) {
                ModelStatistics modelStats = gson.fromJson(jsonArray.getJSONObject(i).toString(), ModelStatistics.class);
                statsList.add(modelStats);
            }

            /* set up the adapter */
            adapter = new AdapterStatistics(context, statsList);
            statsRecyclerView.setAdapter(adapter);

            progressBar.setVisibility(View.GONE);
        }
        catch (Exception exception) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(context, ""+exception.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}












