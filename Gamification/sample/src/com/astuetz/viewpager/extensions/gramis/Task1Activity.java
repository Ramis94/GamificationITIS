package com.astuetz.viewpager.extensions.gramis;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.astuetz.viewpager.extensions.gramis.icons.IconsActivity;
import com.astuetz.viewpager.extensions.sample.R;
import com.astuetz.viewpager.extensions.gramis.about_icon.AboutIconActivity;
import com.astuetz.viewpager.extensions.gramis.active.ActiveActivity;
import com.astuetz.viewpager.extensions.gramis.completed.CompletedActivity;
import com.astuetz.viewpager.extensions.gramis.profile.ProfileActivity;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by GRamis on 16.05.2015.
 */
public class Task1Activity extends ActionBarActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.listViewMainMenu)
    ListView listViewMainMenu;

    private SystemBarTintManager mTintManager;

    TextView taskNameView;
    TextView subjectNameView;
    TextView taskView;
    TextView subjectNameView1;
    TextView remains_the_task;
    Button button_All;
    ImageButton imageButtonSubject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        // create our manager instance after the content view is set
        mTintManager = new SystemBarTintManager(this);
        // enable status bar tint
        mTintManager.setStatusBarTintEnabled(true);

        taskNameView = (TextView) findViewById(R.id.tv_task_name);
        taskNameView.setText("Трудности перевода");
        taskNameView.setTextColor(Color.WHITE);

        subjectNameView = (TextView) findViewById(R.id.tv_subject_name);
        subjectNameView.setText("Английский язык");
        subjectNameView.setTextColor(Color.WHITE);
        subjectNameView1 = (TextView) findViewById(R.id.tv_subject_name1);
        subjectNameView1.setText("Английский язык");
        subjectNameView1.setTextColor(Color.WHITE);

        taskView = (TextView) findViewById(R.id.task);
        taskView.setText("Сдать перевод выбранной статьи и представить свою тему перед аудиторией. Не забудьте заполнить глоссарий!");
        taskView.setTextColor(Color.WHITE);

        remains_the_task = (TextView) findViewById(R.id.tv_remains_the_task);
        remains_the_task.setText("Осталось 1 задание");
        remains_the_task.setTextColor(Color.WHITE);

        button_All = (Button) findViewById(R.id.buttonAllComplete);
        button_All.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Task1Activity.this, CompletedActivity.class);
                startActivity(intent);
            }
        });

        imageButtonSubject = (ImageButton) findViewById(R.id.ibtn_subject);
        imageButtonSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Task1Activity.this, AboutIconActivity.class);
                startActivity(intent);
            }
        });

        String[] mainMenu = {"Задания", "Семестр", "Активность", "Профиль"};

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                switch (position){
                    case 0:
                        Intent intent0 = new Intent(Task1Activity.this, MainActivity.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(Task1Activity.this, IconsActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(Task1Activity.this, ActiveActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(Task1Activity.this, ProfileActivity.class);
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
}
