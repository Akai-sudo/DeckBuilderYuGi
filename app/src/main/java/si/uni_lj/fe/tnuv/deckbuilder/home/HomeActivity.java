package si.uni_lj.fe.tnuv.deckbuilder.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import si.uni_lj.fe.tnuv.deckbuilder.databinding.ActivityHomeBinding;
//import si.uni_lj.fe.tnuv.deckbuilder.databinding.ActivityLoginBinding;
import si.uni_lj.fe.tnuv.deckbuilder.databinding.ActivityLoginBinding;
import si.uni_lj.fe.tnuv.deckbuilder.ui.login.loginActivity;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final Button goBackButton = binding.goback;
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
    }
}