package com.example.cgi.listener;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

public class LocationListenerImpl implements LocationListener {

    private double longitude;
    private double latitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.i("location", "changed");
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        Log.i("status", "changed");

    }

    @Override
    public void onProviderEnabled(String s) {
        Log.i("provider", "enabled");

    }

    @Override
    public void onProviderDisabled(String s) {
        Log.i("provider", "disabled");

    }
}
