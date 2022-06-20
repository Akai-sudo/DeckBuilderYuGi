package si.uni_lj.fe.tnuv.deckbuilder;

public class User {
    String Email, favDeck, mvCard;

    public User(){}

    public User(String email, String favDeck, String mvCard) {
        Email = email;
        this.favDeck = favDeck;
        this.mvCard = mvCard;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFavDeck() {
        return favDeck;
    }

    public void setFavDeck(String favDeck) {
        this.favDeck = favDeck;
    }

    public String getMvCard() {
        return mvCard;
    }

    public void setMvCard(String mvCard) {
        this.mvCard = mvCard;
    }
}
