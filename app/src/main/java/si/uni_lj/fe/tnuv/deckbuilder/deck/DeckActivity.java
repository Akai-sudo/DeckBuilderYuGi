package si.uni_lj.fe.tnuv.deckbuilder.deck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import si.uni_lj.fe.tnuv.deckbuilder.CardInfo;
import si.uni_lj.fe.tnuv.deckbuilder.Cards;
import si.uni_lj.fe.tnuv.deckbuilder.Deck;
import si.uni_lj.fe.tnuv.deckbuilder.HomeActivity;
import si.uni_lj.fe.tnuv.deckbuilder.LogActivity;
import si.uni_lj.fe.tnuv.deckbuilder.MainActivity;

import si.uni_lj.fe.tnuv.deckbuilder.R;

public class DeckActivity extends AppCompatActivity{

    static Cards[] karteZaPrikaz;
    Deck novDeck;
    String imeDecka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck);

        karteZaPrikaz = MainActivity.povrniVseDobljeneKarte();
        LinearLayout ll = findViewById(R.id.ly);

        EditText vnesenoIme = (EditText) findViewById(R.id.vnosImena);

        vnesenoIme.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                imeDecka = vnesenoIme.getText().toString();
            }
        });

        novDeck = new Deck(imeDecka);

        for (Cards card: karteZaPrikaz)
        {
            TextView textView = new TextView(this);
            textView.setText(card.name);
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(0, 0, 0, 10);

            textView.setOnClickListener(v -> {

                Intent intent = new Intent(DeckActivity.this, CardInfo.class);
                intent.putExtra("key", card);
                startActivity(intent);
            });

            textView.setOnLongClickListener(v -> {
                novDeck.deck.add(card);
                Toast.makeText(DeckActivity.this, "Added "+card.name, Toast.LENGTH_SHORT).show();
                return true;
            });
            ll.addView(textView);
        }
    }

    public void buildDeck(View v) {
        novDeck.deckName = imeDecka;
        Intent intent = new Intent(DeckActivity.this, HomeActivity.class);
        intent.putExtra("newdeck", novDeck);
        startActivity(intent);
    }
}