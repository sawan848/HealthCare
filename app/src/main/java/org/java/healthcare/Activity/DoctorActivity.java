package org.java.healthcare.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.java.healthcare.R;

public class DoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        ImageView imageViewDoc1=findViewById(R.id.imageViewDoc2);
        TextView textViewDoc1=findViewById(R.id.textViewDoc4);

        imageViewDoc1.setOnClickListener(view -> {
            startActivity(new Intent(DoctorActivity.this,DoctorProfileActivity.class));

        });

        textViewDoc1.setOnClickListener(view -> {
            startActivity(new Intent(DoctorActivity.this,SignInActivity.class));
        });
    }
}