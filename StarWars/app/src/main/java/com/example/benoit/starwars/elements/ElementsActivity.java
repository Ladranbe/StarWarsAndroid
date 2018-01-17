package com.example.benoit.starwars.elements;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.benoit.starwars.R;
import com.example.benoit.starwars.data.models.HttpError;
import com.example.benoit.starwars.data.models.Planet;
import com.example.benoit.starwars.data.models.ResultList;
import com.example.benoit.starwars.data.remote.ApiService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Benoit on 10/01/2018.
 */

public class ElementsActivity extends AppCompatActivity {

    private static final int NUMBER_OF_PLANETS_PER_PAGE = 10;
    private static final int TOTAL_NUMBER_OF_PLANETS = 61;
    private final ApiService apiService = ApiService.Builder.getInstance(); //singleton

    public static final String PLANET_CARACTERISTICS = "PLANET_CARACTERISTICS";
    private ElementAdapter elementsAdapter;
    private final List<Planet> listOfPlanets = new ArrayList<>();

    public static Intent getStartIntent(final Context context) {
        return new Intent(context, ElementsActivity.class);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elements);

        final ListView planets = findViewById(R.id.planetsListView);

        elementsAdapter = new ElementAdapter(this, listOfPlanets, planetSelectedListener);
        planets.setAdapter(elementsAdapter);

        listOfPlanets.clear();

        for(int i=1; i<=(TOTAL_NUMBER_OF_PLANETS/NUMBER_OF_PLANETS_PER_PAGE);i++) {
            apiService.getPage(i).enqueue(new Callback<ResultList>() {
                @Override
                public void onResponse(final Call<ResultList> call, final Response<ResultList> response) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            handleResponse(response);
                        }
                    });
                }

                @Override
                public void onFailure(final Call<ResultList> call, final Throwable t) {
                    t.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(ElementsActivity.this, R.string.status_error, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
        }
    }

    /*
     * Triggered when an item of the listView is clicked
     */
    private final ElementAdapter.OnPlanetSelectedListener planetSelectedListener = new ElementAdapter.OnPlanetSelectedListener() {
        @Override
        public void handle(final Planet planet) {
            final Intent data = CaracteristicsActivity.getStartIntent(ElementsActivity.this);
            data.putExtra(PLANET_CARACTERISTICS, (Parcelable) planet);
            setResult(RESULT_OK);
            startActivity(data);
        }
    };

    private void updateList (final List<Planet> planets){
        //listOfPlanets.clear();
        if (planets != null && planets.size() > 0){
            listOfPlanets.addAll(planets);
            elementsAdapter.notifyDataSetChanged();
        } else {
            return;
        }
    }

    private void handleResponse(final Response<ResultList> response){
        if (response.isSuccessful()) {
            ResultList resultList = (ResultList) response.body();
            updateList(resultList.results);
        } else { // error HTTP
            try {
                final HttpError error = new Gson().fromJson(response.errorBody().string(), HttpError.class);
                Toast.makeText(ElementsActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            } catch (final IOException e) {
                e.printStackTrace();
                Toast.makeText(ElementsActivity.this, R.string.unknown_error, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
