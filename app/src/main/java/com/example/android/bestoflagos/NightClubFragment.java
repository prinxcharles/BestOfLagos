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

public class NightClubFragment extends Fragment {


    public NightClubFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item, container, false);

        // Array of strings for ListView Title
        String[] NightClubName = new String[]{
                getContext().getString(R.string.club_quilox), getContext().getString(R.string.club_jazzhole), getContext().getString(R.string.club_escape),
                getContext().getString(R.string.club_57), getContext().getString(R.string.club_the_garage), getContext().getString(R.string.club_vegas),
                getContext().getString(R.string.club_pravada), getContext().getString(R.string.club_cova_lounge), getContext().getString(R.string.club_rumours),
                getContext().getString(R.string.club_cubana)
        };

        String[] Location = new String[]{
                getContext().getString(R.string.location_vi), getContext().getString(R.string.location_ikoyi), getContext().getString(R.string.location_vi),
                getContext().getString(R.string.location_ikoyi), getContext().getString(R.string.location_vi), getContext().getString(R.string.location_ikeja),
                getContext().getString(R.string.location_vi), getContext().getString(R.string.location_vi), getContext().getString(R.string.location_ikeja),
                getContext().getString(R.string.location_vi)
        };

        // Image Resource for the Image to be displayed in the ListView
        int[] ImageResource1 = new int[]{
                R.drawable.club_quilox, R.drawable.club_jazzhole, R.drawable.club_escape, R.drawable.club_57, R.drawable.club_the_garage,
                R.drawable.club_vegas, R.drawable.club_pravada, R.drawable.club_cova_lounge, R.drawable.club_rumours, R.drawable.club_cubana
        };

        // Image Resource for the Image to be displayed in the Location Details
        int[] ImageResource2 = new int[]{
                R.drawable.club_quilox_2, R.drawable.club_jazzhole, R.drawable.club_escape_2, R.drawable.club_57_2, R.drawable.club_the_garage_2,
                R.drawable.club_vegas_2, R.drawable.club_pravada_2, R.drawable.club_cova_lounge_2, R.drawable.club_rumours_2, R.drawable.club_cubana_2
        };

        // List of Strings Resource containing more details about the landmark
        String[] AboutLocation = new String[]{
                getContext().getString(R.string.about_club_quilox), getContext().getString(R.string.about_club_jazzhole), getContext().getString(R.string.club_escape),
                getContext().getString(R.string.about_club_57), getContext().getString(R.string.about_club_the_garage), getContext().getString(R.string.about_club_vegas),
                getContext().getString(R.string.about_club_pravada), getContext().getString(R.string.about_club_cova_lounge), getContext().getString(R.string.about_club_rumours),
                getContext().getString(R.string.about_club_cubana)
        };


        // ArrayList for the details to be displayed in the ListView in this Fragment
        final ArrayList<LandmarkInfo> landmarkDetails = new ArrayList<LandmarkInfo>();

        for (int i = 0; i < 10; i++) {
            landmarkDetails.add(new LandmarkInfo(NightClubName[i], Location[i], AboutLocation[i], ImageResource1[i], ImageResource2[i]));
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
