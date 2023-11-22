package com.uos.studyswapapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStateManagerControl;

import java.util.ArrayList;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    private final ArrayList<String> tabNames = new ArrayList<String>();


    public TabsPagerAdapter(@NonNull FragmentManager manager, int behavior){

        super(manager, behavior);
    }//end of TabsPagerAdapter()


    @NonNull
    @Override
    public Fragment getItem(int position){

        return fragmentList.get(position);
    }//end of getItem()


    @Override
    public int getCount(){

        return fragmentList.size();
    }//end of getCount()


    public void addFragment(Fragment fragment, String name){

        fragmentList.add(fragment);
        tabNames.add(name);
    }//end of addFragment()


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return tabNames.get(position);
    }
}//end of TabsPagerAdapter
