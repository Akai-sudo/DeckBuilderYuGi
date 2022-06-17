package si.uni_lj.fe.tnuv.deckbuilder.deck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import si.uni_lj.fe.tnuv.deckbuilder.R;

public class DeckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck);

        //ScrollView vseKarte = findViewById(R.id.containerKart);
        LinearLayout ll = (LinearLayout) findViewById(R.id.karteLayout);
        TextView textView = new TextView(this);
        textView.setText("haha1223542342353");
        textView.setHeight(100);
        textView.setWidth(100);
        ll.addView(textView);

       /*for (int i = 0; i < 5; i++) {
           TextView textView = new TextView(this);
           textView.setText("haha"+i);
           ll.addView(textView);
       */
    }
}