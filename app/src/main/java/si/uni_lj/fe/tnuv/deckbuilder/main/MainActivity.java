package si.uni_lj.fe.tnuv.deckbuilder.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import si.uni_lj.fe.tnuv.deckbuilder.R;
import si.uni_lj.fe.tnuv.deckbuilder.signup.SignActivity;
import si.uni_lj.fe.tnuv.deckbuilder.ui.login.loginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginActivity(View v) {
        Intent intent = new Intent(MainActivity.this, loginActivity.class);
        startActivity(intent);
    }

    public void signupActivity(View v) {
        Intent intent = new Intent(MainActivity.this, SignActivity.class);
        startActivity(intent);
    }
}