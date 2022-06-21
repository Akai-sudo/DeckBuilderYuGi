package si.uni_lj.fe.tnuv.deckbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.collect.Lists;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.List;

import si.uni_lj.fe.tnuv.deckbuilder.deck.DeckActivity;

public class DeckInfoActivity extends AppCompatActivity {

    TextView imeDecka, steviloKart;
    Typeface monospace;
    int numOfCards = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_info);
        monospace = Typeface.createFromAsset(getAssets(),
                "fonts/monospace.bold.ttf");

        Deck ustvarjenDeck = getIntent().getExtras().getParcelable("deckInfo");
        if(ustvarjenDeck != null && ustvarjenDeck.deck != null) {
            numOfCards = ustvarjenDeck.deck.size();
        }


        steviloKart = findViewById(R.id.num);
        steviloKart.setText("Number of cards: "+numOfCards);

        LinearLayout seznam = findViewById(R.id.seznamKart);
        imeDecka = findViewById(R.id.imeDecka);
        imeDecka.setText(ustvarjenDeck.deckName);
        imeDecka.setTextSize(30);

        for (int i = 0; i < ustvarjenDeck.deck.size(); i++) {
            TextView karta = new TextView(this);
            karta.setTypeface(monospace);
            karta.setTextSize(20);
            karta.setPadding(0,10,0,0);
            karta.setText(ustvarjenDeck.deck.get(i).name);

            final int trenutniindeks = i;

            karta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(DeckInfoActivity.this, CardInfo.class);
                    Cards trenutnaKarta = ustvarjenDeck.deck.get(trenutniindeks);
                    intent.putExtra("key", trenutnaKarta);
                    startActivity(intent);
                }
            });
            seznam.addView(karta);

            karta.setOnLongClickListener(v -> {
                //Gson gson = new Gson();
                //ustvarjenDeck[trenutniindeks].re
                //List<Deck> mojKupcek = Lists.newArrayList(ustvarjenDeck);
                ustvarjenDeck.deck.remove(trenutniindeks);

                seznam.removeView(karta);
                //Toast.makeText(HomeActivity.this, "Removed " + myDeck[trenutniindeks].deckName+" deck from arsenal", Toast.LENGTH_SHORT).show();
                return true;
            });
        }
    }
}