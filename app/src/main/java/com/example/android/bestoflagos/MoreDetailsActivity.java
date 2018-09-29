package com.example.android.bestoflagos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MoreDetailsActivity extends AppCompatActivity {

    // Make the Up button behave like the back button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_details);

        //Getting the intent with the track title, image resource ID and description for the selected file
        Intent more_details = getIntent();
        String landmarkName = more_details.getStringExtra(getString(R.string.landmark_name));
        String aboutLandmark = more_details.getStringExtra(getString(R.string.about_landmark));
        int imageResource1 = more_details.getIntExtra(getString(R.string.image_res_1), 0);
        int imageResource2 = more_details.getIntExtra(getString(R.string.image_res_2), 0);
        String location = more_details.getStringExtra(getString(R.string.location_vi));


        Toolbar toolbar = (Toolbar) findViewById(R.id.more_details_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set the label for the activity
        this.setTitle(landmarkName);

        //Setting the image
        //Note: ImageResource2 is the preferred Image to use
        ImageView imageView = (ImageView) findViewById(R.id.details_image);
        imageView.setImageResource(imageResource2);

        //Setting the details of the landmark
        TextView landmarkDetails = (TextView) findViewById(R.id.details_text);
        landmarkDetails.setText(aboutLandmark);

    }

}
