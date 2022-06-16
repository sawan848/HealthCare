package org.java.healthcare.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import org.java.healthcare.R;

public class HomeActivity extends AppCompatActivity {
    Button doctor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        doctor=findViewById(R.id.doctorBtn);
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "This is my Toast message!",
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}