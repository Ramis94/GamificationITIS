package com.astuetz.viewpager.extensions.gramis.completed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.astuetz.viewpager.extensions.gramis.icons.IconsActivity;
import com.astuetz.viewpager.extensions.gramis.profile.ProfileActivity;
import com.astuetz.viewpager.extensions.gramis.MainActivity;
import com.astuetz.viewpager.extensions.sample.R;
import com.astuetz.viewpager.extensions.gramis.active.ActiveActivity;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by GRamis on 17.05.2015.
 */
public class CompletedActivity extends ActionBarActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.listViewMainMenu)
    ListView listViewMainMenu;
    private SystemBarTintManager mTintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        // create our manager instance after the content view is set
        mTintManager = new SystemBarTintManager(this);
        // enable status bar tint
        mTintManager.setStatusBarTintEnabled(true);
        ArrayList<CompletedDetails> image_details = GetSearchResults();

        final ListView lv1 = (ListView) findViewById(R.id.listView_Completed);
        lv1.setAdapter(new CompletedListAdapter(this, image_details));

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                CompletedDetails obj_Completed_Details = (CompletedDetails) o;
                Toast.makeText(CompletedActivity.this, "You have chosen : " + " " + obj_Completed_Details.getName(), Toast.LENGTH_LONG).show();
            }
        });

        String[] mainMenu = {"Задания", "Семестр", "Активность", "Профиль"};

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                switch (position){
                    case 0:
                        Intent intent0 = new Intent(CompletedActivity.this, MainActivity.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(CompletedActivity.this, IconsActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(CompletedActivity.this, ActiveActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(CompletedActivity.this, ProfileActivity.class);
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

    private ArrayList<CompletedDetails> GetSearchResults(){
        ArrayList<CompletedDetails> results = new ArrayList<CompletedDetails>();

        CompletedDetails item_Completed_details = new CompletedDetails();
        item_Completed_details.setName("Валерий Иванович");
        item_Completed_details.setTime("4 часа назад");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details = new CompletedDetails();
        item_Completed_details.setName("Мудрый космонавт");
        item_Completed_details.setTime("17 часов назад");
        item_Completed_details.setImageNumber(2);
        results.add(item_Completed_details);

        item_Completed_details = new CompletedDetails();
        item_Completed_details.setName("Инокентий Косяков");
        item_Completed_details.setTime("Вчера");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details.setName("Валерий Иванович");
        item_Completed_details.setTime("Вчера");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details = new CompletedDetails();
        item_Completed_details.setName("Мудрый космонавт");
        item_Completed_details.setTime("2 дня назад");
        item_Completed_details.setImageNumber(2);
        results.add(item_Completed_details);

        item_Completed_details = new CompletedDetails();
        item_Completed_details.setName("Инокентий Косяков");
        item_Completed_details.setTime("2 дня назад");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        return results;
    }
}