package com.example.juhwan.axivity.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.juhwan.axivity.Date;
import com.example.juhwan.axivity.Day;
import com.example.juhwan.axivity.R;

import java.util.List;

/**
 * Created by Juhwan on 2017-07-24.
 */

public class DAYAdapter extends ArrayAdapter<Day> {
    Activity activity;
    int resource;

    public DAYAdapter(Context context, int resource, List<Day> objects) {
        super(context, resource, objects);

        activity = (Activity)context;
        this.resource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;

        if(itemView == null){
            itemView = this.activity.getLayoutInflater().inflate(this.resource,null);
        }

        Day item = getItem(position);

        if(item!=null){
            TextView textView = (TextView)itemView.findViewById(R.id.txt_day);

            textView.setText(item.getBlue_day());

        }

        return itemView;
    }
}
