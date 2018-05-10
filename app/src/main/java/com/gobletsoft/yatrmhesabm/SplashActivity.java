package com.gobletsoft.yatrmhesabm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        Thread timerThread = new Thread(){
            public void run(){

                try{

                    sleep(1500);
                }catch(InterruptedException e){

                    e.printStackTrace();
                }finally{

                    Intent intent = new Intent(SplashActivity.this, presentFutureActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause(){

        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}
