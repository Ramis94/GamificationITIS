package com.astuetz.viewpager.extensions.gramis.icons;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.astuetz.viewpager.extensions.gramis.Task1Activity;
import com.astuetz.viewpager.extensions.gramis.profile.ProfileActivity;
import com.astuetz.viewpager.extensions.sample.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static com.astuetz.viewpager.extensions.sample.R.color.material_blue_grey_800;

/**
 * Created by GRamis on 19.05.2015.
 */
public class IconsFragment extends Fragment {
    private static final String ARG_POSITION = "position";

    @InjectView(R.id.listViewMain)
    ListView listView;

    private int position;

    public static IconsFragment newInstance(int position) {
        IconsFragment f = new IconsFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_card,container,false);
        ButterKnife.inject(this, rootView);
        ViewCompat.setElevation(rootView, 50);
        ArrayList<IconsDetails> image_details = GetSearchResults();
        listView.setBackgroundColor(material_blue_grey_800);
        switch (position){
            case 0:
                listView.setAdapter(new IconsAdapter(this, image_details));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:
                                Intent intent = new Intent(getActivity(), Task1Activity.class);
                                startActivity(intent);
                                break;
                            case 3:
                                Intent intent1 = new Intent(getActivity(), ProfileActivity.class);
                                startActivity(intent1);
                                break;
                        }
                    }
                });
                break;
            case 1:
                listView.setAdapter(new IconsAdapter(this, image_details));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:
                                Intent intent = new Intent(getActivity(), Task1Activity.class);
                                startActivity(intent);
                                break;
                            case 3:
                                Intent intent1 = new Intent(getActivity(), Task1Activity.class);
                                startActivity(intent1);
                                break;
                        }
                    }
                });
                break;
        }

        return rootView;
    }

    private ArrayList<IconsDetails> GetSearchResults(){
        ArrayList<IconsDetails> results = new ArrayList<IconsDetails>();

        IconsDetails item_Completed_details = new IconsDetails();
        item_Completed_details.setTask("Доступен экзамен");
        item_Completed_details.setSubject("Теория систем и системный анализ");
        item_Completed_details.setImageNumber(1);
        results.add(item_Completed_details);

        item_Completed_details = new IconsDetails();
        item_Completed_details.setTask("Доступно 1 задание");
        item_Completed_details.setSubject("Программирование");
        item_Completed_details.setImageNumber(2);
        results.add(item_Completed_details);

        item_Completed_details = new IconsDetails();
        item_Completed_details.setTask("Доступен экзамен");
        item_Completed_details.setSubject("Программирование");
        item_Completed_details.setImageNumber(3);
        results.add(item_Completed_details);

        item_Completed_details.setTask("Доступно 1 задание");
        item_Completed_details.setSubject("Алгебра");
        item_Completed_details.setImageNumber(4);
        results.add(item_Completed_details);

        return results;
    }
}
