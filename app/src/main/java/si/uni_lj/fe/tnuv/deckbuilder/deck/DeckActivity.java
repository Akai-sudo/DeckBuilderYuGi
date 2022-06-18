package si.uni_lj.fe.tnuv.deckbuilder.deck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.Serializable;

import si.uni_lj.fe.tnuv.deckbuilder.CardInfo;
import si.uni_lj.fe.tnuv.deckbuilder.Cards;
import si.uni_lj.fe.tnuv.deckbuilder.HomeActivity;
import si.uni_lj.fe.tnuv.deckbuilder.MainActivity;

import si.uni_lj.fe.tnuv.deckbuilder.R;
import si.uni_lj.fe.tnuv.deckbuilder.ui.login.loginActivity;

public class DeckActivity extends AppCompatActivity {

    static Cards[] karteZaPrikaz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck);

        karteZaPrikaz = MainActivity.povrniVseDobljeneKarte();
        LinearLayout ll = findViewById(R.id.ly);

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

            /*textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    // TODO Auto-generated method stub

                    return true;
                }
            });*/


            ll.addView(textView);
        }
    }
}