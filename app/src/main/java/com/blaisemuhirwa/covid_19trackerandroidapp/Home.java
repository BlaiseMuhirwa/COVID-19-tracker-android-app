package com.blaisemuhirwa.covid_19trackerandroidapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class Home extends Fragment {
    /* url for the api used for getting real-time data */
    private static final String STATISTICS_API = "https://api.covid19api.com/summary";

    /* context for fragment */
    Context context;
    /* user interface */
    private ProgressBar progressBar;
    private TextView totalRecordedCasesTextView;
    private TextView newCasesTextView;
    private TextView recordedDeathTollTextView;
    private TextView newDeathsTextView;
    private TextView totalRecoveredTextView;
    private TextView newRecoveredTextView;

    public Home() {

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
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        /* initialize user interface for the home view */
        progressBar = view.findViewById(R.id.progressBar);
        totalRecordedCasesTextView = view.findViewById(R.id.totalRecordedCasesTextView);
        newCasesTextView = view.findViewById(R.id.newCasesTextView);
        recordedDeathTollTextView = view.findViewById(R.id.recordedDeathTollTextView);
        newDeathsTextView = view.findViewById(R.id.newDeathsTextView);
        totalRecoveredTextView = view.findViewById(R.id.totalRecoveredTextView);
        newRecoveredTextView = view.findViewById(R.id.newRecoveredTextView);

        progressBar.setVisibility(View.GONE);
        loadHomeData();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadHomeData();
    }

    private void loadHomeData() {
        progressBar.setVisibility(View.VISIBLE);

        /* JSON string request */
        StringRequest stringRequest = new StringRequest(Request.Method.GET, STATISTICS_API,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        /* handle JSON Response */
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
            JSONObject globalObject = jsonObject.getJSONObject("Global");
            String newConfirmedCases = globalObject.getString("NewConfirmed");
            String totalConfirmedCases = globalObject.getString("TotalConfirmed");
            String newDeaths = globalObject.getString("NewDeaths");
            String totalDeaths = globalObject.getString("TotalDeaths");
            String totalRecovered = globalObject.getString("TotalRecovered");
            String newRecovered = globalObject.getString("NewRecovered");

            totalRecordedCasesTextView.setText(totalConfirmedCases);
            newCasesTextView.setText(newConfirmedCases);
            recordedDeathTollTextView.setText(totalDeaths);
            newDeathsTextView.setText(newDeaths);
            totalRecoveredTextView.setText(totalRecovered);
            newRecoveredTextView.setText(newRecovered);

            /* hide progress bar */
            progressBar.setVisibility(View.GONE);

        }
        catch (Exception exception) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(context, ""+exception.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}