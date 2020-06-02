package com.example.sliderexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    //This is our viewPager
    private ViewPager viewPager;


    //Fragments
    HomeFragment homeFragment;
    NotesFragment notesFragment;
    CalendarFragment calendarFragment;
    RulesFragment rulesFragment;


    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BottomNavigationView bottomNavigationView;
        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(0);

        //Initializing the bottomNavigationView
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.action_home); // change to whichever id should be default
        }


        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_notes:
                                viewPager.setCurrentItem(0);
                                return true;
                            case R.id.action_home:
                                viewPager.setCurrentItem(1);
                                return true;
                            case R.id.action_calendar:
                                viewPager.setCurrentItem(2);
                                return true;
                            case R.id.action_rules:
                                viewPager.setCurrentItem(3);
                                return true;

                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(1).setChecked(false);
                }
                Log.d("page", "onPageSelected: " + position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

       /*  //Disable ViewPager Swipe

       viewPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });

        */

        setupViewPager(viewPager);



    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        homeFragment = new HomeFragment();
        notesFragment = new NotesFragment();
        calendarFragment = new CalendarFragment();
        rulesFragment = new RulesFragment();

        adapter.addFragment(notesFragment);
        adapter.addFragment(homeFragment);
        adapter.addFragment(calendarFragment);
        adapter.addFragment(rulesFragment);

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);
    }


}

