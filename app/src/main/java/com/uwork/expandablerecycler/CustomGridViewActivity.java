package com.uwork.expandablerecycler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.uwork.expandablerecycler.adapter.CustomClassifyMainAdapter;
import com.uwork.expandablerecycler.adapter.CustomGridViewAdapter;
import com.uwork.expandablerecycler.model.Model;

import java.util.ArrayList;
import java.util.List;

public class CustomGridViewActivity extends Activity {
    private ListView mainlist;
    private GridView morelist;
    private List<String> mainList;
    CustomClassifyMainAdapter mainAdapter;
    CustomGridViewAdapter moreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_gridview);
        initModle();
        initView();
    }

    private void initView() {
        mainlist = (ListView) findViewById(R.id.classify_mainlist);
        morelist = (GridView) findViewById(R.id.classify_morelist);
        mainAdapter = new CustomClassifyMainAdapter(this, mainList);
        mainAdapter.setSelectItem(0);
        mainlist.setAdapter(mainAdapter);

        mainlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                initAdapter(Model.MORELISTTXT[position]);
                mainAdapter.setSelectItem(position);
                mainAdapter.notifyDataSetChanged();
            }
        });
        mainlist.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        // 一定要设置这个属性，否则ListView不会刷新
        initAdapter(Model.MORELISTTXT[0]);

        morelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                moreAdapter.setSelectItem(position);
                moreAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initAdapter(String[] array) {
        moreAdapter = new CustomGridViewAdapter(this, array);
        morelist.setAdapter(moreAdapter);
        moreAdapter.notifyDataSetChanged();
    }

    private void initModle() {
        mainList = new ArrayList<String>();
        for (int i = 0; i < Model.LISTVIEWTXT.length; i++) {
            mainList.add(Model.LISTVIEWTXT[i]);
        }
    }
}
