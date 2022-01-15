package andy.com.direview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class DetailAct extends AppCompatActivity {

    private ImageView mImageView;
    private Button reviewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        init();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);

        mImageView.setImageResource(R.drawable.android_nums);
    }

    public void init(){
        mImageView = findViewById(R.id.productView);
        reviewBtn = findViewById(R.id.reviewBtn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void backToHome(View view) {
        Intent intent = new Intent(DetailAct.this, Create_Review.class);
        startActivity(intent);
    }
}