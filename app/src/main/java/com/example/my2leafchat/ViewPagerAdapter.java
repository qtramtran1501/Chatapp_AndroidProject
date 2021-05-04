package com.example.my2leafchat;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.firebase.database.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    //variable for showing in ViewPager Layout
    private final List<Fragment> fragmentName = new ArrayList<>();
    private final List<String> fragmentTitle = new ArrayList<>();

    // Constructor
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentName.get(position);
    }

    @Override
    public int getCount() {
        return fragmentTitle.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }

    // Add Fragment Manager
    public void AddFragment(Fragment fragment, String title) {
        fragmentName.add(fragment);
        fragmentTitle.add(title);
    }

}
