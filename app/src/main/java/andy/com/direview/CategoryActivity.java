package andy.com.direview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity implements CategoryAdapter.CategoryClickListener {
    Toolbar toolbar;
    RecyclerView listCategory;
    ArrayList<Category> categories;
    ArrayList<String> colors;
    CategoryAdapter adapter;
    Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        initializeToolbar();
        initializeCategories();
        navbar();
    }

    private void initializeCategories() {
        listCategory = findViewById(R.id.rvCategories);
        create = (Button) findViewById(R.id.create);
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
//        toolbar = findViewById(R.id.categoryToolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Category");
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

    void navbar() {
        BottomNavigationView navbar = findViewById(R.id.navbar);
        navbar.setSelectedItemId(R.id.menu_category);

        navbar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_home) {
                    Intent intent = new Intent(CategoryActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else if (item.getItemId() == R.id.menu_category) {
                    return true;
                } else if (item.getItemId() == R.id.menu_search) {
                    Intent intent = new Intent(CategoryActivity.this, Search.class);
                    startActivity(intent);
                    finish();
                }
                return false;
            }
        });
    }

    public void create(View view) {
        Intent intent = new Intent(CategoryActivity.this, Create.class);
        startActivity(intent);
    }
}