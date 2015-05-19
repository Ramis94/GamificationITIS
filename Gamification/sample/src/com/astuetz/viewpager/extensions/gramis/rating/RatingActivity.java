package com.astuetz.viewpager.extensions.gramis.rating;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
 * Created by GRamis on 19.05.2015.
 */
public class RatingActivity extends ActionBarActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.listViewMainMenu)
    ListView listViewMainMenu;

    private SystemBarTintManager mTintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        // create our manager instance after the content view is set
        mTintManager = new SystemBarTintManager(this);
        // enable status bar tint
        mTintManager.setStatusBarTintEnabled(true);
        ArrayList<RatingDetails> image_details = GetSearchResults();

        final ListView lv1 = (ListView) findViewById(R.id.listViewRating);
        lv1.setAdapter(new RatingListAdapter(this, image_details));

        String[] mainMenu = {"Задания", "Семестр", "Активность", "Профиль"};

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                switch (position){
                    case 0:
                        Intent intent0 = new Intent(RatingActivity.this, MainActivity.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(RatingActivity.this, IconsActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(RatingActivity.this, ActiveActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(RatingActivity.this, ProfileActivity.class);
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

    private ArrayList<RatingDetails> GetSearchResults(){
        ArrayList<RatingDetails> results = new ArrayList<>();

        RatingDetails item_Completed_details = new RatingDetails();
        item_Completed_details.setName("Валерий Иванович");
        item_Completed_details.setBall("320");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details = new RatingDetails();
        item_Completed_details.setName("Мудрый космонавт");
        item_Completed_details.setBall("312");
        item_Completed_details.setImageNumber(2);
        results.add(item_Completed_details);

        item_Completed_details = new RatingDetails();
        item_Completed_details.setName("Инокентий Косяков");
        item_Completed_details.setBall("299");
        item_Completed_details.setImageNumber(3);
        results.add(item_Completed_details);

        item_Completed_details.setName("Валерий Иванович");
        item_Completed_details.setBall("280");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details = new RatingDetails();
        item_Completed_details.setName("Мудрый космонавт");
        item_Completed_details.setBall("270");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details = new RatingDetails();
        item_Completed_details.setName("Инокентий Косяков");
        item_Completed_details.setBall("269");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details.setName("Валерий Иванович");
        item_Completed_details.setBall("260");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details = new RatingDetails();
        item_Completed_details.setName("Мудрый космонавт");
        item_Completed_details.setBall("258");
        item_Completed_details.setImageNumber(2);
        results.add(item_Completed_details);

        item_Completed_details = new RatingDetails();
        item_Completed_details.setName("Инокентий Косяков");
        item_Completed_details.setBall("255");
        item_Completed_details.setImageNumber(3);
        results.add(item_Completed_details);

        item_Completed_details.setName("Валерий Иванович");
        item_Completed_details.setBall("245");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details = new RatingDetails();
        item_Completed_details.setName("Мудрый космонавт");
        item_Completed_details.setBall("244");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details = new RatingDetails();
        item_Completed_details.setName("Инокентий Косяков");
        item_Completed_details.setBall("243");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        return results;
    }
}
