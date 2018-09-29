package com.example.android.bestoflagos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LandmarkAdapter extends ArrayAdapter<LandmarkInfo> {
    public LandmarkAdapter(Context context, ArrayList<LandmarkInfo> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;
        // Get the data item for this position
        LandmarkInfo user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Lookup view for data population
        ImageView imageResource = (ImageView) listView.findViewById(R.id.landmark_image);
        TextView landmark = (TextView) listView.findViewById(R.id.landmark);
        TextView location = (TextView) listView.findViewById(R.id.location);
        // Populate the data into the template view using the data object
        imageResource.setImageResource(user.imageResource1);
        landmark.setText(user.landmarkName);
        location.setText(user.location);
        // Return the completed view to render on screen

        return listView;
    }

}







