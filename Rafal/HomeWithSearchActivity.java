package com.example.studyswap;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeWithSearchActivity extends AppCompatActivity {

    private EditText etSearch;
    private Spinner spinnerFilter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private SectionsPagerAdapter sectionsPagerAdapter;
    private Button btnBack; // Declare the back button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_with_search);

        etSearch = findViewById(R.id.etSearch);
        spinnerFilter = findViewById(R.id.spinnerFilter);
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabs);
        btnBack = findViewById(R.id.btnBack);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        setupSearchComponents();

        btnBack.setOnClickListener(v -> finish());
    }

    private void setupViewPager(ViewPager viewPager) {
        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        // Add fragments to the adapter here
        sectionsPagerAdapter.addFragment(HomePageFragment.newInstance(false), "All Materials");
        sectionsPagerAdapter.addFragment(HomePageFragment.newInstance(true), "My Major");
        viewPager.setAdapter(sectionsPagerAdapter);
    }

    private void setupSearchComponents() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.filter_options_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFilter.setAdapter(adapter);

        findViewById(R.id.btnSearch).setOnClickListener(view -> performSearch());
        spinnerFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Trigger search logic with the selected filter
                performSearch();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle the case when nothing is selected if necessary
            }
        });
    }

    private void performSearch() {
        String searchQuery = etSearch.getText().toString();
        String selectedFilter = spinnerFilter.getSelectedItem().toString();

        // Pass the search query and filter to the fragments
        HomePageFragment allMaterialsFragment = (HomePageFragment) sectionsPagerAdapter.getItem(0);
        HomePageFragment myMajorFragment = (HomePageFragment) sectionsPagerAdapter.getItem(1);

        allMaterialsFragment.filterContent(searchQuery, selectedFilter);
        myMajorFragment.filterContent(searchQuery, selectedFilter);
    }

    // Additional methods and logic for the activity...
}
