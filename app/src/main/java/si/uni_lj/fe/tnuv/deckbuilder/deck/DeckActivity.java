package si.uni_lj.fe.tnuv.deckbuilder.deck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import si.uni_lj.fe.tnuv.deckbuilder.Cards;
import si.uni_lj.fe.tnuv.deckbuilder.MainActivity;

import si.uni_lj.fe.tnuv.deckbuilder.R;

public class DeckActivity extends AppCompatActivity {

    static Cards[] karteZaPrikaz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck);

        //ScrollView vseKarte = findViewById(R.id.containerKart);
        //RelativeLayout rl = findViewById(R.id.ly);

        //RelativeLayout.LayoutParams params= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        karteZaPrikaz = MainActivity.povrniVseDobljeneKarte();
        LinearLayout ll = findViewById(R.id.ly);

        for (Cards card: karteZaPrikaz)
        {
            TextView textView = new TextView(this);
            textView.setText(card.name);
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(0, 0, 0, 10);
            ll.addView(textView);
            //textView.setHeight(100);
            //textView.setWidth(100);
            //textView.setGravity(Gravity.CENTER);
            //textView.setLayoutParams(params);

            //params.addRule(RelativeLayout.BELOW, R.id.below_id);
            //rl.setLayoutParams(params);
        }

       /*for (int i = 0; i < 5; i++) {

           TextView textView = new TextView(this);
           //textView.setId(i);
           //textView.setText("YuGiOh Monster Card Name "+i);
           textView.setText(karteZaPrikaz[i].name);
           textView.setGravity(Gravity.CENTER);


           //textView.setHeight(100);
           //textView.setWidth(100);
           //textView.setGravity(Gravity.CENTER);
           //textView.setLayoutParams(params);

           //params.addRule(RelativeLayout.BELOW, R.id.below_id);
           //rl.setLayoutParams(params);


           ll.addView(textView);
       }*/
    }
}