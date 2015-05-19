package com.astuetz.viewpager.extensions.gramis.about_icon;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.astuetz.viewpager.extensions.gramis.MainActivity;
import com.astuetz.viewpager.extensions.gramis.active.ActiveActivity;
import com.astuetz.viewpager.extensions.gramis.icons.IconsActivity;
import com.astuetz.viewpager.extensions.gramis.profile.ProfileActivity;
import com.astuetz.viewpager.extensions.sample.R;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by GRamis on 17.05.2015.
 */
public class AboutIconActivity extends ActionBarActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.listViewMainMenu)
    ListView listViewMainMenu;

    private SystemBarTintManager mTintManager;

    TextView textViewSubject;
    TextView tv_remains_the_task;
    String subject = "Английский язык";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_icon);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        // create our manager instance after the content view is set
        mTintManager = new SystemBarTintManager(this);
        // enable status bar tint
        mTintManager.setStatusBarTintEnabled(true);
        ArrayList<AboutIconDetails> image_details = GetSearchResults();

        textViewSubject = (TextView) findViewById(R.id.tv_subject_name1);
        textViewSubject.setText(subject);
        textViewSubject.setTextColor(Color.WHITE);

        tv_remains_the_task = (TextView) findViewById(R.id.tv_remains_the_task);
        tv_remains_the_task.setText("Осталось 1 задание");
        tv_remains_the_task.setTextColor(Color.WHITE);

        final ListView lv1 = (ListView) findViewById(R.id.listView_Icon);
        lv1.setAdapter(new AboutIconAdapter(this, image_details));

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                AboutIconDetails obj_Completed_Details = (AboutIconDetails)o;
                Toast.makeText(AboutIconActivity.this, "You have chosen : " + " " + obj_Completed_Details.getTask(), Toast.LENGTH_LONG).show();
            }
        });
        String[] mainMenu = {"Задания", "Семестр", "Активность", "Профиль"};

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                switch (position){
                    case 0:
                        Intent intent0 = new Intent(AboutIconActivity.this, MainActivity.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(AboutIconActivity.this, IconsActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(AboutIconActivity.this, ActiveActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(AboutIconActivity.this, ProfileActivity.class);
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

    private ArrayList<AboutIconDetails> GetSearchResults(){
        ArrayList<AboutIconDetails> results = new ArrayList<AboutIconDetails>();

        AboutIconDetails item_Completed_details = new AboutIconDetails();
        item_Completed_details.setTask("Контрольная №1");
        item_Completed_details.setSubject(subject);
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details = new AboutIconDetails();
        item_Completed_details.setTask("Радий паладий");
        item_Completed_details.setSubject(subject);
        item_Completed_details.setImageNumber(2);
        results.add(item_Completed_details);

        item_Completed_details = new AboutIconDetails();
        item_Completed_details.setTask("Золотой миллиард");
        item_Completed_details.setSubject(subject);
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details.setTask("Трудности перевода");
        item_Completed_details.setSubject(subject);
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        return results;
    }
}