package andy.com.direview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Create_Review extends AppCompatActivity {
int star =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_review);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        EditText commentET = findViewById(R.id.commentET);

        String comment = commentET.getText().toString();

        ImageButton star1 = findViewById(R.id.star1);
        ImageButton star2 = findViewById(R.id.star2);
        ImageButton star3 = findViewById(R.id.star3);
        ImageButton star4 = findViewById(R.id.star4);
        ImageButton star5 = findViewById(R.id.star5);

        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star1.setImageResource(R.drawable.starclick);

                star2.setImageResource(R.drawable.star1);
                star3.setImageResource(R.drawable.star1);
                star4.setImageResource(R.drawable.star1);
                star5.setImageResource(R.drawable.star1);
                star=1;

            }
        });

        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star1.setImageResource(R.drawable.starclick);
                star2.setImageResource(R.drawable.starclick);

                star3.setImageResource(R.drawable.star1);
                star4.setImageResource(R.drawable.star1);
                star5.setImageResource(R.drawable.star1);
                star=2;
            }
        });

        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star1.setImageResource(R.drawable.starclick);
                star2.setImageResource(R.drawable.starclick);
                star3.setImageResource(R.drawable.starclick);

                star4.setImageResource(R.drawable.star1);
                star5.setImageResource(R.drawable.star1);
                star=3;
            }
        });

        star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star1.setImageResource(R.drawable.starclick);
                star2.setImageResource(R.drawable.starclick);
                star3.setImageResource(R.drawable.starclick);
                star4.setImageResource(R.drawable.starclick);

                star5.setImageResource(R.drawable.star1);
                star=4;
            }
        });

        star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star1.setImageResource(R.drawable.starclick);
                star2.setImageResource(R.drawable.starclick);
                star3.setImageResource(R.drawable.starclick);
                star4.setImageResource(R.drawable.starclick);
                star5.setImageResource(R.drawable.starclick);
                star=5;

            }
        });

        Button okbtn =  findViewById(R.id.okbtn1);

        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ganti intentnya ke detailact nanti tq
                Intent intent = new Intent(Create_Review.this, MainActivity.class);

                intent.putExtra("comment",comment);
                intent.putExtra("starrating",star);
                startActivity(intent);
            }
        });
    }
}