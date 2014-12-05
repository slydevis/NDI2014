/********************************************//**
 *   \file GPSTracker.java
 *   \brief Useless Listener being implemented
 *   for function use
 ***********************************************/

package com.n2i.awp.findmycamp;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class GPSTracker implements LocationListener {

    public GPSTracker() {}

    @Override
    public void onLocationChanged(Location location) {}

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onProviderDisabled(String provider) {
    }
}
