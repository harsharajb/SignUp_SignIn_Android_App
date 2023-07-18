package com.example.signup;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText email1,password1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email1=findViewById(R.id.editText3);
        password1=findViewById(R.id.editText4);
    }

    public void signup(View view)
    {
        String email=email1.getText().toString();
        String password=password1.getText().toString();
        if(!isValidPassword(password))
        {
            Toast.makeText(this,"Password does not match",Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent= new Intent(this,LogIn.class);
        intent.putExtra("email",email);
        intent.putExtra("password",password);
        startActivity(intent);
    }
    Pattern lowercase=Pattern.compile("^.*[a-z].*$");
    Pattern uppercase=Pattern.compile("^.*[A-Z].*$");
    Pattern number=Pattern.compile("^.*[0-9].*$");
    Pattern schar=Pattern.compile("^.*[^a-zA-Z0-9].*$");

    private Boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        if (!lowercase.matcher(password).matches()) {
            return false;
        }
        if (!uppercase.matcher(password).matches()) {
            return false;
        }
        if (!number.matcher(password).matches()) {
            return false;
        }
        if (!schar.matcher(password).matches()) {
            return false;
        }
        return true;
    }
}
