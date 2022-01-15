package andy.com.direview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Create extends AppCompatActivity {
    String category;
    int img;
    int price;
    ImageView previewimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        Context context = this.getApplicationContext();
        EditText productnameET = findViewById(R.id.productnameedittext);
        EditText descriptionET = findViewById(R.id.descriptionedittext);
        EditText specificationET = findViewById(R.id.specificationedittext);
        EditText priceET = findViewById(R.id.priceedittext);
        Button addimgbtn = findViewById(R.id.addimgbtn);
        Button okbtn = findViewById(R.id.okbtn);
        previewimg = findViewById(R.id.previewimg);

        TextView descriptiontv = findViewById(R.id.descriptiontv);

//        descriptiontv.setText("test");

        Spinner dropdown = findViewById(R.id.spinner1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.dropdownlist,R.layout.dropdownlayout);
        adapter.setDropDownViewResource(R.layout.dropdownadapter);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String text = dropdown.getItemAtPosition(i).toString();
//                Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
            category = text;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productname = productnameET.getText().toString();
                String description = descriptionET.getText().toString();
                String specification = specificationET.getText().toString();

                try {
                     price =Integer.parseInt(priceET.getText().toString()) ;
                }catch (Exception e)
                {
                    price =0;
                }


//                Product product = new Product(img,productname,price,0,0;

//                change intent destination to detail(?)
                Intent intent = new Intent(context,MainActivity.class);
//                Toast.makeText(context, "intent", Toast.LENGTH_SHORT).show();


                intent.putExtra("productname",productname);
                intent.putExtra("productdesc" , description);
                intent.putExtra("productspec" , specification);
                intent.putExtra("productcategory",category);
                intent.putExtra("productprice",price);
//                intent.putExtra("productimg",previewimg);

                startActivity(intent);





            }
        });

        addimgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img = 0;
                imageChooser();
            }
        });

    }
    void imageChooser() {


        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);


        startActivityForResult(Intent.createChooser(i, "Select Picture"), 200);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {


            if (requestCode == 200) {

                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {

                    previewimg.setImageURI(selectedImageUri);
//                   Toast.makeText(this,previewimg.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}