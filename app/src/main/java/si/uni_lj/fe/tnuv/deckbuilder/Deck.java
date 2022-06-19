package si.uni_lj.fe.tnuv.deckbuilder;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Deck implements Parcelable{

    public List<Cards> deck;
    public String deckName;

    protected Deck(Parcel in) {
        deck = in.createTypedArrayList(Cards.CREATOR);
        deckName = in.readString();
    }

    public static final Creator<Deck> CREATOR = new Creator<Deck>() {
        @Override
        public Deck createFromParcel(Parcel in) {
            return new Deck(in);
        }

        @Override
        public Deck[] newArray(int size) {
            return new Deck[size];
        }
    };

    public Deck(String name) {
        this.deck = new ArrayList<Cards>();
        this.deckName = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(deck);
        parcel.writeString(deckName);
    }
}
