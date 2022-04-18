package com.example.hello;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import helper.homeadapter.CategoryHelperClass;
import helper.homeadapter.FeaturedHelperClass;
import helper.homeadapter.LatestHelperClass;


public class dashboard extends AppCompatActivity{
    RecyclerView featureRecycler, latestRecycler, catRecycler, featureRecycler1;
    RecyclerView.Adapter adapter;

    Connection connect;
    String connectionResult = "";


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
        setContentView(R.layout.dashboard_activity);
        pro = (ImageView) findViewById(R.id.pro);
        setting = (ImageView) findViewById(R.id.set);
        c_img = (ImageView) findViewById(R.id.c_img);

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

        latestbooks.add(new LatestHelperClass(R.drawable.twlght, "Crossroads of Twilight", "A short gift book of festive hospital diaries from the author of million-copy bestseller."));
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

        if (!Python.isStarted())
            Python.start(new AndroidPlatform(this));

        Python py = Python.getInstance();

        PyObject pyobj = py.getModule("rec");

        PyObject obj = pyobj.callAttr("read_book", "Salvaged");

        String res = obj.toString();

        if (!Python.isStarted())
            Python.start(new AndroidPlatform(this));

        Python py1 = Python.getInstance();

        PyObject pyobj1 = py.getModule("rec");

        PyObject obj1 = pyobj.callAttr("read_book", res);

        String res1 = obj1.toString();

        if (!Python.isStarted())
            Python.start(new AndroidPlatform(this));

        Python py2 = Python.getInstance();

        PyObject pyobj2 = py.getModule("rec");

        PyObject obj2 = pyobj.callAttr("read_book", res1);

        String res2 = obj2.toString();

        ArrayList<FeaturedHelperClass> featuredLocations1 = new ArrayList<>();
        adapter = new featuredadapter(featuredLocations1);
        featureRecycler.setAdapter(adapter);


        featuredLocations1.add(new FeaturedHelperClass(R.drawable.booka, "Salvaged", " The Wheel of Time turns and Ages come and go, leaving memories that become legend."));
        featuredLocations1.add(new FeaturedHelperClass(R.drawable.bookb, res, "NEW YORK TIMES BESTSELLER."));
        featuredLocations1.add(new FeaturedHelperClass(R.drawable.bookc, res1, "A FEAST FOR CROWS is the fourth volume in the series. The Lannisters are in power on the Iron Throne. The war in the Seven Kingdoms has burned itself out, but in its bitter aftermath new conflicts spark to life."));
        featuredLocations1.add(new FeaturedHelperClass(R.drawable.bookd, res2, "The Restaurant at the End of the Universe, Life, the Universe and Everything, So Long, and Thanks for All the Fish, and Mostly Harmless."));

        //featureRecycler1.setVisibility(View.INVISIBLE);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                featureRecycler1.setVisibility(View.VISIBLE);
            }
        });

    }

}
