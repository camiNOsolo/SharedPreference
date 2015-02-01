package com.example.canio.sharedpreference;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;


public class SegundaActividad extends Activity {

    // Referencias
    private TextView textTxt;
    private String text;
    private SharedPreference sharedPreference;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        context = this;
        sharedPreference = new SharedPreference();

        findViewsById();

        //Recibe un valor para SharedPreference
        text = sharedPreference.getValue(context);
        textTxt.setText(text);

    }

    private void findViewsById() {
        textTxt = (TextView) findViewById(R.id.txt_text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}