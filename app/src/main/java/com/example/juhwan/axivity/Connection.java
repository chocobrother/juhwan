package com.example.juhwan.axivity;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.juhwan.axivity.adapter.JSONAdapter;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Connection extends AppCompatActivity {

    private Button btn_send,btn_clear,btn_result;
    private ListView listView;

    private String sServer = "192.168.0.202";
    private int iPort = 21;

    String position;
    String day;

    List<Data> list;

    JSONAdapter adapter;

    int sit = 0;
    int walk = 0;
    int run = 0;

    String timeday = "";
    private String[] getJsonData = { "", "" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        btn_send = (Button)findViewById(R.id.btn_send);

        btn_clear = (Button)findViewById(R.id.btn_clear);

        btn_result = (Button)findViewById(R.id.btn_result);
        list = new ArrayList<Data>();

        adapter = new JSONAdapter(this,R.layout.list_item,list);

        listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(adapter);

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);

                intent.putExtra("walk",walk);
                intent.putExtra("sit",sit);
                intent.putExtra("run",run);
                intent.putExtra("timeday",timeday);

                String walk1 = String.valueOf(walk);
                String sit1 = String.valueOf(sit);
                String run1 = String.valueOf(run);

                Log.i("walk :::",walk1);
                Log.i("sit :::",sit1);
                Log.i("run :::",run1);
                Log.i("timeday",timeday);



                startActivity(intent);
            }
        });

		/*	Send 버튼을 눌렀을 때 서버에 데이터를 보내고 받는다	*/

        btn_send.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                String sMessage = "plz";

                String result = SendByHttp(sMessage); // 메시지를 서버에 보냄

                String[][] parsedData = jsonParserList(result); // 받은 메시지를 json 파싱

                //  ListView.

            }

        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                list.clear();

                adapter.notifyDataSetChanged();
            }
        });

//        new Thread(){
//            public void run(){
//                try {
//                    FTPClient ftpClient = new FTPClient();
//                    ftpClient.connect(sServer,iPort);
//                    ftpClient.login("Juhwan","c199247");
//                    Log.i("ftp login : ", "ftp gggg");
//                }catch(IOException e){
//                    e.printStackTrace();
//                }
//            }
//        }.start();

    }

    /**

     * 서버에 데이터를 보내는 메소드

     * @param msg

     * @return

     */

    private String SendByHttp(String msg) {

        if(msg == null)

            msg = "";

        String URL = "http://192.168.0.202:8080/Axivity/test.jsp";

        DefaultHttpClient client = new DefaultHttpClient();

        try {

			/* 체크할 id와 pwd값 서버로 전송 */

            HttpPost post = new HttpPost(URL+"?msg="+msg);

			/* 지연시간 최대 3초 */

            HttpParams params = client.getParams();

            HttpConnectionParams.setConnectionTimeout(params, 3000);

            HttpConnectionParams.setSoTimeout(params, 3000);

			/* 데이터 보낸 뒤 서버에서 데이터를 받아오는 과정 */

            HttpResponse response = client.execute(post);

            StringBuilder sb = new StringBuilder();

            BufferedReader bufreader = new BufferedReader(

                    new InputStreamReader(response.getEntity().getContent(),

                            "utf-8"));

            String line = null;

            String result = "";

            while ((line = bufreader.readLine()) != null) {

                result += line;

                sb.append(line.trim());

            }

            String data = sb.toString();

            return result;

        } catch (Exception e) {

            e.printStackTrace();

            client.getConnectionManager().shutdown();	// 연결 지연 종료

            return "";

        }
    }

    public String[][] jsonParserList(String pRecvServerPage) {

        Log.i("서버에서 받은 전체 내용 : ", pRecvServerPage);

        try {

            JSONObject json = new JSONObject(pRecvServerPage);

            JSONArray jArr = json.getJSONArray("List");

            String[] jsonName = {"blue_time","state"};


            Intent fromIntent = getIntent();

            position = fromIntent.getStringExtra("position");
            day = fromIntent.getStringExtra("day");

//            Log.i("ppppppppppppp : ", position);

            String[][] parseredData = new String[jArr.length()][jsonName.length];

            for (int i = 0; i < jArr.length(); i++) {

                json = jArr.getJSONObject(i);

                String blue_time = json.getString("blue_time").toString();
                String state = json.getString("state").toString();

                Log.i("blue_time : ", blue_time);

                if(json != null) {

                    for(int j = 0; j < jsonName.length; j++) {
                        parseredData[i][j] = json.optString(jsonName[j]);
                    }

                    String bt = blue_time.substring(0,7);
                    Log.i("blue_time : ", bt);
                    String bt2 = blue_time.substring(7,16);
                    Log.i("blue_timeeee : ", bt2);
                    String bt3 = blue_time.substring(8,10);
                    Log.i("blue_timeeee333 : ", bt3);


                    Log.i("positon :::" ,position);
                    Log.i("dayyyy :::" ,day);



                    if(position.equals("six") && bt.equals("2017-06")){
                        if(day.equals(bt3)){
                            adapter.add(new Data("시간:"+bt+bt2,"State :" +json.optString("state")));
                            if(state.equals("run"))run++;
                            if(state.equals("sit"))sit++;
                            if(state.equals("walk"))walk++;
                            timeday = bt + "-"+day;

                        }
                    }
                    else if(position.equals("seven") && bt.equals("2017-07")){
                        if(day.equals(bt3))
                            adapter.add(new Data("시간:"+bt+bt2,"State :" +json.optString("state")));
                    }
                    else if (position.equals("eight") && bt.equals("2017-08")){
                        if(day.equals(bt3))
                            adapter.add(new Data("시간:"+bt+bt2,"State :" +json.optString("state")));
                    }
                    else if (position.equals("nine")&& bt.equals("2017-09")){
                        if(day.equals(bt3))
                            adapter.add(new Data("시간:"+bt+bt2,"State :" +json.optString("state")));
                    }


//                    if(blue_time.substring(0,3).equals("1707") && position.equals("1")){
//
//                    }

//                    adapter.add(new Data("시간:"+json.optString("blue_time"),"x:"+json.optString("x"),"y:"+json.optString("y"),"z:"+json.optString("z")));

                }

            }

            // 분해 된 데이터를 확인하기 위한 부분

            for(int i=0; i<parseredData.length; i++) {

                Log.i("JSON을 분석한 데이터 " + i + " : ", parseredData[i][0]);

                Log.i("JSON을 분석한 데이터 " + i + " : ", parseredData[i][1]);

//                Log.i("JSON을 분석한 데이터 " + i + " : ", parseredData[i][2]);
//
//                Log.i("JSON을 분석한 데이터 " + i + " : ", parseredData[i][3]);
//
//                Log.i("JSON을 분석한 데이터 " + i + " : ", parseredData[i][4]);
            }
            return parseredData;

        } catch (JSONException e) {

            e.printStackTrace();

            return null;

        }

    }

}



