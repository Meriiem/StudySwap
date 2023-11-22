package com.example.studyswap;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public SectionsPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    // Adds a fragment to the list
    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // Return the Fragment associated with a specified position.
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        // Show total number of pages.
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Return the title of the page at `position`
        return mFragmentTitleList.get(position);
    }
}
