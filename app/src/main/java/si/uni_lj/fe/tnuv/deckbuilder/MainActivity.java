package si.uni_lj.fe.tnuv.deckbuilder;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import si.uni_lj.fe.tnuv.deckbuilder.ui.login.loginActivity;

public class MainActivity extends AppCompatActivity {

    TextView cardName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textJson = (TextView) findViewById(R.id.tvJsonItem);

        new JsonTask().execute();
    }

    public void loginActivity(View v) {
        Intent intent = new Intent(MainActivity.this, loginActivity.class);
        startActivity(intent);
    }

    public void signupActivity(View v) {
        Intent intent = new Intent(MainActivity.this, SignActivity.class);
        startActivity(intent);
    }
}

class JsonTask extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... params) {
        try {
            // Create a new HTTP Client
            DefaultHttpClient defaultClient = new DefaultHttpClient();
            // Setup the get request
            HttpGet httpGetRequest = new HttpGet("https://db.ygoprodeck.com/api/v7/cardinfo.php");

            // Execute the request in the client
            HttpResponse httpResponse = defaultClient.execute(httpGetRequest);
            // Grab the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8"));
            String json = reader.readLine(); //sparsano v json string

            //Log.d("res", json); //koncno dobis JSON kot raw (json) STRING

            JSONObject jObj = new JSONObject(json);  //ustvarmo json objekt zato da iz json stringa preberemo data k je napisan json objekt
            JSONArray jsonArry = jObj.getJSONArray("data");  //dobimo json array k je sparsan data ven

            Cards[] cardsArray = new Gson().fromJson(jsonArry.toString(), Cards[].class);  //json array damo nazaj v string

            //System.out.println(cardsArray.length);
            //System.out.println(cardsArray[0].name);

            System.out.println(cardsArray.toString());

            for (Cards card: cardsArray)
            {
                System.out.println("NAME :"+card.name+" DESCRIPTION: "+card.desc+"\nATTACK: "+card.atk+" DEFENSE: "+card.def);
            }

            /*for (int i = 0; i < 5; i++) {
                System.out.println("Name :"+cardsArray[i].name+" desc: "+cardsArray[i].desc);
            }*/

            // Instantiate a JSON object from the request response
            //JSONObject jsonObject = new JSONObject(json);
            //System.out.println(jsonObject);

        } catch(Exception e){
            // In your production code handle any errors and catch the individual exceptions
            e.printStackTrace();
        }

        return null;
    }
}

class Cards {
    String name;
    String desc;
    String atk;
    String def;
}
