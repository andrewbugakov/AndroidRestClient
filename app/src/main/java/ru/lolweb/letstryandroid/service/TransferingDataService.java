package ru.lolweb.letstryandroid.service;

import java.util.List;

import ru.lolweb.letstryandroid.repository.data.AccelerometerUnit;
import ru.lolweb.letstryandroid.repository.data.LocationUnit;
import ru.lolweb.letstryandroid.repository.DataRepository;

/**
 * Created by Andrei on 15.10.2017.
 */

public class TransferingDataService {

    public static void sentDataToServer() {
        List<AccelerometerUnit> accelerometerValues = DataRepository.getAccelerometerValues();
        List<LocationUnit> locations = DataRepository.getLocations();

    }
    public void send(String json,String url){

    }
}
