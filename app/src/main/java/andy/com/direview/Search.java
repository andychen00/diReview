package andy.com.direview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    EditText search;
    RecyclerView rv_product;
    ArrayList<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search = findViewById(R.id.search);
        rv_product = findViewById(R.id.rv_product);

        Product product = new Product(123, "Apple iPhone 13 Pro Max", 20000000, 6, 4.5);
        productList.add(product);
        productList.add(product);
        productList.add(product);
        productList.add(product);
        productList.add(product);
        productList.add(product);

        SearchAdapter searchAdapter = new SearchAdapter();
        searchAdapter.setArrayListdata(productList);
        rv_product.setAdapter(searchAdapter);
        rv_product.setLayoutManager(new LinearLayoutManager(this));

    }
}