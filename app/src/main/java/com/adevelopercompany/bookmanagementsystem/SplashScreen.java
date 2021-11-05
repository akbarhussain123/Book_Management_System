package com.adevelopercompany.bookmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    ImageView ivBook;
    TextView tvReading, tvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ivBook = findViewById(R.id.ivBook);
        tvReading = findViewById(R.id.tv_reading);
        tvDetail = findViewById(R.id.tvDetail);
        long splashDelay = 3000;
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, splashDelay);
        Animation logoAnimation = AnimationUtils.loadAnimation(this, R.anim.logo_animation);
        Animation textAnimation = AnimationUtils.loadAnimation(this, R.anim.text_animations);
        Animation detailAnimation = AnimationUtils.loadAnimation(this, R.anim.detail_animations);
        ivBook.startAnimation(logoAnimation);
        tvReading.startAnimation(textAnimation);
        tvDetail.startAnimation(detailAnimation);
    }
}