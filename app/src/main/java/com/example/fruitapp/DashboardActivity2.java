package com.example.fruitapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class DashboardActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager = getSupportFragmentManager();

    private Fragment dashboardFragment = new DashboardFragment();

    private Fragment settingFragment = new SettingFragment();
    private Fragment activateFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard2);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, settingFragment)
                .hide(settingFragment)
                .commit();

        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, dashboardFragment)
                .commit();

        activateFragment = dashboardFragment;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.navigation_menu_home){
            fragmentManager.beginTransaction()
                    .hide(activateFragment)
                    .show(dashboardFragment)
                    .commit();
            activateFragment = dashboardFragment;
            return true;
        } else if (item.getItemId() == R.id.navigation_menu_profile) {
            fragmentManager.beginTransaction()
                    .hide(activateFragment)
                    .show(settingFragment)
                    .commit();
            activateFragment = settingFragment;
            return true;
        }

        return false;
    }
}
