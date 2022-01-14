package andy.com.direview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {


//    private static final String[] DUMMY_ACCOUNT = new String[]{
//            "foo@example.com:hello", "bar@example.com:world"
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        EditText userEmail = (EditText) findViewById(R.id.tfEmail);
        EditText  userPassword = (EditText) findViewById(R.id.tfPassword);
        Button clickLogin = (Button) findViewById(R.id.btnLogin);

        clickLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserName = userEmail.getText().toString();
                String Pwd = userPassword.getText().toString();
                if(UserName.equalsIgnoreCase("kelompok3@binus.ac.id") && Pwd.equals("password")){
                    Intent MainIntent = new Intent(LoginActivity.this, CategoryActivity.class);
                    startActivity(MainIntent);
                    Toast.makeText(LoginActivity.this,"You are Signed in.", Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(LoginActivity.this,"Email or Password is incorrect.", Toast.LENGTH_LONG).show();
                }
            }

        });

    }

}
