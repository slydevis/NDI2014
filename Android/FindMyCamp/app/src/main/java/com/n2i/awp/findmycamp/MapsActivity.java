/********************************************//**
 *   \file MapsActivity.java
 *   \brief Main activity for this Android
 *   application.It initializes a map, with
 *   the google API.
 ***********************************************/

package com.n2i.awp.findmycamp;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

/********************************************//**
 *   \class MapsActivity
 *   \brief This class is the main activity
 *   for this Android application. It creates
 *   a map and get the phone location.
 *   It sets a marker for each camp on the map
 *   This class use the Google API.
 ***********************************************/
public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private LocationManager locationManager;
    private GPSTracker locationListener = new GPSTracker();

    /********************************************//**
     *  \fn void onCreate(Bundle savedInstanceState)
     *  \brief Cast when the application is launched
     ***********************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        setUpMapIfNeeded();
    }

    /********************************************//**
     *  \fn void onResume()
     *  \brief Used when the application is resuming
     ***********************************************/

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /********************************************//**
     *  \fn void setUpMapIfNeeded()
     *  \brief Initialize the mMap variable
     ***********************************************/

    private void setUpMapIfNeeded() {
        // Check mMap has not been instantiated.
        if (mMap == null) {
            // Try to obtain the map from SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check the map has been obtained
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /********************************************//**
     *  \fn void setUpMap()
     *  \brief Enable the gps location service,
     *  check the mobile position and sets
     *  the camera to the mobile position.
     *  And it calls the marker placement function.
     ***********************************************/
    private void setUpMap() {

        // Search for the current position

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, locationListener);

        // enable and display the current position

        mMap.setMyLocationEnabled(true);

        // Add the Position listener

        mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            boolean isBegin = true;
            @Override
            public void onMyLocationChange(Location location) {

                // Check if it's the first the app has been launched to search
                // for the current position
                if(isBegin)
                {
                    // Move the camera to the current position

                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                            new LatLng(location.getLatitude(), location.getLongitude()), 13));

                    CameraPosition cameraPosition = new CameraPosition.Builder()
                            .target(new LatLng(location.getLatitude(), location.getLongitude()))
                            .zoom(17)                  // Sets the zoom
                            .bearing(0)                // Sets the orientation if needed
                            .tilt(0)                   // Sets the tilt of the camera to 0 degrees
                            .build();                  // Creates a CameraPosition from the builder
                    mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                    isBegin = false;
                }
            }
        });

        /*
         *  Add Marker example :
         *
         *  mMap.addMarker(new MarkerOptions().position(new LatLng(40.76793169992044,-73.98180484771729)).title("Marker"));
         *
         */
    }
}
