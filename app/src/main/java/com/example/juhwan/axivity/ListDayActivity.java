package com.example.juhwan.axivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.juhwan.axivity.R;
import com.example.juhwan.axivity.adapter.DATEAdapter;
import com.example.juhwan.axivity.adapter.DAYAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListDayActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{

    private ListView listView3;

    List<Day> list;

    DAYAdapter adapter;

    String position11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_day);
        list = new ArrayList<Day>();

        adapter = new DAYAdapter(this,R.layout.list_day,list);

        listView3 = (ListView)findViewById(R.id.listView3);

        listView3.setAdapter(adapter);

        listView3.setOnItemClickListener(this);

        Intent fromIntent = getIntent();

        position11 = fromIntent.getStringExtra("position");

        addData();
    }

    private void addData() {



        if(position11.equals("six")){
            adapter.add(new Day("17년 6월 1일"));
            adapter.add(new Day("17년 6월 2일"));
            adapter.add(new Day("17년 6월 3일"));
            adapter.add(new Day("17년 6월 4일"));
            adapter.add(new Day("17년 6월 5일"));
            adapter.add(new Day("17년 6월 6일"));
            adapter.add(new Day("17년 6월 7일"));
            adapter.add(new Day("17년 6월 8일"));
            adapter.add(new Day("17년 6월 9일"));
            adapter.add(new Day("17년 6월 10일"));
            adapter.add(new Day("17년 6월 11일"));
            adapter.add(new Day("17년 6월 12일"));
            adapter.add(new Day("17년 6월 13일"));
            adapter.add(new Day("17년 6월 14일"));
            adapter.add(new Day("17년 6월 15일"));
            adapter.add(new Day("17년 6월 16일"));
            adapter.add(new Day("17년 6월 17일"));
            adapter.add(new Day("17년 6월 18일"));
            adapter.add(new Day("17년 6월 19일"));
            adapter.add(new Day("17년 6월 20일"));
            adapter.add(new Day("17년 6월 21일"));
            adapter.add(new Day("17년 6월 22일"));
            adapter.add(new Day("17년 6월 23일"));
            adapter.add(new Day("17년 6월 24일"));
            adapter.add(new Day("17년 6월 25일"));
            adapter.add(new Day("17년 6월 26일"));
            adapter.add(new Day("17년 6월 27일"));
            adapter.add(new Day("17년 6월 28일"));
            adapter.add(new Day("17년 6월 29일"));
            adapter.add(new Day("17년 6월 30일"));
        }
        else if(position11.equals("seven")){
            adapter.add(new Day("17년 7월 1일"));
            adapter.add(new Day("17년 7월 2일"));
            adapter.add(new Day("17년 7월 3일"));
            adapter.add(new Day("17년 7월 4일"));
            adapter.add(new Day("17년 7월 5일"));
            adapter.add(new Day("17년 7월 6일"));
            adapter.add(new Day("17년 7월 7일"));
            adapter.add(new Day("17년 7월 8일"));
            adapter.add(new Day("17년 7월 9일"));
            adapter.add(new Day("17년 7월 10일"));
            adapter.add(new Day("17년 7월 11일"));
            adapter.add(new Day("17년 7월 12일"));
            adapter.add(new Day("17년 7월 13일"));
            adapter.add(new Day("17년 7월 14일"));
            adapter.add(new Day("17년 7월 15일"));
            adapter.add(new Day("17년 7월 16일"));
            adapter.add(new Day("17년 7월 17일"));
            adapter.add(new Day("17년 7월 18일"));
            adapter.add(new Day("17년 7월 19일"));
            adapter.add(new Day("17년 7월 20일"));
            adapter.add(new Day("17년 7월 21일"));
            adapter.add(new Day("17년 7월 22일"));
            adapter.add(new Day("17년 7월 23일"));
            adapter.add(new Day("17년 7월 24일"));
            adapter.add(new Day("17년 7월 25일"));
            adapter.add(new Day("17년 7월 26일"));
            adapter.add(new Day("17년 7월 27일"));
            adapter.add(new Day("17년 7월 28일"));
            adapter.add(new Day("17년 7월 29일"));
            adapter.add(new Day("17년 7월 30일"));
            adapter.add(new Day("17년 7월 31일"));
        }



    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.listView3:
                if(position == 0){
                    String day = "1";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);

                    Log.i("Day position :::",position11);

                    intent.putExtra("day",day);


                    startActivity(intent);

                    break;
                }
                else if(position == 1){
                    String day = "2";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 2){
                    String day = "3";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 3){
                    String day = "4";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 4){
                    String day = "5";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 5){
                    String day = "6";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 6){
                    String day = "7";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 7){
                    String day = "8";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 8){
                    String day = "9";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 9){
                    String day = "10";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 10){
                    String day = "11";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 11){
                    String day = "12";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 12){
                    String day = "13";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 13){
                    String day = "14";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 14){
                    String day = "15";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 15){
                    String day = "16";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 16){
                    String day = "17";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 17){
                    String day = "18";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 18){
                    String day = "19";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }else if(position == 19){
                    String day = "20";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 20){
                    String day = "21";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 21){
                    String day = "22";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 22){
                    String day = "23";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 23){
                    String day = "24";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 24){
                    String day = "25";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 25){
                    String day = "26";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 26){
                    String day = "27";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 27){
                    String day = "28";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 28){
                    String day = "29";

                    Intent intent = new Intent(getApplicationContext(),Connection.class);

                    intent.putExtra("position",position11);

                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 29) {
                    String day = "30";

                    Intent intent = new Intent(getApplicationContext(), Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
                else if(position == 30) {
                    String day = "31";

                    Intent intent = new Intent(getApplicationContext(), Connection.class);

                    intent.putExtra("position",position11);
                    intent.putExtra("day",day);

                    startActivity(intent);

                    break;
                }
        }
    }
}
