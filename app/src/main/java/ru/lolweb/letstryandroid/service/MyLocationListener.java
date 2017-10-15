package ru.lolweb.letstryandroid.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import ru.lolweb.letstryandroid.repository.DataRepository;

/**
 * Created by Andrei on 15.10.2017.
 */

public class MyLocationListener implements LocationListener {
    static Location imHere; // здесь будет всегда доступна самая последняя информация о местоположении пользователя.
    static Context context;
    private final String TAG = "MyLocationListener";

    @SuppressLint("MissingPermission")
    public static void SetUpLocationListener(Context context) // это нужно запустить в самом начале работы программы
    {
        MyLocationListener.context = context;
        LocationManager locationManager = (LocationManager)
                context.getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new MyLocationListener();


        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                1000,
                10,
                locationListener); // здесь можно указать другие более подходящие вам параметры

        imHere = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        DataRepository.saveLocation(imHere);
    }

    private static void getShow(Context context) {
        Toast.makeText(context, "you have no permission for location", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLocationChanged(Location loc) {
        imHere = loc;
        DataRepository.saveLocation(loc);
        Log.i(TAG, "location changed: " + loc.getLatitude() + " / " + loc.getLongitude());
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.i(TAG, "Provider disabled");

    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.i(TAG, "Provider enabled");

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
}

