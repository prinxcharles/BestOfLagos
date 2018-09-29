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

public class PlayCentreFragment extends Fragment {

    public PlayCentreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item, container, false);

        // Array of strings for ListView Title
        String[] PlayCenterName = new String[]{
                getContext().getString(R.string.hi_impact), getContext().getString(R.string.get_arena), getContext().getString(R.string.ikoyi_club),
                getContext().getString(R.string.xcite_park), getContext().getString(R.string.rosellas_park), getContext().getString(R.string.apapa_park),
                getContext().getString(R.string.dreamwork_africana), getContext().getString(R.string.fun_factory), getContext().getString(R.string.tickle_bay),
                getContext().getString(R.string.funtastica_land)
        };

        String[] Location = new String[]{
                getContext().getString(R.string.location_ibafo), getContext().getString(R.string.location_vi), getContext().getString(R.string.location_ikoyi),
                getContext().getString(R.string.location_lekki), getContext().getString(R.string.location_onilu), getContext().getString(R.string.location_apapa),
                getContext().getString(R.string.location_lekki), getContext().getString(R.string.location_lekki), getContext().getString(R.string.location_lekki),
                getContext().getString(R.string.location_ilupeju)
        };

        // Image Resource for the Image to be displayed in the ListView
        int[] ImageResource1 = new int[]{
                R.drawable.play_hi_impact, R.drawable.play_get_arena, R.drawable.play_ikoyi_golf, R.drawable.park_xcite_fun_park, R.drawable.play_rosellas,
                R.drawable.play_apapa, R.drawable.play_dreamworld_africana, R.drawable.play_fun_factory, R.drawable.play_tickle_bay, R.drawable.play_funtasticaland
        };

        // Image Resource for the Image to be displayed in the Location Details
        int[] ImageResource2 = new int[]{
                R.drawable.play_hi_impact_2, R.drawable.play_get_arena, R.drawable.play_ikoyi_golf_2, R.drawable.park_xcite_fun_park_2, R.drawable.play_rosellas_2,
                R.drawable.play_apapa_2, R.drawable.play_dreamworld_africana_2, R.drawable.play_fun_factory, R.drawable.play_tickle_bay_2, R.drawable.play_funtasticaland_2
        };

        // List of Strings Resource containing more details about the landmark
        String[] AboutLocation = new String[]{
                getContext().getString(R.string.about_play_hi_impact), getContext().getString(R.string.about_play_get_Arena), getContext().getString(R.string.about_play_ikoyi_golf),
                getContext().getString(R.string.about_play_xcite_fun), getContext().getString(R.string.about_play_rosellas), getContext().getString(R.string.about_play_apapa_amusement),
                getContext().getString(R.string.about_play_dreamwork_africana), getContext().getString(R.string.about_play_fun_factory), getContext().getString(R.string.about_play_tickle_bay),
                getContext().getString(R.string.about_play_funtastica_land)
        };


        // ArrayList for the details to be displayed in the ListView in this Fragment
        final ArrayList<LandmarkInfo> landmarkDetails = new ArrayList<LandmarkInfo>();

        for (int i = 0; i < 10; i++) {
            landmarkDetails.add(new LandmarkInfo(PlayCenterName[i], Location[i], AboutLocation[i], ImageResource1[i], ImageResource2[i]));
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
