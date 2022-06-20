package si.uni_lj.fe.tnuv.deckbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import si.uni_lj.fe.tnuv.deckbuilder.deck.DeckActivity;

public class DeckInfoActivity extends AppCompatActivity {

    TextView imeDecka, steviloKart;
    Typeface monospace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_info);
        monospace = Typeface.createFromAsset(getAssets(),
                "fonts/monospace.bold.ttf");

        Deck ustvarjenDeck = getIntent().getExtras().getParcelable("deckInfo");
        int numOfCards = ustvarjenDeck.deck.size();

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

            /*karta.setOnClickListener(v -> {
                Intent intent = new Intent(DeckInfoActivity.this, CardInfo.class);
                intent.putExtra("key", ustvarjenDeck.deck.get(i));
                startActivity(intent);
            });*/

            seznam.addView(karta);
        }

    }
}