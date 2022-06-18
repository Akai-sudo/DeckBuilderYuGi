package si.uni_lj.fe.tnuv.deckbuilder;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import si.uni_lj.fe.tnuv.deckbuilder.ui.login.loginActivity;

public class MainActivity extends AppCompatActivity {

    //Cards[] dobljeneKarte;
    static Cards[] dobljeneKarte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textJson = (TextView) findViewById(R.id.tvJsonItem);

        try {
            dobljeneKarte = new JsonTask().execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(dobljeneKarte[0]);
        /*for (Cards card: dobljeneKarte)
        {
            //System.out.println("NAME :"+card.name+" DESCRIPTION: "+card.desc+"\nATTACK: "+card.atk+" DEFENSE: "+card.def);
            Log.d("res", card.name);
        }*/
        //Cards[] dobitKarte = new Cards[0];
    }

    /*public AsyncTask<String, String, Cards[]> vrniVseKarte() {
        return dobljeneKarte;
    }*/

    public void loginActivity(View v) {
        Intent intent = new Intent(MainActivity.this, loginActivity.class);
        startActivity(intent);
    }

    public void signupActivity(View v) {
        Intent intent = new Intent(MainActivity.this, SignActivity.class);
        startActivity(intent);
    }

    public static Cards[] povrniVseDobljeneKarte() {
        return dobljeneKarte;
    }
}

class JsonTask extends AsyncTask<String, String, Cards[]> {

    @Override
    protected Cards[] doInBackground(String... params) {
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

            /*System.out.println(cardsArray.toString());

            for (Cards card: cardsArray)
            {
                System.out.println("NAME :"+card.name+" DESCRIPTION: "+card.desc+"\nATTACK: "+card.atk+" DEFENSE: "+card.def);
            }*/
            return cardsArray;
        } catch(Exception e){
            // In your production code handle any errors and catch the individual exceptions
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Cards[] result) {
        //do stuff
        //myMethod(myValue);
        vrniKarte(result);
    }


    private Cards[] vrniKarte(Cards[] mojeKarte) {
        //handle value
        return mojeKarte;
    }
}