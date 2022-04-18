package com.example.hello;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Wish extends AppCompatActivity {
    ImageView img;
    TextView tx1, tx2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish);
        tx1 = findViewById(R.id.t);
        tx2 = findViewById(R.id.c_desc2);

        String tx11 = getIntent().getStringExtra("keyname1");
        String tx22 = getIntent().getStringExtra("keyname2");

        tx1.setText(tx11);
        tx2.setText(tx22);
    }
}