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
public class BeachFragment extends Fragment {

    public BeachFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item, container, false);

        // Array of strings for ListView Title
        String[] BeachName = new String[]{
                getContext().getString(R.string.tarkwa_bay), getContext().getString(R.string.elegushi), getContext().getString(R.string.halemson_beach),
                getContext().getString(R.string.lekki_leisure), getContext().getString(R.string.oniru_beach), getContext().getString(R.string.inagbe_resort),
                getContext().getString(R.string.alpha_beach), getContext().getString(R.string.atican_beach), getContext().getString(R.string.eleko_beach),
                getContext().getString(R.string.coconut_beach)
        };

        String[] Location = new String[]{
                getContext().getString(R.string.location_lagos_island), getContext().getString(R.string.location_lekki), getContext().getString(R.string.location_badagry),
                getContext().getString(R.string.location_lekki), getContext().getString(R.string.location_vi), getContext().getString(R.string.location_lekki),
                getContext().getString(R.string.location_lekki), getContext().getString(R.string.location_ajah), getContext().getString(R.string.location_lekki),
                getContext().getString(R.string.location_badagry)
        };

        // Image Resource for the Image to be displayed in the ListView
        int[] ImageResource1 = new int[]{
                R.drawable.beach_tarkwa_bay, R.drawable.beach_elegushi, R.drawable.beach_halemson, R.drawable.beach_leisure, R.drawable.beach_oniru,
                R.drawable.beach_inagbe, R.drawable.beach_alpha, R.drawable.beach_atican, R.drawable.beach_eleko, R.drawable.beach_coconut
        };

        // Image Resource for the Image to be displayed in the Location Details
        int[] ImageResource2 = new int[]{
                R.drawable.beach_tarkwa_bay_2, R.drawable.beach_elegushi_2, R.drawable.beach_halemson_2, R.drawable.beach_leisure_2, R.drawable.beach_oniru_2,
                R.drawable.beach_inagbe_2, R.drawable.beach_alpha_2, R.drawable.beach_atican_2, R.drawable.beach_eleko_2, R.drawable.beach_coconut_2
        };

        // List of Strings Resource containing more details about the landmark
        String[] AboutLocation = new String[]{
                getContext().getString(R.string.about_beach_tarkwa), getContext().getString(R.string.about_beach_elegushi), getContext().getString(R.string.about_beach_halemson),
                getContext().getString(R.string.about_beach_lekki_leisure), getContext().getString(R.string.about_beach_oniru), getContext().getString(R.string.about_beach_inagbe),
                getContext().getString(R.string.about_beach_alpha), getContext().getString(R.string.about_beach_atican), getContext().getString(R.string.about_beach_eleko),
                getContext().getString(R.string.about_beach_coconut)
        };


        // ArrayList for the details to be displayed in the ListView in this Fragment
        final ArrayList<LandmarkInfo> landmarkDetails = new ArrayList<LandmarkInfo>();

        for (int i = 0; i < 10; i++) {
            landmarkDetails.add(new LandmarkInfo(BeachName[i], Location[i], AboutLocation[i], ImageResource1[i], ImageResource2[i]));
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
