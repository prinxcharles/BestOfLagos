package com.example.android.bestoflagos;

public class LandmarkInfo {

    // String object for the Landmark name
    public String landmarkName;
    // String object for the Landmark location
    public String location;
    // String object for the Landmark details
    public String landmarkDetails;
    // String object for the Landmark image resource (to be displayed in the listview)
    public int imageResource1;
    // String object for the Landmark image resource (to be displayed in the MoreDetailsActivity)
    public int imageResource2;

    public LandmarkInfo(String landmarkName, String location, int imageResource1) {
        this.landmarkName = landmarkName;
        this.location = location;
        this.imageResource1 = imageResource1;
    }

    public LandmarkInfo(String landmarkName, String location, String landmarkDetails, int imageResource1, int imageResource2) {
        this.landmarkName = landmarkName;
        this.location = location;
        this.landmarkDetails = landmarkDetails;
        this.imageResource1 = imageResource1;
        this.imageResource2 = imageResource2;
    }

    public String getLandmarkName() {
        return landmarkName;
    }

    public String getLocation() {
        return location;
    }

    public String getAboutLandmark() {
        return landmarkDetails;
    }

    public int getImageResource1() {
        return imageResource1;
    }

    public int getImageResource2() {
        return imageResource2;
    }


}
