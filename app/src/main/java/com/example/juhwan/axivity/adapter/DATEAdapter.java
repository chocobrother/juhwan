package com.example.juhwan.axivity.adapter;

/**
 * Created by Juhwan on 2017-07-18.
 */

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.juhwan.axivity.Data;
import com.example.juhwan.axivity.Date;
import com.example.juhwan.axivity.R;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.juhwan.axivity.Data;
import com.example.juhwan.axivity.R;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by Juhwan on 2017-07-17.
 */

public class DATEAdapter extends ArrayAdapter<Date> {
    Activity activity;
    int resource;

    public DATEAdapter( Context context, int resource,  List<Date> objects) {
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

        Date item = getItem(position);

        if(item!=null){
            TextView textView = (TextView)itemView.findViewById(R.id.txt_date);

            textView.setText(item.getBlue_date());

        }

        return itemView;
    }
}
