package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
    EditText email2,password2;
    String remial,rpassword;
    Button signInBtn;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        email2=findViewById(R.id.editText3);
        password2=findViewById(R.id.editText4);
        signInBtn=findViewById(R.id.button2);
        remial=getIntent().getStringExtra("email");
        rpassword=getIntent().getStringExtra("password");

    }

    public void login(View view)
    {
        String email=email2.getText().toString();
        String password=password2.getText().toString();
        if(remial.equals(email) && rpassword.equals(password))
        {
            Toast.makeText(this,"Login Success",Toast.LENGTH_LONG).show();
        }
        else
        {
            count++;
            if(count>=3)
            {
                signInBtn.setEnabled(false);
            }
            else
            {
                Toast.makeText(this,"Invalid",Toast.LENGTH_LONG).show();
            }
        }
    }
}