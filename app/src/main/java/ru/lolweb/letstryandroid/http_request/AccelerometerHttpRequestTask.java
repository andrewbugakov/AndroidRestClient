package ru.lolweb.letstryandroid.http_request;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

import ru.lolweb.letstryandroid.activities.MainActivity;
import ru.lolweb.letstryandroid.repository.DataRepository;
import ru.lolweb.letstryandroid.repository.data.AccelerometerUnit;
import ru.lolweb.letstryandroid.repository.data.Greeting;
import ru.lolweb.letstryandroid.util.Configurations;

import static ru.lolweb.letstryandroid.util.Configurations.accel;
import static ru.lolweb.letstryandroid.util.Configurations.baseUri;
import static ru.lolweb.letstryandroid.util.Configurations.gps;

/**
 * Created by Andrei on 15.10.2017.
 */

public class AccelerometerHttpRequestTask extends AsyncTask<Void, Void, Greeting> {
    private static final String TAG = "AccelerometerRequest";
    final String url = baseUri + accel;
    private final MainActivity mainActivity;

    public AccelerometerHttpRequestTask(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected Greeting doInBackground(Void... params) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            List<AccelerometerUnit> accelerometerValues = DataRepository.getAccelerometerValues();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Greeting greeting = restTemplate.postForObject(url, accelerometerValues, Greeting.class, new HashMap<>());
            return greeting;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Greeting greeting) {
        Log.i(TAG,greeting.getGreeting());
    }

}
