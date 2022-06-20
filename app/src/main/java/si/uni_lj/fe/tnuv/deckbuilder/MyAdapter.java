package si.uni_lj.fe.tnuv.deckbuilder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<User> userArrayList;

    public MyAdapter(Context context, ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        User user = userArrayList.get(position);
        holder.Email.setText(user.Email);
        holder.favDeck.setText(user.favDeck);
        holder.mvCard.setText(user.mvCard);

    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Email, favDeck, mvCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Email = itemView.findViewById(R.id.tvemail);
            favDeck = itemView.findViewById(R.id.tvfavDeck);
            mvCard = itemView.findViewById(R.id.tvcard);
        }
    }
}
