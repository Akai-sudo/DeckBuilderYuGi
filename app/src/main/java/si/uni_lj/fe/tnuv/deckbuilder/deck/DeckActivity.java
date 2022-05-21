package si.uni_lj.fe.tnuv.deckbuilder.deck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import si.uni_lj.fe.tnuv.deckbuilder.R;
import si.uni_lj.fe.tnuv.deckbuilder.databinding.ActivityDeckBinding;
import si.uni_lj.fe.tnuv.deckbuilder.home.HomeActivity;

public class DeckActivity extends AppCompatActivity {

    private ActivityDeckBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDeckBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //final Button goBackButton = binding.goBack2;
        //setContentView(R.layout.activity_home);

        /*goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //loadingProgressBar.setVisibility(View.VISIBLE);

                Intent intent = new Intent(DeckActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });*/
    }
}
