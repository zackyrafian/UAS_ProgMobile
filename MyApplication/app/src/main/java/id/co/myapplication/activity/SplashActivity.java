package id.co.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import id.co.myapplication.Main;
import id.co.myapplication.R;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_TIMEOUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, Main.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIMEOUT);
    }
}

