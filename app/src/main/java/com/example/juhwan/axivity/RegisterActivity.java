package com.example.juhwan.axivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText idText = (EditText)findViewById(R.id.idText);
        EditText pwText = (EditText)findViewById(R.id.pwtext);
        EditText nameText = (EditText)findViewById(R.id.nameText);
        EditText ageText = (EditText)findViewById(R.id.ageText);

        Button btn_register = (Button)findViewById(R.id.btn_register);

    }
}
