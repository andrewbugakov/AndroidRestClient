package ru.lolweb.letstryandroid.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.util.Log;

import ru.lolweb.letstryandroid.repository.DataRepository;

/**
 * Created by Andrei on 15.10.2017.
 */

public class AccelerometerService extends Service implements SensorEventListener {

    private static final String TAG = "AccelerometerService";
    static int count = 0;
    private SensorManager mSensorManager;
    private float x_old, y_old, z_old = 0;

    /**
     * OnShakeListener that is called when shake is detected.
     */


    public AccelerometerService() {
    }

    @Override//
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Service Started");
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //registering Sensor
        Sensor sensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this,
                mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_UI);

        //then you should return sticky
        return Service.START_STICKY;
    }

    @Override
    public void onCreate() {
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //add this line only
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public void onSensorChanged(SensorEvent se) {
        // get sensor when Change

        float x = se.values[0];
        float y = se.values[1];
        float z = se.values[2];
        float div_x = x - x_old;
        float div_y = y - y_old;
        float div_z = z - z_old;
        double v = 1;
        if (div_x > v || div_y > v || div_z > v) {
            Log.i(TAG, "Detected: /" + x + " / " + y + " / " + z);
            DataRepository.saveAccelerometer(se);
        }
        x_old = x;
        y_old = y;
        z_old = z;
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

}