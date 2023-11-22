package com.uos.studyswapapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MyCounterActivity extends AppCompatActivity {

    //Objects' declaration
    TextView firstName, lastName, email, phone, collage, major, year;
    Button addNewItemBtn;
    private TabLayout itemTabs;
    private ViewPager itemTabsPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_counter);

        firstName = findViewById(R.id.txtFirstName);
        lastName = findViewById(R.id.txtLastName);
        email = findViewById(R.id.txtUniEmail);
        phone = findViewById(R.id.txtPhone);
        collage = findViewById(R.id.txtCollage);
        major = findViewById(R.id.txtMajor);
        year = findViewById(R.id.txtYear);

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
            Log.d("TAB LAYOUT ADDED", "TAB");

            View tabView = itemTabs.getTabAt(i).view;
            tabView.setPadding(0, 0, 0, 0);
        }


        addNewItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newItemIntent = new Intent(MyCounterActivity.this, AddItemActivity.class);
                startActivity(newItemIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }//end of onClick()

        });//end of setOnClickListener()

    }//end of onCreate()
}