package com.example.android.bestoflagos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MallFragment extends Fragment {

    public MallFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item, container, false);

        // Array of strings for ListView Title
        String[] MallName = new String[]{
                getContext().getString(R.string.icm), getContext().getString(R.string.leisure_mall), getContext().getString(R.string.silverbird),
                getContext().getString(R.string.the_palms), getContext().getString(R.string.maryland_mall), getContext().getString(R.string.city_mall),
                getContext().getString(R.string.e_center), getContext().getString(R.string.centro_mall), getContext().getString(R.string.circle_mall),
                getContext().getString(R.string.novare_mall)
        };

        String[] Location = new String[]{
                getContext().getString(R.string.location_ikeja), getContext().getString(R.string.location_surulere), getContext().getString(R.string.location_vi),
                getContext().getString(R.string.location_lekki), getContext().getString(R.string.location_maryland), getContext().getString(R.string.location_onikan),
                getContext().getString(R.string.location_yaba), getContext().getString(R.string.location_lekki), getContext().getString(R.string.location_lekki),
                getContext().getString(R.string.location_sangotedo)
        };

        // Image Resource for the Image to be displayed in the ListView
        int[] ImageResource1 = new int[]{
                R.drawable.mall_ikeja, R.drawable.mall_leisure, R.drawable.mall_silverbird_galleria, R.drawable.mall_the_palms, R.drawable.mall_maryland,
                R.drawable.mall_city, R.drawable.mall_e_center, R.drawable.mall_centro, R.drawable.mall_circle, R.drawable.mall_novare,
        };

        // Image Resource for the Image to be displayed in the Location Details
        int[] ImageResource2 = new int[]{
                R.drawable.mall_ikeja_2, R.drawable.mall_leisure_2, R.drawable.mall_silverbird_galleria_2, R.drawable.mall_the_palms_2, R.drawable.mall_maryland_2,
                R.drawable.mall_city_2, R.drawable.mall_e_center_2, R.drawable.mall_centro_2, R.drawable.mall_circle, R.drawable.mall_novare_2
        };

        // List of Strings Resource containing more details about the landmark
        String[] AboutLocation = new String[]{
                getContext().getString(R.string.about_mall_icm), getContext().getString(R.string.about_mall_leisure), getContext().getString(R.string.about_mall_silverbird),
                getContext().getString(R.string.about_mall_the_palms), getContext().getString(R.string.about_mall_maryland), getContext().getString(R.string.about_mall_city),
                getContext().getString(R.string.about_mall_e_centre), getContext().getString(R.string.about_mall_centrole), getContext().getString(R.string.about_mall_circle),
                getContext().getString(R.string.about_mall_novare)
        };


        // ArrayList for the details to be displayed in the ListView in this Fragment
        final ArrayList<LandmarkInfo> landmarkDetails = new ArrayList<LandmarkInfo>();

        for (int i = 0; i < 10; i++) {
            landmarkDetails.add(new LandmarkInfo(MallName[i], Location[i], AboutLocation[i], ImageResource1[i], ImageResource2[i]));
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
                more_details.putExtra("Location", location);
                startActivity(more_details);
            }
        });

        return rootView;
    }

}
