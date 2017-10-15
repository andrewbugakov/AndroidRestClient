package ru.lolweb.letstryandroid.repository.data;

import android.hardware.SensorEvent;

import java.sql.Timestamp;
import java.util.Arrays;

public class AccelerometerUnit {
    private Timestamp timestamp;
    private float[] values;

    public AccelerometerUnit(SensorEvent sensorEvent) {
        this.timestamp = new Timestamp(sensorEvent.timestamp);
        values = Arrays.copyOf(sensorEvent.values, 3);
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public float[] getValues() {
        return values;
    }

    public void setValues(float[] values) {
        this.values = values;
    }

}
