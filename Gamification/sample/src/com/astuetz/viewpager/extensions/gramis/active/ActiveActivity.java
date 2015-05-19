package com.astuetz.viewpager.extensions.gramis.active;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.astuetz.viewpager.extensions.gramis.MainActivity;
import com.astuetz.viewpager.extensions.gramis.icons.IconsActivity;
import com.astuetz.viewpager.extensions.gramis.profile.ProfileActivity;
import com.astuetz.viewpager.extensions.sample.R;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by GRamis on 19.05.2015.
 */
public class ActiveActivity extends ActionBarActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.listViewMainMenu)
    ListView listViewMainMenu;

    private SystemBarTintManager mTintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        // create our manager instance after the content view is set
        mTintManager = new SystemBarTintManager(this);
        // enable status bar tint
        mTintManager.setStatusBarTintEnabled(true);
        ArrayList<ActiveDetails> image_details = GetSearchResults();
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        // create our manager instance after the content view is set
        mTintManager = new SystemBarTintManager(this);
        // enable status bar tint
        mTintManager.setStatusBarTintEnabled(true);

        final ListView lv1 = (ListView) findViewById(R.id.listViewActive);
        lv1.setAdapter(new ActiveAdapter(this, image_details));

        String[] mainMenu = {"Задания", "Семестр", "Активность", "Профиль"};

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                switch (position){
                    case 0:
                        Intent intent0 = new Intent(ActiveActivity.this, MainActivity.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(ActiveActivity.this, IconsActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(ActiveActivity.this, ActiveActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(ActiveActivity.this, ProfileActivity.class);
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

    private ArrayList<ActiveDetails> GetSearchResults(){
        ArrayList<ActiveDetails> results = new ArrayList<ActiveDetails>();

        ActiveDetails item_Completed_details = new ActiveDetails();
        item_Completed_details.setInfo("Дмитрий Вагонетов выполнил задание <Волшебная девятка>");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details = new ActiveDetails();
        item_Completed_details.setInfo("Максим Сладкий выполнил задание <К чаю пришел>");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details = new ActiveDetails();
        item_Completed_details.setInfo("Дмитрий Вагонетов выполнил задание <Волшебная девятка>");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details.setInfo("Максим Сладкий выполнил задание <К чаю пришел>");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details.setInfo("Дмитрий Вагонетов выполнил задание <Волшебная девятка>");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details = new ActiveDetails();
        item_Completed_details.setInfo("Максим Сладкий выполнил задание <К чаю пришел>");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details = new ActiveDetails();
        item_Completed_details.setInfo("Дмитрий Вагонетов выполнил задание <Волшебная девятка>");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details.setInfo("Максим Сладкий выполнил задание <К чаю пришел>");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details.setInfo("Дмитрий Вагонетов выполнил задание <Волшебная девятка>");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details = new ActiveDetails();
        item_Completed_details.setInfo("Максим Сладкий выполнил задание <К чаю пришел>");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details = new ActiveDetails();
        item_Completed_details.setInfo("Дмитрий Вагонетов выполнил задание <Волшебная девятка>");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details.setInfo("Максим Сладкий выполнил задание <К чаю пришел>");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details.setInfo("Дмитрий Вагонетов выполнил задание <Волшебная девятка>");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details = new ActiveDetails();
        item_Completed_details.setInfo("Максим Сладкий выполнил задание <К чаю пришел>");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details = new ActiveDetails();
        item_Completed_details.setInfo("Дмитрий Вагонетов выполнил задание <Волшебная девятка>");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details.setInfo("Максим Сладкий выполнил задание <К чаю пришел>");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        return results;
    }
}
