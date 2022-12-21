package org.java.healthcare.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import org.java.healthcare.R;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("email","").toString();

        CardView logout=findViewById(R.id.homeCardLogoutView);
        CardView findDoctor=findViewById(R.id.homeCardFindDoctorView);

        logout.setOnClickListener(view -> {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.clear();
            editor.apply();
            Toast.makeText(getApplicationContext(), "logout successfull", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(HomeActivity.this,SignInActivity.class));

        });

        findDoctor.setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this,FindDoctorActivity.class));

        });


    }
}