package si.uni_lj.fe.tnuv.deckbuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import si.uni_lj.fe.tnuv.deckbuilder.databinding.ActivityHomeBinding;
import si.uni_lj.fe.tnuv.deckbuilder.deck.DeckActivity;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    Typeface monospace;
    public List<Deck> mojiKupcki = new ArrayList<Deck>();

    ListView listview;
    Button addButton, btnsignOut;
    EditText GetValue;
    String[] ListElements = new String[] {
            "MY BUDDIES:"
    };

    //FirebaseAuth mAuth;

    private String filename = "vsebina.txt";

    public void deckActivity(View v) {
        Intent intent = new Intent(HomeActivity.this, DeckActivity.class);
        startActivity(intent);
    }

    public void buddyActivity(View v) {
        Intent intent = new Intent(HomeActivity.this, BuddyActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        monospace = Typeface.createFromAsset(getAssets(),
                "fonts/monospace.bold.ttf");


        listview = findViewById(R.id.listView1);
        addButton = findViewById(R.id.button3);
        GetValue = findViewById(R.id.editTextTextPersonName);
        btnsignOut = findViewById(R.id.btnSignOut);

        prikazi(this);

        addButton.setOnClickListener(v -> {
            String vsebina = GetValue.getText().toString();

            vpisiVDatoteko(vsebina+" \n");
            GetValue.setText("");
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        LinearLayout ll = findViewById(R.id.ly);

        String dobljeno = PreferenceManager.getDefaultSharedPreferences(this).getString("shranjeno", "");

        //String dobljeno = PreferenceManager.getDefaultSharedPreferences(this).getString("shranjeniKupcki", "");

        Log.d("deck", "on start je bil invociran");
        Log.d("deck", dobljeno);

        //Deck[] myDeck = new Gson().fromJson(dobljeno, Deck[].class);
        Deck myDeck = new Gson().fromJson(dobljeno, Deck.class);

        if(myDeck != null) {

            /*for (int i = 0; i < myDeck.length; i++) {
                TextView alinejaDecka = new TextView(this);
                alinejaDecka.setText(myDeck[i].deckName);
                alinejaDecka.setTextSize(18);
                //alinejaDecka.setTypeface(monospace);
                alinejaDecka.setGravity(Gravity.START);
                alinejaDecka.setPadding(0, 0, 0, 0);

                alinejaDecka.setOnClickListener(v -> {
                    Intent intent = new Intent(HomeActivity.this, DeckInfoActivity.class);
                    intent.putExtra("deckInfo", myDeck);
                    startActivity(intent);
                });
                ll.addView(alinejaDecka);
            }*/

            TextView alinejaDecka = new TextView(this);
            alinejaDecka.setText(myDeck.deckName+" deck");
            alinejaDecka.setTextSize(19);
            alinejaDecka.setTypeface(monospace);
            alinejaDecka.setGravity(Gravity.START);
            alinejaDecka.setPadding(19, 15, 0, 0);

            alinejaDecka.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, DeckInfoActivity.class);
                intent.putExtra("deckInfo", myDeck);
                startActivity(intent);
            });

            ll.addView(alinejaDecka);
        }

        btnsignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mAuth.signOut();
                signOutUser();
            }
        });

    }

    private void signOutUser() {
        Intent mainActivity = new Intent(HomeActivity.this, MainActivity.class);
        //mainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainActivity);
        //finish();
    }

    private void vpisiVDatoteko(String vsebina){

        try {
            FileOutputStream os = openFileOutput(filename, Context.MODE_PRIVATE | Context.MODE_APPEND);
            os.write(vsebina.getBytes());
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        prikazi(this);
    }

    public void prikazi(HomeActivity view)
    {
        String vsebina = beriIzDatoteke();
        final List<String> ListElementsArrayList = new ArrayList<>(Arrays.asList(ListElements));
        final ArrayAdapter<String> adapter = new ArrayAdapter<>
                (HomeActivity.this, android.R.layout.simple_list_item_1, ListElementsArrayList);
        listview.setAdapter(adapter);
        ListElementsArrayList.add(vsebina);
        adapter.notifyDataSetChanged();
    }

    private String beriIzDatoteke(){

        FileInputStream inputStream;

        File file = new File(getFilesDir(), filename);
        int length = (int) file.length();

        byte[] bytes = new byte[length];

        try {
            inputStream = openFileInput(filename);
            inputStream.read(bytes);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String vsebina = new String(bytes);

        return vsebina;
    }
}