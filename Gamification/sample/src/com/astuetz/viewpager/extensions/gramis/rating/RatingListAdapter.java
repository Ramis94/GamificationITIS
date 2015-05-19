package com.astuetz.viewpager.extensions.gramis.rating;

import android.content.Context;
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
public class RatingListAdapter extends BaseAdapter {
    private static ArrayList<RatingDetails> itemDetailsrrayList;

    private Integer[] imgid = {
            R.drawable.unknown_people,
            R.drawable.people1,
            R.drawable.people2
    };

    private LayoutInflater l_Inflater;

    public RatingListAdapter(Context context, ArrayList<RatingDetails> results) {
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
            convertView = l_Inflater.inflate(R.layout.item_details_view_rating, null);
            holder = new ViewHolder();
            holder.txt_itemName = (TextView) convertView.findViewById(R.id.textViewRatingName);
            holder.txt_itemBall = (TextView) convertView.findViewById(R.id.textViewRatingBall);
            holder.itemImage = (ImageView) convertView.findViewById(R.id.imageViewPeople);
            holder.idRating = (TextView) convertView.findViewById(R.id.textViewIdRating);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.idRating.setText(String.valueOf(position+1));
        holder.txt_itemName.setText(itemDetailsrrayList.get(position).getName());
        holder.txt_itemBall.setText(itemDetailsrrayList.get(position).getBall());
        holder.itemImage.setImageResource(imgid[itemDetailsrrayList.get(position).getImageNumber() - 1]);

        return convertView;
    }

    static class ViewHolder {
        TextView txt_itemName;
        TextView txt_itemBall;
        ImageView itemImage;
        TextView idRating;
    }
}
