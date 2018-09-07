package nobel.com.route2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import nobel.com.route2.Base.MyBaseActivity;
import nobel.com.route2.Calculator.calculator;

public class Splash extends MyBaseActivity {

    Button ok;
    Button openBrowser;
    Button openRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    /*
        how to delay two seconds and execute a function
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(Splash.this,Login.class);
                //save username inside intent
                intent.putExtra("username","Mohamed");
                startActivity(intent);
                finish();
            }
        }, 2000);
        */
        Log.e("LifeCycle","onCreateCalled");
        String s="fghjk";
        Log.e("string",s);
        ok =  findViewById(R.id.ok);// connect ok button with design
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Splash.this,calculator.class);
                //save username inside intent
                intent.putExtra("username","Mohamed");
                startActivity(intent);
                finish();
            }
        });
        openRecyclerView =  findViewById(R.id.open_recycler_view);// connect ok button with design
        openRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(activity,CarsActivity.class);
                 startActivity(intent);
            }
        });

        openBrowser = findViewById(R.id.openBrowser);
        openBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.google.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        } );

        Button openMessageDialoge = findViewById(R.id.show_message_dialoge);
        openMessageDialoge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // ShowProgressBar();
                ShowMessageDialoge("title","Hello from route");
            }
        } );
 Button show_login = findViewById(R.id.show_login);
        show_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(activity,Login.class));
               // ShowProgressBar();
              // ShowMessageDialoge("title","Hello from route");
            }
        } );


    }


    public void ShowName(String name){

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LifeCycle","onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LifeCycle","onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LifeCycle","onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LifeCycle","onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LifeCycle","onDestroy");


    }
}
