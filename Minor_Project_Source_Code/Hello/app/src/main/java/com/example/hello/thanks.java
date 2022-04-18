package com.example.hello;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class thanks extends AppCompatActivity {

    ImageView splashImg;
    TextView tv11, line, tv22;
    com.airbnb.lottie.LottieAnimationView LottieAnimationView;

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(thanks.this, dashboard.class);
                startActivity(intent);
                finish();

            }
        } ,3800);
        //img = findViewById(R.id.img);
        tv11 = findViewById(R.id.tv11);
        tv22 = findViewById(R.id.tv22);
        line = findViewById(R.id.line);
        splashImg = findViewById(R.id.imageView);
        LottieAnimationView = findViewById(R.id.lottie);

        splashImg.animate().translationY(-2000).setDuration(1000).setStartDelay(4000);
        //img.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
        tv11.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
        tv22.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
        line.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
        LottieAnimationView.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
    }
}