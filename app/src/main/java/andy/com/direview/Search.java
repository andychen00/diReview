package andy.com.direview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    EditText search;
    RecyclerView rv_product;
    ArrayList<Product> productList = new ArrayList<>();
    SearchAdapter searchAdapter = new SearchAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search = findViewById(R.id.search);
        rv_product = findViewById(R.id.rv_product);

        navbar();

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });

        Product product = new Product(123, "Apple iPhone 13 Pro Max", 20000000, 6, 4.5);
        productList.add(product);
        productList.add(product);
        productList.add(product);
        productList.add(product);
        productList.add(product);
        Product product1 = new Product(123, "Samsumg Galaxy Tab S2", 20000000, 6, 4.5);
        productList.add(product1);

        searchAdapter.setArrayListdata(productList);
        rv_product.setAdapter(searchAdapter);
        rv_product.setLayoutManager(new LinearLayoutManager(this));

    }


    private void filter(String text){
        ArrayList<Product> filterList = new ArrayList<>();
        for (Product temp: productList){
            if(temp.getProductName().toLowerCase().contains(text.toLowerCase())){
                filterList.add(temp);
            }
        }
        searchAdapter.setArrayListdata(filterList);
    }

    void navbar() {
        BottomNavigationView navbar = findViewById(R.id.navbar);
//        navbar.setSelectedItemId(R.id.menu_home);
        navbar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_home) {
//                    finish();
                    return true;
                } else if (item.getItemId() == R.id.menu_cart) {
//                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                    startActivity(intent);
//                    finish();
                    return true;
                } else {
                    return true;
                }
            }
        });
    }

}