package com.example.studyswap;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CourseMaterialDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_item_details);

        // Retrieve the CourseMaterial object passed from the previous Activity
        CourseMaterial courseMaterial = (CourseMaterial) getIntent().getSerializableExtra("EXTRA_COURSE_MATERIAL");

        // Initialize the Views
        TextView titleTextView = findViewById(R.id.itemTitle);
        ImageView itemImageView = findViewById(R.id.itemImage);
        TextView statusTextView = findViewById(R.id.itemStatus);
        TextView typeTextView = findViewById(R.id.itemType);
        TextView courseNameTextView = findViewById(R.id.courseName);
        TextView yearTextView = findViewById(R.id.academicYear);
        TextView majorTextView = findViewById(R.id.major);

        // Navigation
        ImageButton back_button = findViewById(R.id.back_button);

        ImageButton home_button = findViewById(R.id.home_button);
        ImageButton profile_button = findViewById(R.id.profile_button);
        ImageButton sent_requests_button = findViewById(R.id.sent_requests_button);
        ImageButton received_requests_button = findViewById(R.id.received_requests_button);

        // Set the content of the Views
        titleTextView.setText(courseMaterial.getTitle());
        itemImageView.setImageResource(courseMaterial.getImageResourceId()); // Use the resource ID instead of URI
        statusTextView.setText(courseMaterial.getPaidOrFree());
        typeTextView.setText(courseMaterial.getVirtualOrPrinted());
        courseNameTextView.setText(courseMaterial.getCourseName());
        yearTextView.setText(courseMaterial.getYear());

        // Major is optional. If it's null or empty, hide the TextView or set to "Not Provided"
        if (courseMaterial.getMajor() != null && !courseMaterial.getMajor().isEmpty()) {
            majorTextView.setText(courseMaterial.getMajor());
        } else {
            majorTextView.setText(getString(R.string.major_not_provided)); // Assuming you have this string resource
        }

        // Set the click listener for the back button
        back_button.setOnClickListener(v -> finish());

        // the click listeners for the nav bar
        home_button.setOnClickListener(v -> openActivity(HomeWithSearchActivity.class));
        profile_button.setOnClickListener(v -> openActivity(Profile.class));
        sent_requests_button.setOnClickListener(v -> openActivity(SentRequests.class));
        received_requests_button.setOnClickListener(v -> openActivity(ReceivedRequests.class));

    }

    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}