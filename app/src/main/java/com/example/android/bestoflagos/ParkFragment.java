package com.example.android.bestoflagos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ParkFragment extends Fragment {


    public ParkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item, container, false);

        // Array of strings for ListView Title
        String[] ParkName = new String[]{
                getContext().getString(R.string.freedom_park), getContext().getString(R.string.lekki_conservation), getContext().getString(R.string.jhalobia_park),
                getContext().getString(R.string.eden_park), getContext().getString(R.string.muri_okunola_park), getContext().getString(R.string.lufasi_nature_park),
                getContext().getString(R.string.johnson_jakande_park)
        };

        String[] Location = new String[]{
                getContext().getString(R.string.location_lagos_island), getContext().getString(R.string.location_lekki), getContext().getString(R.string.location_oshodi),
                getContext().getString(R.string.location_ikeja), getContext().getString(R.string.location_vi), getContext().getString(R.string.location_lekki),
                getContext().getString(R.string.location_ikeja)
        };

        // Image Resource for the Image to be displayed in the ListView
        int[] ImageResource1 = new int[]{
                R.drawable.park_freedom, R.drawable.park_lekki_conservation, R.drawable.park_jhalobia, R.drawable.park_eden, R.drawable.park_muri_okunola,
                R.drawable.park_lufasi, R.drawable.park_johnson_jakande
        };

        // Image Resource for the Image to be displayed in the Location Details
        int[] ImageResource2 = new int[]{
                R.drawable.park_freedom_2, R.drawable.park_lekki_conservation_2, R.drawable.park_jhalobia, R.drawable.park_eden_2, R.drawable.park_muri_okunola_2,
                R.drawable.park_lufasi_2, R.drawable.park_johnson_jakande_2
        };

        // List of Strings Resource containing more details about the landmark
        String[] AboutLocation = new String[]{
                getContext().getString(R.string.about_park_freedom_park), getContext().getString(R.string.about_park_lekki_conservation), getContext().getString(R.string.about_park_jhalobia),
                getContext().getString(R.string.about_park_eden), getContext().getString(R.string.about_park_muri_okunola), getContext().getString(R.string.about_park_lufasi_nature),
                getContext().getString(R.string.about_park_johnson_jakande)
        };


        // ArrayList for the details to be displayed in the ListView in this Fragment
        final ArrayList<LandmarkInfo> landmarkDetails = new ArrayList<LandmarkInfo>();

        for (int i = 0; i < 7; i++) {
            landmarkDetails.add(new LandmarkInfo(ParkName[i], Location[i], AboutLocation[i], ImageResource1[i], ImageResource2[i]));
        }

        // Create the adapter to convert the array to views
        LandmarkAdapter adapter = new LandmarkAdapter(getActivity(), landmarkDetails);

        //Create an object of the ListView
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                LandmarkInfo landmarkInfo = landmarkDetails.get(position);
                //gets the other details of the landmark to be passed to the next activity

                //Getting the landmark name
                String landmarkName = landmarkInfo.getLandmarkName();
                // Getting the landmarklocation
                String location = landmarkInfo.getLocation();
                // Getting the short description of the landmark
                String aboutLandmark = landmarkInfo.getAboutLandmark();
                // Getting the first image resource(The one displayed on the ListView)
                int imageResource1 = landmarkInfo.getImageResource1();
                // Getting the second image resource(The one to be displayed in the MoreDetailsactivity)
                int imageResource2 = landmarkInfo.getImageResource2();

                //Send an Intent to the more details activity
                Intent more_details = new Intent(getActivity(), MoreDetailsActivity.class);
                //Passing the Landmark name to the More Details Activity
                more_details.putExtra(getString(R.string.landmark_name), landmarkName);
                //Passing the details about the Landmark to the More Details Activity
                more_details.putExtra(getString(R.string.about_landmark), aboutLandmark);
                //Passing the image id 1 to the More Details activity
                more_details.putExtra(getString(R.string.image_res_1), imageResource1);
                //Passing the image id 2 to the More Details activity
                more_details.putExtra(getString(R.string.image_res_2), imageResource2);
                //Passing the location text to the More Details Activity
                more_details.putExtra(getString(R.string.location), location);
                startActivity(more_details);
            }
        });

        return rootView;

    }

}
