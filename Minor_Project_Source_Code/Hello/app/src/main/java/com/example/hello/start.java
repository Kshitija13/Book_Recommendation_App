package com.example.hello;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class start extends AppCompatActivity {
    ImageView img,splashImg;
    TextView title, line;
    com.airbnb.lottie.LottieAnimationView LottieAnimationView;

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(start.this, Login.class);
                startActivity(intent);
                finish();

            }
        } ,5800);
        img = findViewById(R.id.img);
        title = findViewById(R.id.title);
        splashImg = findViewById(R.id.bg);
        line  = findViewById(R.id.line);
        LottieAnimationView = findViewById(R.id.lottie);

        splashImg.animate().translationY(-2000).setDuration(1000).setStartDelay(4000);
        img.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
        title.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
        line.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
        LottieAnimationView.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
    }
}