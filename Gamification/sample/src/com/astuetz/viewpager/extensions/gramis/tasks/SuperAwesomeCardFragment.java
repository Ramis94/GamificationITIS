/*
 * Copyright (C) 2013 Andreas Stuetz <andreas.stuetz@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.astuetz.viewpager.extensions.gramis.tasks;

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
import com.astuetz.viewpager.extensions.sample.R;
import com.astuetz.viewpager.extensions.gramis.profile.ProfileActivity;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static com.astuetz.viewpager.extensions.sample.R.color.material_blue_grey_800;

public class SuperAwesomeCardFragment extends Fragment {

	private static final String ARG_POSITION = "position";

    @InjectView(R.id.listViewMain)
	ListView listView;

	private int position;

	public static SuperAwesomeCardFragment newInstance(int position) {
		SuperAwesomeCardFragment f = new SuperAwesomeCardFragment();
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
		ArrayList<TasksDetails> image_details = GetSearchResults();
		listView.setBackgroundColor(material_blue_grey_800);
		switch (position){
			case 0:
				listView.setAdapter(new TasksAdapter(this, image_details));
				listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
						switch (position) {
							case 0:
								Intent intent = new Intent(getActivity(), Task1Activity.class);
								startActivity(intent);
								break;
							case 1:
								Intent intent1 = new Intent(getActivity(), Task1Activity.class);
								startActivity(intent1);
								break;
							case 2:
								Intent intent2 = new Intent(getActivity(), Task1Activity.class);
								startActivity(intent2);
								break;
							case 3:
								Intent intent3 = new Intent(getActivity(), ProfileActivity.class);
								startActivity(intent3);
								break;
						}
					}
				});
				break;
			case 1:
				listView.setAdapter(new TasksAdapter(this, image_details));
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

	private ArrayList<TasksDetails> GetSearchResults(){
		ArrayList<TasksDetails> results = new ArrayList<TasksDetails>();

		TasksDetails item_Completed_details = new TasksDetails();
		item_Completed_details.setTask("Трудности перевода");
		item_Completed_details.setSubject("Английский язык");
		item_Completed_details.setImageNumber(1);
		results.add(item_Completed_details);

		item_Completed_details = new TasksDetails();
		item_Completed_details.setTask("Калька с другом");
		item_Completed_details.setSubject("Программирование");
		item_Completed_details.setImageNumber(2);
		results.add(item_Completed_details);

		item_Completed_details = new TasksDetails();
		item_Completed_details.setTask("Разработчик сайтов");
		item_Completed_details.setSubject("Программирование");
		item_Completed_details.setImageNumber(1);
		results.add(item_Completed_details);

		item_Completed_details.setTask("Общий интерес");
		item_Completed_details.setSubject("Актив");
		item_Completed_details.setImageNumber(1);
		results.add(item_Completed_details);

		return results;
	}
}