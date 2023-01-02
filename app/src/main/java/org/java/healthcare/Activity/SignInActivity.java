package org.java.healthcare.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.java.healthcare.R;
import org.java.healthcare.dao.Database;

public class SignInActivity extends AppCompatActivity {
    AppCompatButton registerBtn,loginBtn;
    EditText emailText,passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        registerBtn=findViewById(R.id.buttonRegister);
        loginBtn=findViewById(R.id.loginButton);
        emailText=findViewById(R.id.editTextPersonEmail);
        passwordText=findViewById(R.id.editTextPassword);



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=emailText.getText().toString();
                String password=passwordText.getText().toString();
                Database database=new Database(getApplicationContext(),"healthcare",null,1);
                if ( email.length()==0|| password.length()==0){
                    Toast.makeText( getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                }else {
                    if (database.login(email,password)==1){
                       Toast.makeText(getApplicationContext(), "login success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("email",email);
                        editor.apply();
                       startActivity(new Intent(SignInActivity.this,HomeActivity.class));
                    }else {
                       Toast.makeText(getApplicationContext(), "invalid username and password", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignInActivity.this,SingUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}