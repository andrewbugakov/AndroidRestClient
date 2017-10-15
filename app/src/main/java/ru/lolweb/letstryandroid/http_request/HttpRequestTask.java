package ru.lolweb.letstryandroid.http_request;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import ru.lolweb.letstryandroid.repository.data.Greeting;
import ru.lolweb.letstryandroid.activities.MainActivity;

/**
 * Created by Andrei on 15.10.2017.
 */

public class HttpRequestTask extends AsyncTask<Void, Void, Greeting> {
    private final MainActivity mainActivity;

    public HttpRequestTask(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected Greeting doInBackground(Void... params) {
        try {
            final String url = "http://192.168.1.35:8090/info";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Greeting greeting = restTemplate.getForObject(url, Greeting.class);
            return greeting;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Greeting greeting) {
        Toast.makeText(mainActivity.getApplicationContext(), greeting.getGreeting(), Toast.LENGTH_SHORT).show();
    }

}
