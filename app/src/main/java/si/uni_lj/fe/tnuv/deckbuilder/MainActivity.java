package si.uni_lj.fe.tnuv.deckbuilder;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import androidx.appcompat.app.AppCompatActivity;

import si.uni_lj.fe.tnuv.deckbuilder.ui.login.loginActivity;

public class MainActivity extends AppCompatActivity {

    TextView textJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textJson = (TextView) findViewById(R.id.tvJsonItem);

        new JsonTask().execute("https://db.ygoprodeck.com/api/v7/cardinfo.php?name");
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

    String data ="";
    String singleParsed ="";

   // String[] imenaKart = ;

    protected String doInBackground(String... params) {


        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();


            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line+"\n");
                Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)
                data = data + line;
                //Log.d("Prebran data", "> ", data);
            }

            JSONArray JA = new JSONArray(data);
            for(int i =0 ;i <JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed =  "Name:" + JO.get("name") + "\n";

                //dataParsed = dataParsed + singleParsed +"\n" ;
            }

            return buffer.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /*@Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (pd.isShowing()){
            pd.dismiss();
        }
        textJson.setText(result);
    }*/
}