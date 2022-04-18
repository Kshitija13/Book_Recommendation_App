package com.example.hello;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class set extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    TextView Name, Username, Password, Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Name = findViewById(R.id.tv3);
        Username = findViewById(R.id.tv2);
        Email = findViewById(R.id.tv1);

        String name = getIntent().getStringExtra("keyname");
        String email = getIntent().getStringExtra("keyname1");
        String username = getIntent().getStringExtra("keyname2");

        Name.setText(name);
        Email.setText(email);
        Username.setText(username);

        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);
        t.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(t);
        t.syncState();


        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.Profile) {
                    Toast.makeText(set.this, "My Account", Toast.LENGTH_SHORT).show();
                    Intent intent3 = new Intent(getApplicationContext(), set.class);
                    startActivity(intent3);
                    finish();
                } else if (id == R.id.Help) {
                    Toast.makeText(set.this, "Settings", Toast.LENGTH_SHORT).show();
                    Intent intent3 = new Intent(getApplicationContext(), help.class);
                    startActivity(intent3);
                    finish();
                } else if (id == R.id.WishList) {
                    Toast.makeText(set.this, "My Cart", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(getApplicationContext(), Wishlist.class);
                    startActivity(intent1);
                    finish();
                } else if (id == R.id.Logout) {
                    Toast.makeText(set.this, "Logout", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent2);
                    finish();
                }


                return true;

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}