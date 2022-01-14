package ViewHolder;

import android.content.Context;
import android.graphics.Color;
import android.print.PrinterId;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.room.foodonline.Interface.ItemClickListener;
import com.room.foodonline.Model.Order;
import com.room.foodonline.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder>{

    private List<Order> listData = new ArrayList<>();
    private Context context;

    public CardAdapter(List<Order> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.cart_layout,parent,false);
        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int positition) {
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(""+listData.get(positition).getQuantity(), Color.RED);
        holder.img_cart_count.setImageDrawable(drawable);

        Locale locale = new Locale("en","US");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        int proce = (Integer.parseInt(listData.get(positition).getPrice()))*(Integer.parseInt(listData.get(positition).getQuantity()));
        holder.txt_price.setText(fmt.format(proce));

        holder.txt_cart_name.setText(listData.get(positition).getProductName());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}