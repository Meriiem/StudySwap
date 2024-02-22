package com.example.studyswap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {


    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    Button login;
    EditText pass, emailAddress;
    TextView resetPassword, goToSignUpActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        login = findViewById(R.id.login);
        goToSignUpActivity = findViewById(R.id.goToSignUpActivity);
        emailAddress = findViewById(R.id.login_email);
        pass = findViewById(R.id.login_pass);
        resetPassword = findViewById(R.id.resetPassword);


        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String email = emailAddress.getText().toString().trim();
                String password = pass.getText().toString().trim();

                progressDialog.show();

                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                progressDialog.cancel();
                                Toast.makeText(SplashScreen.this, "Login Successfully", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(SplashScreen.this, Profile.class));
                            }
                        })

                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.cancel();
                                Toast.makeText(SplashScreen.this, e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailAddress.getText().toString();
                progressDialog.setTitle("Sending Mail");
                progressDialog.show();

                firebaseAuth.sendPasswordResetEmail(email)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                progressDialog.cancel();
                                Toast.makeText(SplashScreen.this, "Email Sent", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.cancel();
                                Toast.makeText(SplashScreen.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        goToSignUpActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(SplashScreen.this, SignUpActivity.class));
            }
        });

    }
}