package com.example.juhwan.axivity.adapter;

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

public class JSONAdapter extends ArrayAdapter<Data> {
        Activity activity;
        int resource;

    public JSONAdapter(Context context, int resource,  List<Data> objects) {
        super(context, resource, objects);

        activity = (Activity)context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        View itemView = convertView;

        if(itemView == null){
            itemView = this.activity.getLayoutInflater().inflate(this.resource,null);
        }

        Data item = getItem(position);

        if(item!=null){
            TextView textView1 = (TextView)itemView.findViewById(R.id.textView1);
            TextView textView2 = (TextView)itemView.findViewById(R.id.textView2);


            textView1.setText(item.getBlue_time());
            textView2.setText(item.getState());

        }

        return itemView;
    }
}
