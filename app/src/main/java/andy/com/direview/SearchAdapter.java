package andy.com.direview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    Context context;
    ArrayList<Product> productList = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
//        holder.P_Price.setText(productList.get(position).getProductName());
        holder.P_Name.setText(productList.get(position).getProductName());
        holder.P_Price.setText("IDR " + String.valueOf(productList.get(position).getProductPrice()));
        holder.review.setText(String.valueOf(productList.get(position).getReview()) + " review");
        holder.rating.setText(String.valueOf(productList.get(position).getRating()));
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailAct.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void setArrayListdata(ArrayList<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView P_Image;
        TextView P_Name, P_Price, review, rating;
        CardView cardview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            P_Image = itemView.findViewById(R.id.P_Image);
            P_Name = itemView.findViewById(R.id.P_Name);
            P_Price = itemView.findViewById(R.id.P_Price);
            review = itemView.findViewById(R.id.review);
            rating = itemView.findViewById(R.id.rating);
            cardview = itemView.findViewById(R.id.cardview);
        }
    }
}