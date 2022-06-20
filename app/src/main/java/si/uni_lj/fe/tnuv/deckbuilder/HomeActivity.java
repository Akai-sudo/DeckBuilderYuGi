package si.uni_lj.fe.tnuv.deckbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

    ListView listview;
    Button addButton;
    EditText GetValue;
    String[] ListElements = new String[] {
            "MY BUDDIES:"
    };

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

        LinearLayout ll = findViewById(R.id.ly);

        listview = findViewById(R.id.listView1);
        addButton = findViewById(R.id.button3);
        GetValue = findViewById(R.id.editTextTextPersonName);

        final List<String> ListElementsArrayList = new ArrayList<>(Arrays.asList(ListElements));
        final ArrayAdapter<String> adapter = new ArrayAdapter<>
                (HomeActivity.this, android.R.layout.simple_list_item_1, ListElementsArrayList);
        listview.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vsebina = GetValue.getText().toString();

                vpisiVDatoteko(vsebina+" \n");
                GetValue.setText("");
            }
        });

        if(getIntent().getExtras() != null) {
            Deck ustvarjenDeck = getIntent().getExtras().getParcelable("newdeck");

            TextView alinejaDecka = new TextView(this);
            alinejaDecka.setText(ustvarjenDeck.deckName);
            alinejaDecka.setTextSize(15);
            //alinejaDecka.setTypeface(monospace);
            alinejaDecka.setGravity(Gravity.START);
            alinejaDecka.setPadding(0, 0, 0, 0);

            ll.addView(alinejaDecka);

            alinejaDecka.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, DeckInfoActivity.class);
                intent.putExtra("deckInfo", ustvarjenDeck);
                startActivity(intent);
            });

            /*Log.d("res", ustvarjenDeck.deckName);
            for (int i = 0; i < ustvarjenDeck.deck.size(); i++) {
                Log.d("res", "[ "+String.valueOf(ustvarjenDeck.deck.get(i).name+" ]"));
            }*/
        }
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