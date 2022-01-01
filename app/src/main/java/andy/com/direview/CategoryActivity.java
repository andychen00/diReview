package andy.com.direview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity implements CategoryAdapter.CategoryClickListener {
    Toolbar toolbar;
    RecyclerView listCategory;
    ArrayList<Category> categories;
    ArrayList<String> colors;
    CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        initializeToolbar();
        initializeCategories();
    }

    private void initializeCategories() {
        listCategory = findViewById(R.id.rvCategories);
        dummyColors();
        dummyCategories();

        adapter = new CategoryAdapter(categories, colors, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        listCategory.setLayoutManager(gridLayoutManager);
        listCategory.setAdapter(adapter);
    }

    private void dummyCategories() {
        categories = new ArrayList<>();
        categories.add(new Category("Handphone Accessories", R.drawable.handphone_accessories));
        categories.add(new Category("Headphone", R.drawable.headphone));
        categories.add(new Category("Handphone", R.drawable.handphone));
        categories.add(new Category("Laptop", R.drawable.laptop));
        categories.add(new Category("Shirt", R.drawable.shirt));
        categories.add(new Category("Pants", R.drawable.pants));
        categories.add(new Category("Television", R.drawable.tv));
        categories.add(new Category("Camera", R.drawable.camera));
    }

    private void dummyColors() {
        colors = new ArrayList<>();
        colors.add("#FB923C");
        colors.add("#22C55E");
        colors.add("#0EA5E9");
        colors.add("#BE123C");
        colors.add("#7C3AED");
        colors.add("#14B8A6");
    }

    private void initializeToolbar() {
        toolbar = findViewById(R.id.categoryToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void categoryClicked(int position) {
//        Change Activity Destination Here              vvv
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("category", categories.get(position).getTitle());
        startActivity(intent);
    }
}