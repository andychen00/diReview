package andy.com.direview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    RecyclerView recomended, hotReview;
    ArrayList<Product> productList = new ArrayList<>();
    MainAdapter mainAdapter = new MainAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recomended = findViewById(R.id.recomended);
        hotReview = findViewById(R.id.hotReview);
        navbar();
        Product product = new Product(123, "Apple iPhone 13 Pro Max", 20000000, 6, 4.5);
        productList.add(product);
        productList.add(product);
        productList.add(product);
        productList.add(product);
        productList.add(product);

        mainAdapter.setArrayListdata(productList);
        recomended.setAdapter(mainAdapter);
        recomended.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        mainAdapter.setArrayListdata(productList);
        hotReview.setAdapter(mainAdapter);
        hotReview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
    }

    void navbar() {
        BottomNavigationView navbar = findViewById(R.id.navbar);
        navbar.setSelectedItemId(R.id.menu_home);

        navbar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_home) {
                    return true;
                } else if (item.getItemId() == R.id.menu_category) {
                    Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                    startActivity(intent);
                    finish();
                } else if (item.getItemId() == R.id.menu_search) {
                    Intent intent = new Intent(MainActivity.this, Search.class);
                    startActivity(intent);
                    finish();
                }
                return false;
            }
        });
    }
}