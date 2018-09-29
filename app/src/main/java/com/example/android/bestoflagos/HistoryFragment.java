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

/**
 * A simple {@link Fragment} subclass.
 */

public class HistoryFragment extends Fragment {

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item, container, false);

        // Array of strings for ListView Title
        String[] HistoryCenterName = new String[]{
                getContext().getString(R.string.national_museum), getContext().getString(R.string.kalakuta_museum), getContext().getString(R.string.national_theatre),
                getContext().getString(R.string.new_afrika_shrine), getContext().getString(R.string.badagry_museum), getContext().getString(R.string.terra_kulture),
                getContext().getString(R.string.nike_art), getContext().getString(R.string.jaekel_house), getContext().getString(R.string.thought_pyramid)
        };

        String[] Location = new String[]{
                getContext().getString(R.string.location_onikan), getContext().getString(R.string.location_ikeja), getContext().getString(R.string.location_iganmu),
                getContext().getString(R.string.location_ikeja), getContext().getString(R.string.location_badagry), getContext().getString(R.string.location_vi),
                getContext().getString(R.string.location_lekki), getContext().getString(R.string.location_ebute_metta), getContext().getString(R.string.location_ikoyi)
        };

        // Image Resource for the Image to be displayed in the ListView
        int[] ImageResource1 = new int[]{
                R.drawable.history_national_museum, R.drawable.history_kalakuta, R.drawable.history_national_theatre, R.drawable.history_new_afrika, R.drawable.history_badagry,
                R.drawable.history_terra_kulture, R.drawable.history_nike_arts_gallery, R.drawable.history_jaekel, R.drawable.history_thought_pyramid_art_centre
        };

        // Image Resource for the Image to be displayed in the Location Details
        int[] ImageResource2 = new int[]{
                R.drawable.history_national_museum_2, R.drawable.history_kalakuta_2, R.drawable.history_national_theatre_2, R.drawable.history_new_afrika_2, R.drawable.history_badagry_2,
                R.drawable.history_terra_kulture_2, R.drawable.history_nike_arts_gallery_2, R.drawable.history_jaekel_2, R.drawable.history_thought_pyramid_art_centre_2
        };

        // List of Strings Resource containing more details about the landmark
        String[] AboutLocation = new String[]{
                getContext().getString(R.string.about_history_national_museum), getContext().getString(R.string.about_history_kalakuta), getContext().getString(R.string.about_history_national_theatre),
                getContext().getString(R.string.about_history_new_afrika), getContext().getString(R.string.about_history_badagry_museum), getContext().getString(R.string.about_history_terra_culture),
                getContext().getString(R.string.about_history_nike_art), getContext().getString(R.string.about_history_jaekel_house), getContext().getString(R.string.about_history_thought_pyramid)
        };


        // ArrayList for the details to be displayed in the ListView in this Fragment
        final ArrayList<LandmarkInfo> landmarkDetails = new ArrayList<LandmarkInfo>();

        for (int i = 0; i < 9; i++) {
            landmarkDetails.add(new LandmarkInfo(HistoryCenterName[i], Location[i], AboutLocation[i], ImageResource1[i], ImageResource2[i]));
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
