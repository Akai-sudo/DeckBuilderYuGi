package si.uni_lj.fe.tnuv.deckbuilder.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import si.uni_lj.fe.tnuv.deckbuilder.buddy.BuddyActivity;
import si.uni_lj.fe.tnuv.deckbuilder.databinding.ActivityHomeBinding;
import si.uni_lj.fe.tnuv.deckbuilder.deck.DeckActivity;
import si.uni_lj.fe.tnuv.deckbuilder.ui.login.loginActivity;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

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

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //final Button createButton = binding.create;
        //setContentView(R.layout.activity_home);


        /*createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this, DeckActivity.class);
                startActivity(intent);
            }
        });*/
    }
}