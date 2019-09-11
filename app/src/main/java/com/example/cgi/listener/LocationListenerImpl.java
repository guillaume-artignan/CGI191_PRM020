package com.example.cgi.listener;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationListenerImpl implements LocationListener {

    private double longitude;
    private double latitude;
    private GoogleMap mMap;
    private Geocoder geocoder;
    private List<Address> addresses;

    public LocationListenerImpl(Context context, GoogleMap mMap) {
        this.geocoder = new Geocoder(context, Locale.getDefault());
        this.mMap = mMap;
        this.addresses = null;
    }

    public GoogleMap getmMap() {
        return mMap;
    }

    public void setmMap(GoogleMap mMap) {
        this.mMap = mMap;
    }

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
        this.longitude = location.getLongitude();
        this.latitude = location.getLatitude();

        if (this.mMap != null) {
            Log.i("location", "map updated");
            LatLng position = new LatLng(this.latitude, this.longitude);

            mMap.clear();
            mMap.addMarker(new MarkerOptions().position(position).title("Vous êtes ici"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(position));
            mMap.moveCamera(CameraUpdateFactory.zoomTo(10.0f));
        }

        try {
            this.addresses = this.geocoder.getFromLocation(this.latitude, this.longitude, 1);
        } catch (IOException e) {
            Log.e("location", "erreur d'IO");
        }

        if(this.addresses == null || this.addresses.size() == 0) {
            Log.e("location", "aucune adresse trouvée");
        } else {
            Address address = this.addresses.get(0);
            Log.i("addresse", address.toString());


        }


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
