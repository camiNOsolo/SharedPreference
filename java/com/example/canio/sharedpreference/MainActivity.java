package com.example.canio.sharedpreference;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    // Referencias
    private EditText textEtxt;
    private Button saveButton;
    private Button activity2Button;
    private String text;
    private SharedPreference sharedPreference;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreference = new SharedPreference();
        context = this;
        findViewsById();

        saveButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                text = textEtxt.getText().toString();

                // Hides the soft keyboard
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(textEtxt.getWindowToken(), 0);

                // Salva el texto en SharedPreference
                sharedPreference.save(context, text);
                Toast.makeText(context, getResources().getString(R.string.saved), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(context, SegundaActividad.class);
                // Start next activity
                startActivity(intent);
            }
        });
    }

    private void findViewsById() {
        textEtxt = (EditText) findViewById(R.id.etxt_text);
        saveButton = (Button) findViewById(R.id.button_save);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}