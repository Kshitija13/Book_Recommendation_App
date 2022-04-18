package com.example.hello;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import helper.homeadapter.CategoryHelperClass;
import helper.homeadapter.FeaturedHelperClass;
import helper.homeadapter.LatestHelperClass;


public class dsb extends AppCompatActivity{
    RecyclerView featureRecycler, latestRecycler, catRecycler, featureRecycler1;
    RecyclerView.Adapter adapter;
    //private featuredadapter.Rvc listener;

    Connection connect;
    String connectionResult = "";

    TextView tv;
    EditText ett;
    ImageView but1, pro, c_img, bokb, setting;


    public void GetDataToTextView(View v) {
        TextView txt = (TextView) findViewById(R.id.txt);
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.conclass();
            if (connect != null) {
                String query = "Select * from users";
                Statement smt = connect.createStatement();
                ResultSet rs = smt.executeQuery(query);

                while (rs.next()) {
                    txt.setText(rs.getString(1));
                }
            }

        } catch (Exception ex) {
            Log.e("Error :", ex.getMessage());
        }
    }

    @SuppressLint({"ResourceType", "CutPasteId"})
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsb);
        pro = (ImageView) findViewById(R.id.pro);
        setting = (ImageView) findViewById(R.id.set);
        c_img = (ImageView) findViewById(R.id.but1);

        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), profile.class);
                startActivity(intent);
                finish();
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), set.class);
                startActivity(intent);
                finish();
            }
        });

        c_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), dashboard.class);
                startActivity(intent);
                finish();
            }
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        featureRecycler = findViewById(R.id.featured_recycler);
        featureRecycler1 = findViewById(R.id.featured_recycler);
        latestRecycler = findViewById(R.id.latestrecycler);
        catRecycler = findViewById(R.id.categoryrecycler);

        latestRecycler();
        featureRecycler();
        catRecycler();
    }

    private void catRecycler() {
        bokb = (ImageView) findViewById(R.id.featured_image);
        catRecycler.setHasFixedSize(true);
        catRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<CategoryHelperClass> category = new ArrayList<>();

        category.add(new CategoryHelperClass(R.drawable.bookb, "Fiction", "Tall Tales"));
        category.add(new CategoryHelperClass(R.drawable.booka, "Science Fiction", "Morning Star"));
        category.add(new CategoryHelperClass(R.drawable.bookc, "Thriller", "The Empty Nest"));
        category.add(new CategoryHelperClass(R.drawable.bookd, "Non-fiction", "Civil War"));
        category.add(new CategoryHelperClass(R.drawable.booke, "Fantasy", "The Guardians"));
        category.add(new CategoryHelperClass(R.drawable.booka, "Educational", "Introduction to Algorithms"));
        adapter = new categoryadapter(category);
        catRecycler.setAdapter(adapter);
    }

    private void latestRecycler() {

        latestRecycler.setHasFixedSize(true);
        latestRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<LatestHelperClass> latestbooks = new ArrayList<>();

        latestbooks.add(new LatestHelperClass(R.drawable.booka, "The Red Signal", "A short gift book of festive hospital diaries from the author of million-copy bestseller."));
        latestbooks.add(new LatestHelperClass(R.drawable.bookc, "My Little Pony", "Twilight Sparkle receives a mysterious message about a missing turtle!"));
        latestbooks.add(new LatestHelperClass(R.drawable.bookd, "The Last Wife", "This will be a strong contender for one of the best books of the year, even this early on."));
        latestbooks.add(new LatestHelperClass(R.drawable.bookb, "The Empty Nest", "Brett has his hooks in me and I want more of The Demon Cycle."));
        adapter = new l_adapter(latestbooks);
        latestRecycler.setAdapter(adapter);
    }

    private void featureRecycler() {

        but1 = (ImageView) findViewById(R.id.but1);
        featureRecycler.setHasFixedSize(true);
        featureRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations1 = new ArrayList<>();
        adapter = new featuredadapter(featuredLocations1);
        featureRecycler.setAdapter(adapter);

        featuredLocations1.add(new FeaturedHelperClass(R.drawable.booka, "Morning Star", " The Wheel of Time turns and Ages come and go, leaving memories that become legend."));
        featuredLocations1.add(new FeaturedHelperClass(R.drawable.bookb, "Attack of Titans", "As Eren and Krista find new enemies, the Survey Corps faces threats from both inside and outside the walls. And what will happen to Ymir, now that she has decided to make herself the Titans' prize?"));
        featuredLocations1.add(new FeaturedHelperClass(R.drawable.bookc, "God of War: The Official Novelization", "The novelization of the highly anticipated God of War 4 game."));
        featuredLocations1.add(new FeaturedHelperClass(R.drawable.bookd, "Civil War: Volume 1", "The landscape of the Marvel Universe is changing; and it's time to choose."));
        featuredLocations1.add(new FeaturedHelperClass(R.drawable.booke, "Crossroads of Twilight: Book Ten of 'The Wheel of Time", "Patterns of the Wheel: Coloring Art Based on Robert Jordan's The Wheel of TimeAt the Publisher's request."));
    }

}
