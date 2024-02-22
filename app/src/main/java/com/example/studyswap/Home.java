package com.example.studyswap;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    private EditText etMajor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        etMajor = findViewById(R.id.et_major);

        Button btnSaveMajor = findViewById(R.id.btn_save_major);
        btnSaveMajor.setOnClickListener(v -> {
            String major = etMajor.getText().toString().trim();
            if (!major.isEmpty()) {
                // Save the major to preferences using PreferencesManager
                PreferencesManager.setUserMajor(Home.this, major);
                // Notify the user that the major has been saved
                Toast.makeText(Home.this, "Major saved successfully!", Toast.LENGTH_SHORT).show();
            } else {
                // Notify the user to enter a major if the EditText is empty
                Toast.makeText(Home.this, "Please enter a major.", Toast.LENGTH_SHORT).show();
            }
        });

//        Button btnToHomepageA = findViewById(R.id.btn_to_homepage_a);
//        btnToHomepageA.setOnClickListener(v -> navigateTo(HomePageAActivity.class));
//
//        Button btnToHomepageB = findViewById(R.id.btn_to_homepage_b);
//        btnToHomepageB.setOnClickListener(v -> navigateTo(HomePageBActivity.class));

        Button btnToHomeWithSearch = findViewById(R.id.btn_to_home_with_search);
        btnToHomeWithSearch.setOnClickListener(v -> navigateTo(HomeWithSearchActivity.class));

//        Button btnToFeaturesPage = findViewById(R.id.btn_to_features_page);
//        btnToFeaturesPage.setOnClickListener(v -> navigateTo(FeaturesPageActivity.class));

//        Button btnToMyCounter = findViewById(R.id.btn_to_my_counter);
//        btnToMyCounter.setOnClickListener(v -> navigateTo(MyCounterActivity.class));

        Button btnToReceivedRequests = findViewById(R.id.btn_to_received_requests);
        btnToReceivedRequests.setOnClickListener(v -> navigateTo(ReceivedRequests.class));

        Button btnToSentRequests = findViewById(R.id.btn_to_sent_requests);
        btnToSentRequests.setOnClickListener(v -> navigateTo(SentRequests.class));
//
        Button btnToSearch = findViewById(R.id.btn_to_search);
        btnToSearch.setOnClickListener(v -> navigateTo(HomeWithSearchActivity.class));

//        Button btnToCreateAccount = findViewById(R.id.btn_to_create_account);
//        btnToCreateAccount.setOnClickListener(v -> navigateTo(CreateAccountActivity.class));

        // Additional setup for other buttons if needed
    }

    private void navigateTo(Class<?> activityClass) {
        Intent intent = new Intent(Home.this, activityClass);
        startActivity(intent);
    }
}
