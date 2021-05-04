package com.example.my2leafchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.my2leafchat.Fragments.LoginFragment;
import com.example.my2leafchat.Fragments.SignupFragment;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {

    ViewPagerAdapter viewPagerAdapter;
    float v = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add Fragment
        viewPagerAdapter.AddFragment(new LoginFragment(), "Login");
        viewPagerAdapter.AddFragment(new SignupFragment(), "Signup");
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


        tabLayout.setTranslationY(300);

        tabLayout.setAlpha(v);

        tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();
    }
}