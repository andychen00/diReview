package andy.com.direview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    public LoginActivity(Intent intent) {

    }

//    private static final String[] DUMMY_ACCOUNT = new String[]{
//            "foo@example.com:hello", "bar@example.com:world"
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        EditText userEmail = (EditText) findViewById(R.id.tfEmail);
        EditText  userPassword = (EditText) findViewById(R.id.tfPassword);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserMail = userEmail.getText().toString();
                String UserPwd = userPassword.getText().toString();
                if(UserMail.equalsIgnoreCase("kelompok3@binus.ac.id") && UserPwd.equals("password")){
                    Intent MainIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(MainIntent);
                    Toast.makeText(LoginActivity.this,"You are Sign in, Welcome.", Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(LoginActivity.this,"Email or Password is incorrect.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
