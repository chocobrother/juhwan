package com.example.juhwan.axivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    EditText editText1,editText2;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

        button1 = (Button) findViewById(R.id.loginButton);

        button2 = (Button)findViewById(R.id.signupButton);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editText1.getText().toString();
                String pw = editText2.getText().toString();

                if(id.equals("root") && pw.equals("1234")){
                    Toast.makeText(MainActivity.this,"Login Success",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplication(),ListDateActivity.class);

                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
