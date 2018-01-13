package com.example.benoit.starwars.elements;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
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

import static com.example.benoit.starwars.elements.ElementsActivity.PLANET_CARACTERISTICS;

/**
 * Created by Benoit on 10/01/2018.
 */

public class CaracteristicsActivity extends AppCompatActivity {


    public static final int REQUEST_CODE_PLANET_ID = 1;

    public static Intent getStartIntent(final Context context) {
        return new Intent(context, CaracteristicsActivity.class);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_caracteristics);


        final Planet planet = getIntent().getExtras().getParcelable(PLANET_CARACTERISTICS);

        TextView titleList = (TextView) findViewById(R.id.elementTitle);
        TextView planetNameStatic = (TextView) findViewById(R.id.elementNameStatic);
        TextView elementClimateStatic = (TextView) findViewById(R.id.elementClimateStatic);
        TextView elementDiameterStatic = (TextView) findViewById(R.id.elementDiameterStatic);
        TextView elementGravityStatic = (TextView) findViewById(R.id.elementGravityStatic);
        TextView elementOrbitalPeriodStatic = (TextView) findViewById(R.id.elementOrbitalPeriodStatic);
        TextView elementPopulationStatic = (TextView) findViewById(R.id.elementPopulationStatic);
        TextView elementRotationPeriodStatic = (TextView) findViewById(R.id.elementRotationPeriodStatic);
        TextView elementTerrainStatic = (TextView) findViewById(R.id.elementTerrainStatic);
        TextView elementSurfaceWaterStatic = (TextView) findViewById(R.id.elementSurfaceWaterStatic);

        TextView planetName = (TextView) findViewById(R.id.elementName);
        TextView elementClimate = (TextView) findViewById(R.id.elementClimate);
        TextView elementDiameter = (TextView) findViewById(R.id.elementDiameter);
        TextView elementGravity = (TextView) findViewById(R.id.elementGravity);
        TextView elementOrbitalPeriod = (TextView) findViewById(R.id.elementOrbitalPeriod);
        TextView elementPopulation = (TextView) findViewById(R.id.elementPopulation);
        TextView elementRotationPeriod = (TextView) findViewById(R.id.elementRotationPeriod);
        TextView elementTerrain = (TextView) findViewById(R.id.elementTerrain);
        TextView elementSurfaceWater = (TextView) findViewById(R.id.elementSurfaceWater);

        /*planetName.setText(planetName);
        elementClimate.setText();
        elementDiameter.setText();
        elementGravity.setText();
        elementOrbitalPeriod.setText();
        elementPopulation.setText();
        elementRotationPeriod.setText();
        elementTerrain.setText();
        elementSurfaceWater.setText();*/

        planetName.setText(" "+planet.getName());
        elementClimate.setText(" "+planet.getClimate());
        elementDiameter.setText(" "+planet.getDiameter());
        elementGravity.setText(" "+planet.getGravity());
        elementOrbitalPeriod.setText(" "+planet.getOrbitalPeriod());
        elementPopulation.setText(" "+planet.getPopulation());
        elementRotationPeriod.setText(" "+planet.getRotationPeriod());
        elementTerrain.setText(" "+planet.getTerrain());
        elementSurfaceWater.setText(" "+planet.getSurfaceWater());

        setResult(RESULT_OK);
    }


}
