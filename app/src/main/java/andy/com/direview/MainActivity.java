package andy.com.direview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//test :
//andychen

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goToDetail(View view) {
        Intent intent = new Intent(MainActivity.this, DetailAct.class);
        startActivity(intent);
    }
}