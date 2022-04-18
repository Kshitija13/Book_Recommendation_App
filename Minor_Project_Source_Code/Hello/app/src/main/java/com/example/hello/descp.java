package com.example.hello;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class descp extends AppCompatActivity {

    Button but5,b0;
    ImageView dwn,img;
    TextView tx1;
    TextView tx2;
    //int image;
    long queueid;
    DownloadManager dm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descp);
        but5 = (Button) findViewById(R.id.but4);
        b0 = (Button) findViewById(R.id.but0);
        dwn = findViewById(R.id.dwn);
        img = findViewById(R.id.l_img);
        tx1 = findViewById(R.id.l_title);
        tx2 = findViewById(R.id.l_desc);

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(descp.this, Wish.class);
                intent.putExtra("keyname1", tx1.getText());
                intent.putExtra("keyname2", tx2.getText());
                startActivity(intent);
            }
        });


        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), feedb.class);
                startActivity(intent);
                finish();
            }
        });

        dwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse("http://www.s627372639.onlinehome.us/MORNINGSTAR-Excerpt.pdf"));
                request.setDescription("Downloading File Please Wait...");
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                DownloadManager downloadManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
                downloadManager.enqueue(request);

                Toast.makeText(descp.this, "Downloading started", Toast.LENGTH_SHORT).show();

            }
        });
    }
}