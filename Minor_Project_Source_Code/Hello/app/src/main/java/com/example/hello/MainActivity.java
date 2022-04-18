package com.example.hello;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageView img,title,splashImg;
    com.airbnb.lottie.LottieAnimationView LottieAnimationView;

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                finish();

            }
        } ,5800);
        img = findViewById(R.id.img);
        //title = findViewById(R.id.title);
        splashImg = findViewById(R.id.bg);
        LottieAnimationView = findViewById(R.id.lottie);

        splashImg.animate().translationY(-2000).setDuration(1000).setStartDelay(4000);
        img.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
        title.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
        LottieAnimationView.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
    }
}