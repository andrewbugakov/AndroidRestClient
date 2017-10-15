package ru.lolweb.letstryandroid.repository.data;

import android.hardware.SensorEvent;

import java.sql.Timestamp;
import java.util.Arrays;

public class AccelerometerUnit {
    private long timestamp;
    private float[] values;

    public AccelerometerUnit(SensorEvent sensorEvent) {
        this.timestamp = sensorEvent.timestamp;
        values = Arrays.copyOf(sensorEvent.values, 3);
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public float[] getValues() {
        return values;
    }

    public void setValues(float[] values) {
        this.values = values;
    }

}
