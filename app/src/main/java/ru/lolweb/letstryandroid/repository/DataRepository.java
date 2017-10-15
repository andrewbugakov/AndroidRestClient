package ru.lolweb.letstryandroid.repository;

import android.hardware.SensorEvent;
import android.location.Location;

import java.util.ArrayList;
import java.util.List;

import ru.lolweb.letstryandroid.repository.data.AccelerometerUnit;
import ru.lolweb.letstryandroid.repository.data.LocationUnit;

/**
 * Created by Andrei on 15.10.2017.
 */

public class DataRepository {
    private static List<LocationUnit> locations = new ArrayList<>();
    private static List<AccelerometerUnit> accelerometerValues = new ArrayList<>();

    public static void saveLocation(Location loc) {
        locations.add(new LocationUnit(loc));
    }

    public static void saveAccelerometer(SensorEvent se) {
        accelerometerValues.add(new AccelerometerUnit(se));
    }

    public static List<LocationUnit> getLocations() {
        return locations;
    }

    public static void setLocations(List<LocationUnit> locations) {
        DataRepository.locations = locations;
    }

    public static List<AccelerometerUnit> getAccelerometerValues() {
        return accelerometerValues;
    }

    public static void setAccelerometerValues(List<AccelerometerUnit> accelerometerValues) {
        DataRepository.accelerometerValues = accelerometerValues;
    }
}

