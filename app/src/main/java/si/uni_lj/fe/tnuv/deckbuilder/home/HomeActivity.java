package si.uni_lj.fe.tnuv.deckbuilder.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import si.uni_lj.fe.tnuv.deckbuilder.databinding.ActivityHomeBinding;
import si.uni_lj.fe.tnuv.deckbuilder.databinding.ActivityLoginBinding;
import si.uni_lj.fe.tnuv.deckbuilder.deck.DeckActivity;
import si.uni_lj.fe.tnuv.deckbuilder.main.MainActivity;
import si.uni_lj.fe.tnuv.deckbuilder.ui.login.loginActivity;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    /*public void deckActivity(View v) {
        Intent intent = new Intent(HomeActivity.this, DeckActivity.class);
        startActivity(intent);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final Button goBackButton = binding.goback;
        //final Button createButton = binding.create;
        //setContentView(R.layout.activity_home);

        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //loadingProgressBar.setVisibility(View.VISIBLE);

                Intent intent = new Intent(HomeActivity.this, loginActivity.class);
                startActivity(intent);

                /*loginViewModel.login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());*/
            }
        });

        /*createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this, DeckActivity.class);
                startActivity(intent);
            }
        });*/
    }

}