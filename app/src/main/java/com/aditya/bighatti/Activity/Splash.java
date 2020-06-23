package com.aditya.bighatti.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Window;

import com.aditya.bighatti.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Splash extends AppCompatActivity {

    private  FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       firebaseAuth=FirebaseAuth.getInstance();


//        SystemClock.sleep(1000);
//        Intent intent=new Intent(Splash.this,Register.class);
//        startActivity(intent);
//        finish();
//        Thread thread = new Thread() {
//            public void run()
//            {
//                try {
//                    Thread.sleep(3000);
//
//                    SharedPreferences sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
//                    boolean test = sharedPreferences.getBoolean("Status", false);
//                    if (test) {
//                        Intent intent = new Intent(getApplicationContext(),Register.class);
//                        startActivity(intent);
//                    } else {
//                        Intent intent = new Intent(getApplicationContext(), Splash.class);
//                        startActivity(intent);
//                    }
//                }
//
//                catch(Exception e)
//                {
//                    Log.d("ErrorSplash",e.toString());
//
//                }
//            }
//        };
//        thread.start();



    }
    protected void onStart() {

        super.onStart();
        FirebaseUser currentUser=firebaseAuth.getCurrentUser();
        if(currentUser==null){
            Thread thread = new Thread()
            {
                public void run()
                {
                    try
                    {
                        Thread.sleep(3000);
                        Intent intent = new Intent(getApplicationContext(),Register.class);
                        startActivity(intent);
                    }
                    catch (Exception e)
                    {
                        Log.d("ErrorSplash",e.toString());
                    }
                }
            };
            thread.start();
        }else
        {
            Thread thread = new Thread()
            {
                public void run()
                {
                    try
                    {
                        Thread.sleep(3000);
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                    catch (Exception e)
                    {
                        Log.d("ErrorSplash",e.toString());
                    }
                }
            };
            thread.start();

        }
    }
}
