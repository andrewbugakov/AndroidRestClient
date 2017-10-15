package ru.lolweb.letstryandroid.repository.data;

import java.sql.Timestamp;

public class LocationUnit {
    private Timestamp timestamp;
    private android.location.Location location;

    public LocationUnit(android.location.Location location) {
        timestamp = new Timestamp(System.currentTimeMillis());
        this.location = location;
    }

    public Timestamp getTimestamp() {

        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public android.location.Location getLocation() {
        return location;
    }

    public void setLocation(android.location.Location location) {
        this.location = location;
    }
}
