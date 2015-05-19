package com.astuetz.viewpager.extensions.gramis.active;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.viewpager.extensions.sample.R;

import java.util.ArrayList;

/**
 * Created by GRamis on 19.05.2015.
 */
public class ActiveAdapter extends BaseAdapter {
    private static ArrayList<ActiveDetails> itemDetailsrrayList;

    private Integer[] imgid = {
            R.drawable.unknown_people
    };

    private LayoutInflater l_Inflater;

    public ActiveAdapter(Context context, ArrayList<ActiveDetails> results) {
        itemDetailsrrayList = results;
        l_Inflater = LayoutInflater.from(context);
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
            convertView = l_Inflater.inflate(R.layout.item_details_view_active, null);
            holder = new ViewHolder();
            holder.txt_itemInfo = (TextView) convertView.findViewById(R.id.textViewActive);
            holder.itemImage = (ImageView) convertView.findViewById(R.id.imageViewActive);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txt_itemInfo.setText(itemDetailsrrayList.get(position).getInfo());
        holder.txt_itemInfo.setTextColor(Color.WHITE);
        holder.itemImage.setImageResource(imgid[itemDetailsrrayList.get(position).getImageNumber() - 1]);

        return convertView;
    }

    static class ViewHolder {
        TextView txt_itemInfo;
        ImageView itemImage;
    }
}
