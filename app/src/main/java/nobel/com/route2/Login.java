package nobel.com.route2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import nobel.com.route2.Base.MyBaseActivity;

public class Login extends MyBaseActivity {


    EditText userName;
    EditText password;
    CheckBox remember_me;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //recieve parameter in intent
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        remember_me = findViewById(R.id.remember);
        login = findViewById(R.id.login);
        String usernamestring =getString("username");
        String passwordString =getString("password");
        if (usernamestring!=null)
            userName.setText(usernamestring);
        if(passwordString!=null)
            password.setText(passwordString);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String usernameString= userName.getText().toString();
                final String passwordString = password.getText().toString();

                if(usernameString.equals(""))
                    ShowMessageDialoge("error","please enter userName");
                else if(passwordString.equals(""))
                    ShowMessageDialoge("error","please enter password");
                else {


                    ShowProgressBar();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            HideProgressBar();
                            ShowMessageDialoge("success","Logged in Successfully");
                            if(remember_me.isChecked()){
                                saveString("username",usernameString);
                                saveString("password",passwordString);
                            }else {
                                saveString("username",null);
                                saveString("password",null);

                            }
                        }
                    }, 5000);
                }

            }
        });

    }
}
