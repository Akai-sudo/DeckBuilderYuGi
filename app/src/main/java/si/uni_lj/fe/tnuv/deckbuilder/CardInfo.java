package si.uni_lj.fe.tnuv.deckbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class CardInfo extends AppCompatActivity {

    TextView name, description, atk, def, type, level, attribute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_info);

        name = findViewById(R.id.cardName);
        description = findViewById(R.id.cardDescription);
        atk = findViewById(R.id.ATK);
        def = findViewById(R.id.DEF);
        type = findViewById(R.id.cardType);
        attribute = findViewById(R.id.cardAttribute);

        Cards card = getIntent().getParcelableExtra("key");
        name.setText(card.name);
        description.setText(card.desc);
        atk.setText(card.atk != null ? "ATK: " + card.atk : "");
        def.setText(card.def != null ? "DEF: " + card.def : "");
        type.setText(card.level != null ? "Level "+card.level+" "+card.type : card.type);
        attribute.setText(card.attribute != null ? "Attribute: "+card.attribute : "");

    }
}