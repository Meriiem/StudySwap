package com.example.studyswap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class Profile extends AppCompatActivity {

    TextView firstName, lastName, email, phone, collage, major, year;
    Button addNewItemBtn;
    private User logedUser;
    private TabLayout itemTabs;
    private ViewPager itemTabsPager;

    private ImageView backButton;
    private ImageView homeButton;
    private ImageView profileButton;
    private ImageView sentRequestsButton;
    private ImageView receivedRequestsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        backButton = findViewById(R.id.back_button);
        homeButton = findViewById(R.id.home_button);
        profileButton = findViewById(R.id.profile_button);
        sentRequestsButton = findViewById(R.id.sent_requests_button);
        receivedRequestsButton = findViewById(R.id.received_requests_button);

        firstName = findViewById(R.id.txtFirstName);
        email = findViewById(R.id.txtUniEmail);
        phone = findViewById(R.id.txtPhone);
        major = findViewById(R.id.txtMajor);


        //SET user profile
        logedUser = new User("User2013", "user2023@gmail.com", "0012345678", "Computer Science");
        firstName.setText(logedUser.getUserName());
        email.setText(logedUser.getEmail());
        phone.setText(logedUser.getPhone());
        major.setText(logedUser.getMajor());

        addNewItemBtn = findViewById(R.id.btnAddItem);

        itemTabs = findViewById(R.id.MyItemsTabLayout);
        itemTabsPager = findViewById(R.id.MyItemsViewPager);


        TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.addFragment(new MyBooksFragment(), getString(R.string.my_books_tab));
        adapter.addFragment(new MyNotesFragment(), getString(R.string.my_notes_tab));

        itemTabsPager.setAdapter(adapter);
        itemTabs.setupWithViewPager(itemTabsPager);

        for(int i=0; i<adapter.getCount(); i++){

            TextView tab = (TextView) LayoutInflater.from(this).inflate(R.layout.tab_name, null);
            tab.setText(adapter.getPageTitle(i));
            itemTabs.getTabAt(i).setCustomView(tab);

            View tabView = itemTabs.getTabAt(i).view;
            tabView.setPadding(0, 0, 0, 0);
        }//end of loop



        addNewItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newItemIntent = new Intent(Profile.this, AddItemActivity.class);
                startActivity(newItemIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }//end of onClick()

        });//end of setOnClickListener()


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, HomeWithSearchActivity.class);
                startActivity(intent);
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        sentRequestsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, SentRequests.class);
                startActivity(intent);
            }
        });

        receivedRequestsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, ReceivedRequests.class);
                startActivity(intent);
            }
        });

    }//end of onCreate()

}//end of Profile
