package ru.lolweb.letstryandroid.repository.data;

import java.sql.Timestamp;

public class LocationUnit {
    private double longitude;
    private double latitude;
    private float speed;
    private Timestamp timestamp;

    public LocationUnit(android.location.Location location) {
        timestamp = new Timestamp(location.getTime());
        longitude = location.getLongitude();
        latitude = location.getLatitude();
        speed = location.getSpeed();
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

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Timestamp getTimestamp() {

        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
