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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    EditText email,password,age;
    Spinner spinner1,spinner2,spinner3,spinner4;
    RadioGroup gender;
    Button signupbutton;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        // ...
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);
        gender = findViewById(R.id.choosegender);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        age = findViewById(R.id.age);
        signupbutton = findViewById(R.id.signupbotton);
        final String[] gendershow = new String[1];

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton radioButton = findViewById(gender.getCheckedRadioButtonId());
                    gendershow[0] = radioButton.getText().toString();

            }

        });

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string_username = email.getText().toString().trim();
                String string_password = password.getText().toString().trim();
                String string_age = age.getText().toString().trim();
                String spinner11 = spinner1.getSelectedItem().toString();
                String spinner12 = spinner2.getSelectedItem().toString();
                String spinner13 = spinner3.getSelectedItem().toString();
                String spinner14 = spinner4.getSelectedItem().toString();
                String schedule = "from" + spinner11 + ":" +spinner12 + "to" + spinner13 + ":" +spinner14;
                if(TextUtils.isEmpty(string_username)) {
                    Toast.makeText(getApplicationContext(),"Please enter the Email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(string_password)) {
                    Toast.makeText(getApplicationContext(),"Please enter the password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(string_age)) {
                    Toast.makeText(getApplicationContext(),"Please enter the age",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(string_username).matches()){
                    Toast.makeText(getApplicationContext(),"Email format is wrong",Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(string_username,string_password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    User user = new User(string_username, string_age, gendershow[0], schedule);
                                    FirebaseDatabase.getInstance().getReference("Users")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            if(task.isSuccessful()){
                                                Toast.makeText(getApplicationContext(),"User has been registered successfully!", Toast.LENGTH_SHORT).show();

                                            }
                                            else{
                                                Toast.makeText(getApplicationContext(),"Failed to register! try again", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                    Toast.makeText(getApplicationContext(),"User has been registered successfully!", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(SignupActivity.this, HomeActivity.class);
                                    startActivity(i);
                                }else {
                                    Toast.makeText(getApplicationContext(),"Failed to register! try again", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
             //   Toast.makeText(getApplicationContext(),"Register succeed!",Toast.LENGTH_SHORT).show();
              //  Intent i = new Intent(SignupActivity.this, HomeActivity.class);
               // startActivity(i);
            }
        });
    }
}