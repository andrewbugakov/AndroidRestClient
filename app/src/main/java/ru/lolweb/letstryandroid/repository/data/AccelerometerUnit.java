package ru.lolweb.letstryandroid.repository.data;

import android.hardware.SensorEvent;

import java.sql.Timestamp;

public class AccelerometerUnit {
    private Timestamp timestamp;
    private SensorEvent sensorEvent;

    public AccelerometerUnit(SensorEvent sensorEvent) {

        this.sensorEvent = sensorEvent;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public SensorEvent getSensorEvent() {
        return sensorEvent;
    }

    public void setSensorEvent(SensorEvent sensorEvent) {
        this.sensorEvent = sensorEvent;
    }
}
