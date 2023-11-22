package com.example.studyswap;

import android.os.Bundle;
import android.widget.Button;
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
        Button btnBack = findViewById(R.id.btnBack); // Back button

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
        btnBack.setOnClickListener(v -> onBackPressed());
    }
}
