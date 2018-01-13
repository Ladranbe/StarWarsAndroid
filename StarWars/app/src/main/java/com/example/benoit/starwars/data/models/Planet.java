package com.example.benoit.starwars.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Benoit on 11/01/2018.
 */

public class Planet implements Serializable, Parcelable{

    public String name;
    public String climate;
    public String diameter;
    public String population;
    public String gravity;
    public String terrain;

    @SerializedName("rotation_period")
    public String rotationPeriod;

    @SerializedName("orbital_period")
    public String orbitalPeriod;

    @SerializedName("surface_water")
    public String surfaceWater;

    public static final Creator<Planet> CREATOR = new Creator<Planet>() {
        @Override
        public Planet createFromParcel(Parcel in) {
            return new Planet(in);
        }

        @Override
        public Planet[] newArray(int size) {
            return new Planet[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(String rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(String orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public String getSurfaceWater() {
        return surfaceWater;
    }

    public void setSurfaceWater(String surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Planet(Parcel in) {
        this.name = in.readString();
        this.climate = in.readString();
        this.diameter = in.readString();
        this.population = in.readString();
        this.gravity = in.readString();
        this.terrain = in.readString();
        this.rotationPeriod = in.readString();
        this.orbitalPeriod = in.readString();
        this.surfaceWater = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.climate);
        parcel.writeString(this.diameter);
        parcel.writeString(this.population);
        parcel.writeString(this.gravity);
        parcel.writeString(this.terrain);
        parcel.writeString(this.rotationPeriod);
        parcel.writeString(this.orbitalPeriod);
        parcel.writeString(this.surfaceWater);
    }
}
