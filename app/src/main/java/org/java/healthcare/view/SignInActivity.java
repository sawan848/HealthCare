package org.java.healthcare.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.EditText;

import org.java.healthcare.R;

public class SignInActivity extends AppCompatActivity {
    AppCompatButton registerBtn,loginBtn;
    EditText emailText,passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }
}