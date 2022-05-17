package si.uni_lj.fe.tnuv.deckbuilder.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import si.uni_lj.fe.tnuv.deckbuilder.main.MainActivity;
import si.uni_lj.fe.tnuv.deckbuilder.R;

public class SignActivity extends AppCompatActivity {

    public void mainActivity(View v) {
        Intent intent = new Intent(SignActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign);
    }
}