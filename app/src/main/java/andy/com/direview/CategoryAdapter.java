package andy.com.direview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    ArrayList<Category> categories;
    ArrayList<String> colors;
    CategoryClickListener listener;

    public CategoryAdapter(ArrayList<Category> categories, ArrayList<String> colors, CategoryClickListener listener) {
        this.categories = categories;
        this.colors = colors;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(categories.get(position).getTitle());
        holder.image.setImageResource(categories.get(position).getImage());
        holder.cardView.setCardBackgroundColor(Color.parseColor(colors.get(position % colors.size())));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ivCategory);
            title = itemView.findViewById(R.id.tvCategory);
            cardView = itemView.findViewById(R.id.cvCategory);
            cardView.setOnClickListener(x -> {
                listener.categoryClicked(getAdapterPosition());
            });
        }
    }

    interface CategoryClickListener{
        void categoryClicked(int position);
    }
}
