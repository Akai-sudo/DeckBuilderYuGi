package si.uni_lj.fe.tnuv.deckbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import si.uni_lj.fe.tnuv.deckbuilder.databinding.ActivityHomeBinding;
import si.uni_lj.fe.tnuv.deckbuilder.deck.DeckActivity;

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

    public void displayToastMsg(View v) {
        toastMsg("A new friend has been added!");
    }

    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}