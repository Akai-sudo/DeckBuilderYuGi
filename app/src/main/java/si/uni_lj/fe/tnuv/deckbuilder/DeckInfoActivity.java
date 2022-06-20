package si.uni_lj.fe.tnuv.deckbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DeckInfoActivity extends AppCompatActivity {

    TextView imeDecka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_info);

        Deck ustvarjenDeck = getIntent().getExtras().getParcelable("deckInfo");

        LinearLayout seznam = findViewById(R.id.seznamKart);
        imeDecka = findViewById(R.id.imeDecka);
        imeDecka.setText(ustvarjenDeck.deckName);
        imeDecka.setTextSize(30);

        //Typeface typeface = getResources().getFont(R.font.monospace);

        for (int i = 0; i < ustvarjenDeck.deck.size(); i++) {
            TextView karta = new TextView(this);

            //karta.setTypeface(Typeface.createFromAsset()));
            //karta.set

            /*Typeface mono = Typeface.createFromAsset(getAssets(),
                    "res/font/monospace.ttf");*/
            //karta.setTypeface(mono);
            karta.setTextSize(20);
            karta.setText(ustvarjenDeck.deck.get(i).name);
            seznam.addView(karta);
        }

    }
}