package com.example.sleeptight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    Button reg, log;
    EditText username, password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         // ...
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        /*
        click button and move to next activity
         */
        reg = (Button) findViewById(R.id.no_account);
        reg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });
        log = (Button) findViewById(R.id.login);
        username = findViewById(R.id.email);
        password = findViewById(R.id.editpassword);
        log.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /*
                make a toast for entering username and password
                */
                String string_username = username.getText().toString().trim();
                if (TextUtils.isEmpty(string_username)) {
                    Toast.makeText(getApplicationContext(), "Please enter the username!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String string_password = password.getText().toString().trim();
                if (TextUtils.isEmpty(string_password)) {
                    Toast.makeText(getApplicationContext(), "Please enter the password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(string_username).matches()){
                    Toast.makeText(getApplicationContext(),"Email format is wrong",Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(string_username,string_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Login successful!",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Failed to login! Please check your credentials.",Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                //Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                //startActivity(i);
            }
        });
    }

}




