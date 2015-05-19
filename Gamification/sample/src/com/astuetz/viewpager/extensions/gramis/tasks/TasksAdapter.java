package com.astuetz.viewpager.extensions.gramis.tasks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.viewpager.extensions.sample.R;

import java.util.ArrayList;

/**
 * Created by GRamis on 18.05.2015.
 */
public class TasksAdapter extends BaseAdapter {
    private static ArrayList<TasksDetails> itemDetailsrrayList;

    private Integer[] imgid = {
            R.drawable.ball15,
            R.drawable.ball15
    };

    private LayoutInflater l_Inflater;

    public TasksAdapter(SuperAwesomeCardFragment context, ArrayList<TasksDetails> results) {
        itemDetailsrrayList = results;
        l_Inflater = LayoutInflater.from(context.getActivity());
    }



    public int getCount() {
        return itemDetailsrrayList.size();
    }

    public Object getItem(int position) {
        return itemDetailsrrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = l_Inflater.inflate(R.layout.item_details_view_completed, null);
            holder = new ViewHolder();
            holder.txt_itemName = (TextView) convertView.findViewById(R.id.textViewCompletedName);
            holder.txt_itemTime = (TextView) convertView.findViewById(R.id.textViewCompletedTime);
            holder.itemImage = (ImageView) convertView.findViewById(R.id.imageViewCompleted);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txt_itemName.setText(itemDetailsrrayList.get(position).getTask());
        holder.txt_itemTime.setText(itemDetailsrrayList.get(position).getSubject());
        holder.itemImage.setImageResource(imgid[itemDetailsrrayList.get(position).getImageNumber() - 1]);

        return convertView;
    }

    static class ViewHolder {
        TextView txt_itemName;
        TextView txt_itemTime;
        ImageView itemImage;
    }
}