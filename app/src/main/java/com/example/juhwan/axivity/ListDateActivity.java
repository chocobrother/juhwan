package com.example.juhwan.axivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.juhwan.axivity.adapter.DATEAdapter;
import com.example.juhwan.axivity.adapter.JSONAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListDateActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listView2;


    List<Date> list;

    DATEAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_date);

        list = new ArrayList<Date>();

        adapter = new DATEAdapter(this,R.layout.list_date,list);

        listView2 = (ListView)findViewById(R.id.listView2);

        listView2.setAdapter(adapter);

        listView2.setOnItemClickListener(this);
        addData();

    }
    public void addData(){
        adapter.add(new Date("17년 6월"));
        adapter.add(new Date("17년 7월"));
        adapter.add(new Date("17년 8월"));
        adapter.add(new Date("17년 9월"));
        adapter.add(new Date("17년 10월"));
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.listView2:
                if(position == 0){

                    String month = "six";

//                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    Intent intent = new Intent(getApplicationContext(),ListDayActivity.class);

                    intent.putExtra("position",month);

                    startActivity(intent);

                    break;

                }
                else if(position == 1){

                    String month = "seven";

//                    Intent intent = new Intent(this,Connection.class);

                    Intent intent = new Intent(getApplicationContext(),ListDayActivity.class);

                    intent.putExtra("position",month);

                    startActivity(intent);

                    break;
                }
                else if(position == 2){

                    String month = "eight";

//                    Intent intent = new Intent(this,Connection.class);

                    Intent intent = new Intent(getApplicationContext(),ListDayActivity.class);


                    intent.putExtra("position",month);

                    startActivity(intent);

                    break;
                }
                else if(position == 3){
                    String month = "nine";

//                    Intent intent = new Intent(this,Connection.class);

                    Intent intent = new Intent(getApplicationContext(),ListDayActivity.class);

                    intent.putExtra("position",month);

                    startActivity(intent);

                    break;
                }

        }

    }
}
