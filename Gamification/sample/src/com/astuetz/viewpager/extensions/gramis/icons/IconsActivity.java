package com.astuetz.viewpager.extensions.gramis.icons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.astuetz.PagerSlidingTabStrip;
import com.astuetz.viewpager.extensions.gramis.MainActivity;
import com.astuetz.viewpager.extensions.sample.R;
import com.astuetz.viewpager.extensions.gramis.active.ActiveActivity;
import com.astuetz.viewpager.extensions.gramis.profile.ProfileActivity;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by GRamis on 19.05.2015.
 */
public class IconsActivity extends ActionBarActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.tabsIcons)
    PagerSlidingTabStrip tabs;
    @InjectView(R.id.pagerIcons)
    ViewPager pager;
    @InjectView(R.id.listViewMainMenu)
    ListView listViewMainMenu;

    private MyPagerAdapter adapter;
    private SystemBarTintManager mTintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icons);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        mTintManager = new SystemBarTintManager(this);
        mTintManager.setStatusBarTintEnabled(true);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        pager.setPageMargin(pageMargin);
        pager.setCurrentItem(0);

        String[] mainMenu = {"Задания", "Семестр", "Активность", "Профиль"};

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                switch (position){
                    case 0:
                        Intent intent0 = new Intent(IconsActivity.this, MainActivity.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(IconsActivity.this, IconsActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(IconsActivity.this, ActiveActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(IconsActivity.this, ProfileActivity.class);
                        startActivity(intent3);
                        break;
                }
            }
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mainMenu);
        listViewMainMenu.setAdapter(adapter);
        listViewMainMenu.setOnItemClickListener(onItemClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = {"Предметные", "Особенные"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {
            return IconsFragment.newInstance(position);
        }
    }
}
