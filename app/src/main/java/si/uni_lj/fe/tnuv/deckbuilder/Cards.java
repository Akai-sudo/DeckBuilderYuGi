package si.uni_lj.fe.tnuv.deckbuilder;

import android.os.Parcel;
import android.os.Parcelable;

public class Cards implements Parcelable {
    public String name;
    public String desc;
    public String atk;
    public String def;
    public String type;
    public String level;
    public String attribute;

    public CardPrice price;

    protected Cards(Parcel in) {
        name = in.readString();
        desc = in.readString();
        atk = in.readString();
        def = in.readString();
        type = in.readString();
        level = in.readString();
        attribute = in.readString();

        //price = in.readTypedObject();
    }

    public static final Creator<Cards> CREATOR = new Creator<Cards>() {
        @Override
        public Cards createFromParcel(Parcel in) {
            return new Cards(in);
        }

        @Override
        public Cards[] newArray(int size) {
            return new Cards[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(desc);
        parcel.writeString(atk);
        parcel.writeString(def);
        parcel.writeString(type);
        parcel.writeString(level);
        parcel.writeString(attribute);
        //parcel.writeString(price);
    }
}
