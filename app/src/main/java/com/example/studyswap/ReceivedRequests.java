package com.example.studyswap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ReceivedRequests extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Request> requests;
    private RequestAdapter adapter;
    private ImageView backButton;
    private ImageView homeButton;
    private ImageView profileButton;
    private ImageView sentRequestsButton;
    private ImageView receivedRequestsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_received_requests);

        listView = findViewById(R.id.list_viewR);
        backButton = findViewById(R.id.back_button);
        homeButton = findViewById(R.id.home_button);
        profileButton = findViewById(R.id.profile_button);
        sentRequestsButton = findViewById(R.id.sent_requests_button);
        receivedRequestsButton = findViewById(R.id.received_requests_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start a new activity to go to the home screen
                Intent intent = new Intent(ReceivedRequests.this, HomeWithSearchActivity.class);
                startActivity(intent);
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReceivedRequests.this, Profile.class);
                startActivity(intent);
            }
        });

        sentRequestsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReceivedRequests.this, SentRequests.class);
                startActivity(intent);
            }
        });

        receivedRequestsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        requests = new ArrayList<>();

        requests.add(new Request(R.drawable.mathematics_book, "Maths1", "@user123", "10:00 AM"));
        requests.add(new Request(R.drawable.engineering_experiments, "Lab - Physics", "@newstd", "10:15 AM"));
        requests.add(new Request(R.drawable.english_literature, "English", "@sultan", "10:30 AM"));

        adapter = new RequestAdapter(this, requests);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Request request = requests.get(position);

                Button acceptButton = view.findViewById(R.id.accept_buttonR);
                Button declineButton = view.findViewById(R.id.decline_buttonR);
                Button contactButton = view.findViewById(R.id.contact_buttonR);

                acceptButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        acceptButton.setVisibility(View.GONE);
                        declineButton.setVisibility(View.GONE);

                        contactButton.setVisibility(View.VISIBLE);

                        Toast.makeText(ReceivedRequests.this, "You accepted the request for " + request.getItemTitle(), Toast.LENGTH_SHORT).show();
                    }
                });

                declineButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        requests.remove(position);
                        adapter.notifyDataSetChanged();

                        Toast.makeText(ReceivedRequests.this, "You declined the request for " + request.getItemTitle(), Toast.LENGTH_SHORT).show();
                    }
                });

                contactButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Start a new activity to contact the user
                        Intent intent = new Intent(ReceivedRequests.this, Home.class);
                        intent.putExtra("user_name", request.getUserName());
                        startActivity(intent);
                    }

                });

            }
        });
    }
}
