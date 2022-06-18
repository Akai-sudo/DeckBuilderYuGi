package si.uni_lj.fe.tnuv.deckbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import si.uni_lj.fe.tnuv.deckbuilder.R;

public class BuddyActivity extends AppCompatActivity {
    //private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddy);
        //mDatabase = FirebaseDatabase.getInstance().getReference();
    }


}