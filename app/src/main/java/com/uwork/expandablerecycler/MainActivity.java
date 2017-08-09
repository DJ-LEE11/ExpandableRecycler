package com.uwork.expandablerecycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button  listGridview,listGridDoubleData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listGridview = (Button) findViewById(R.id.listGrid);
        listGridview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,
                        CustomGridViewActivity.class);
                startActivity(intent);
            }
        });

        listGridDoubleData = (Button) findViewById(R.id.listGridDoubleData);
        listGridDoubleData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,
                        DoubleDataGridViewActivity.class);
                startActivity(intent);
            }
        });

    }
}
