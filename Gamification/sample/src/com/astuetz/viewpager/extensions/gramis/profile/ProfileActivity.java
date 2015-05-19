package com.astuetz.viewpager.extensions.gramis.profile;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.astuetz.viewpager.extensions.gramis.icons.IconsActivity;
import com.astuetz.viewpager.extensions.gramis.MainActivity;
import com.astuetz.viewpager.extensions.sample.R;
import com.astuetz.viewpager.extensions.gramis.active.ActiveActivity;
import com.astuetz.viewpager.extensions.gramis.rating.RatingActivity;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by GRamis on 18.05.2015.
 */
public class ProfileActivity extends ActionBarActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.listViewMainMenu)
    ListView listViewMainMenu;

    private SystemBarTintManager mTintManager;

    ImageView imageViewProfile;
    TextView textViewProfileName;
    Button buttonRating;

    ImageView imageViewIcon2;
    ImageView imageViewIcon3;
    ImageView imageViewIcon4;
    ImageView imageViewIcon5;
    ImageView imageViewIcon6;
    ImageView imageViewIcon7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        // create our manager instance after the content view is set
        mTintManager = new SystemBarTintManager(this);
        // enable status bar tint
        mTintManager.setStatusBarTintEnabled(true);

        imageViewProfile = (ImageView) findViewById(R.id.imageViewProfile);
        imageViewProfile.setImageResource(R.drawable.people1);

        textViewProfileName = (TextView) findViewById(R.id.textViewProfileName);
        textViewProfileName.setText("Иван Иванов");
        textViewProfileName.setTextColor(Color.WHITE);

        buttonRating = (Button) findViewById(R.id.buttonRating);
        buttonRating.setText("3 место | 756 баллов");
        buttonRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, RatingActivity.class);
                startActivity(intent);
            }
        });

        imageViewIcon2 = (ImageView) findViewById(R.id.imageViewIcon2);
        imageViewIcon2.setImageResource(R.drawable.icon1);

        imageViewIcon3 = (ImageView) findViewById(R.id.imageViewIcon3);
        imageViewIcon3.setImageResource(R.drawable.icon2);

        imageViewIcon4 = (ImageView) findViewById(R.id.imageViewIcon4);
        imageViewIcon4.setImageResource(R.drawable.icon3);

        imageViewIcon5 = (ImageView) findViewById(R.id.imageViewIcon5);
        imageViewIcon5.setImageResource(R.drawable.icon4);

        imageViewIcon6 = (ImageView) findViewById(R.id.imageViewIcon6);
        imageViewIcon6.setImageResource(R.drawable.icon5);

        imageViewIcon7 = (ImageView) findViewById(R.id.imageViewIcon7);
        imageViewIcon7.setImageResource(R.drawable.icon1);

        String[] mainMenu = {"Задания", "Семестр", "Активность", "Профиль"};

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                switch (position){
                    case 0:
                        Intent intent0 = new Intent(ProfileActivity.this, MainActivity.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(ProfileActivity.this, IconsActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(ProfileActivity.this, ActiveActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(ProfileActivity.this, ProfileActivity.class);
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
