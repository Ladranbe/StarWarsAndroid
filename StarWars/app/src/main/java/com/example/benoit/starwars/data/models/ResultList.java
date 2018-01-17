package com.example.benoit.starwars.data.models;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Benoit on 11/01/2018.
 */

public class ResultList implements Serializable{
    public int count;
    public String next;
    public String previous;
    public ArrayList<Planet> results;
}
