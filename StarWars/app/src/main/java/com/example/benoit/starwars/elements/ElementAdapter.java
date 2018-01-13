package com.example.benoit.starwars.elements;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.benoit.starwars.R;
import com.example.benoit.starwars.data.models.Planet;

import java.util.List;

/**
 * Created by Benoit on 11/01/2018.
 */

public class ElementAdapter extends ArrayAdapter<Planet>{

    public interface OnPlanetSelectedListener{
        void handle(final Planet planet);
    }

    private final OnPlanetSelectedListener onPlanetSelectedListener;

    ElementAdapter (@NonNull final Context context, final List<Planet> planets, final OnPlanetSelectedListener listener) {
        super(context, R.layout.activity_elements, planets);
        onPlanetSelectedListener = listener;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull final ViewGroup parent) {
        View holder = convertView;
        if (convertView == null) {
            final LayoutInflater vi = LayoutInflater.from(getContext());
            holder = vi.inflate(R.layout.element_planet_name_list_item, null);
        }

        final Planet planet = getItem(position);
        if (planet == null) {
            return holder;
        }

        // display the name
        final TextView elementName = holder.findViewById(R.id.elementName);
        if (elementName != null) {
            elementName.setText(planet.getName());
        }

        // When this device item is clicked, trigger the listener
        holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (onPlanetSelectedListener != null) {
                    onPlanetSelectedListener.handle(planet);
                }
            }
        });

        return holder;
    }
}
