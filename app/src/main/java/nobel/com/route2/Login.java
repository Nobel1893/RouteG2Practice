package nobel.com.route2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

public class Login extends AppCompatActivity {


    EditText userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //recieve parameter in intent
        String userNameParameter = getIntent().getStringExtra("username");
        Log.e("username",userNameParameter);
        userName = findViewById(R.id.username);
        userName.setText(userNameParameter);
    }
}
