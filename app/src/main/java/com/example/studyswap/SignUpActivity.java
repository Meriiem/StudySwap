package com.example.studyswap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUpActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    Button signup;
    EditText fullName, phoneNumber, emailAddress, pass;
    TextView goToLoginActivity;
//    String majorSelected;
//    Spinner major = findViewById(R.id.major);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signing_up);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        progressDialog = new ProgressDialog(this);

        signup = findViewById(R.id.signup);
        goToLoginActivity = findViewById(R.id.goToLoginActivity);
        fullName = findViewById(R.id.fullName);
        phoneNumber = findViewById(R.id.phoneNumber);
        emailAddress = findViewById(R.id.emailAddress);
        pass = findViewById(R.id.password);
//        major = findViewById(R.id.major);
//        majorSelected = "";
        // Create an array adapter for the spinner


//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.majors, android.R.layout.simple_spinner_item);

//
//        // Set the layout for the drop down menu
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        // Set the adapter to the spinner
//        major.setAdapter(adapter);

        //Spinner listeners
//        major.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String[] m = getResources().getStringArray(R.array.majors);
//                majorSelected = m[position];
//                Log.d("OIII", "SELECTEEEEEEEEEEEEEEEED");
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                String name = fullName.getText().toString();
                String number = phoneNumber.getText().toString();
                String email = emailAddress.getText().toString().trim();
                String password = pass.getText().toString();

//                String Umajor = major.getSelectedItem().toString();

                progressDialog.show();

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                startActivity(new Intent(SignUpActivity.this, SplashScreen.class));
                                progressDialog.cancel();

                                firebaseFirestore.collection("Users")
                                        .document(FirebaseAuth.getInstance().getUid())
                                        .set(new UserModel(name,number,email));

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(SignUpActivity.this, e.getMessage(),Toast.LENGTH_SHORT).show();
                                progressDialog.cancel();

                            }
                        });

            }
        });

        goToLoginActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(SignUpActivity.this, SplashScreen.class));
            }
        });


    }
}