package com.example.hello;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Signup extends AppCompatActivity {

    TextView Name, Username, Password, Email;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        Name = findViewById(R.id.name);
        Username = findViewById(R.id.user);
        Password = findViewById(R.id.pass);
        Email = findViewById(R.id.email);
        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name, username, password, email;
                name = String.valueOf(Name.getText());
                username = String.valueOf(Username.getText());
                password = String.valueOf(Password.getText());
                email = String.valueOf(Email.getText());

                Intent intent = new Intent(Signup.this, set.class);
                intent.putExtra("keyname",name);
                intent.putExtra("keyname1",email);
                intent.putExtra("keyname2",username);
                startActivity(intent);


                if (!name.equals("") && !username.equals("") && !password.equals("") && !email.equals("")) {

                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[4];
                            field[0] = "name";
                            field[1] = "username";
                            field[2] = "password";
                            field[3] = "email";
                            //Creating array for data
                            String[] data = new String[4];
                            data[0] = name;
                            data[1] = username;
                            data[2] = password;
                            data[3] = email;
                            PutData putData = new PutData("http://192.168.1.107/Login/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Sign Up Success")) {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), Login.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                        });
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"All fields are required!", Toast.LENGTH_SHORT).show();
                    }
                }
        });

    }
}