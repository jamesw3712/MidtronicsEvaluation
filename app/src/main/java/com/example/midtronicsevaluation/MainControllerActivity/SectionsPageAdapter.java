package com.example.midtronicsevaluation.MainControllerActivity;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class SectionsPageAdapter extends FragmentPagerAdapter {

    private final ArrayList<String> fragmentTitles = new ArrayList<>();
    private final ArrayList<Fragment> fragments = new ArrayList<>();

    public SectionsPageAdapter(FragmentManager fm){
        super(fm);
    }

    public void addFragment(Fragment fragment, String title){
        fragments.add(fragment);
        fragmentTitles.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitles.get(position);
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
