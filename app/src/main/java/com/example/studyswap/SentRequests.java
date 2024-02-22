package com.example.studyswap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SentRequests extends AppCompatActivity {

    private ListView listView;
    private TextView activityName;
    private ImageView backButton;
    private ImageView homeButton;
    private ImageView profileButton;
    private ImageView sentRequestsButton;
    private ImageView receivedRequestsButton;

    private ArrayList<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent_requests);

        listView = findViewById(R.id.list_view);
        activityName = findViewById(R.id.activity_name);
        backButton = findViewById(R.id.back_button);
        homeButton = findViewById(R.id.home_button);
        profileButton = findViewById(R.id.profile_button);
        sentRequestsButton = findViewById(R.id.sent_requests_button);
        receivedRequestsButton = findViewById(R.id.received_requests_button);

        activityName.setText("Sent Requests");

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go back to the previous activity
                Intent intent = new Intent(SentRequests.this, Profile.class);
                startActivity(intent);
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SentRequests.this, Home.class);
                startActivity(intent);
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SentRequests.this, Profile.class);
                startActivity(intent);
            }
        });

        sentRequestsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        receivedRequestsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SentRequests.this, ReceivedRequests.class);
                startActivity(intent);
            }
        });

        listItems = new ArrayList<>();
        listItems.add(new ListItem(R.drawable.engineering, "Engineering - Book", "Pending", "saraa", "20 Nov 2023"));
        listItems.add(new ListItem(R.drawable.math, "Math 001 - Notes", "Accepted", "ahmed123", "19 Nov 2023"));
        listItems.add(new ListItem(R.drawable.algorithms_book, "Algorithms Ch1", "Rejected", "talamustafa", "18 Nov 2023"));

        CustomAdapter adapter = new CustomAdapter(this, listItems);

        listView.setAdapter(adapter);

    }
}
