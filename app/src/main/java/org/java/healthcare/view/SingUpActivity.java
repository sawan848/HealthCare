package org.java.healthcare.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.java.healthcare.R;
import org.java.healthcare.dao.Database;

public class SingUpActivity extends AppCompatActivity {

    AppCompatButton loginBtn,registerBtn;
    TextInputEditText nameEditText,emailEditText,passwordEditText,phoneEditText,confirmEditTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        loginBtn=findViewById(R.id.buttonLogin);
        registerBtn=findViewById(R.id.buttonRegister);
        nameEditText=findViewById(R.id.editTextPersonName);
        emailEditText=findViewById(R.id.editTextPersonEmail);
        passwordEditText=findViewById(R.id.editTextPersonPassword);
        phoneEditText=findViewById(R.id.editTextPersonPhone);
        confirmEditTextPassword=findViewById(R.id.editTextPersonConfirmPassword);
        


        registerBtn.setOnClickListener(view -> {
            String name=nameEditText.getText().toString();
            String email=emailEditText.getText().toString();
            String phone=phoneEditText.getText().toString();
            String password=passwordEditText.getText().toString();
            String passwordConfirm=confirmEditTextPassword.getText().toString();
            Database database=new Database(getApplicationContext(),"healthcare",null,1);
            if (name.length()==0 || email.length()==0||phone.length()==0|| password.length()==0){
                Toast.makeText( getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
            }else {
                if (password.compareTo(passwordConfirm)==0){
                    if (isValid(password)){
                        database.register(name,email,password,phone);
                        Toast.makeText(getApplicationContext(), " Record Inserted  ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SingUpActivity.this,SignInActivity.class));
                    } else{
                        Toast.makeText(getApplicationContext(), "Password must contained 8 character having digit and special character  ", Toast.LENGTH_SHORT).show();
                    }
                }else{
                Toast.makeText(getApplicationContext(), "Password and confirm Password didn't match", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SingUpActivity.this,SignInActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }

    private boolean isValid(String password) {
        int f1=0,f2=0,f3=0;
        if (password.length()<8){
            return false;
        }else{
            for (int i = 0; i < password.length(); i++) {
                if (Character.isLetter(password.charAt(i))){
                    f1=1;
                }
            }
            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(password.charAt(i))){
                    f2=1;
                }
            }
            for (int i = 0; i < password.length(); i++) {

                char c=password.charAt(i);
                if (c>=33&&c<=46||c==64){
                    f3=1;
                }
            }
            if (f1==1 && f2==1 && f3==1)
                return true;
        return false;
        }
    }
}