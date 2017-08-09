package com.uwork.expandablerecycler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.uwork.expandablerecycler.adapter.CustomClassifyMainAdapter;
import com.uwork.expandablerecycler.adapter.CustomGridViewAdapter;
import com.uwork.expandablerecycler.bean.ChildBean;
import com.uwork.expandablerecycler.model.Model;

import java.util.ArrayList;

public class CustomGridViewActivity extends Activity {
    private ListView mainList;
    private GridView moreList;
    CustomClassifyMainAdapter mainAdapter;
    CustomGridViewAdapter moreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_gridview);
        initView();
    }

    private void initView() {
        mainList = (ListView) findViewById(R.id.classify_mainlist);
        moreList = (GridView) findViewById(R.id.classify_morelist);
        mainAdapter = new CustomClassifyMainAdapter(this, Model.getGroups());
        mainAdapter.setSelectItem(0);
        mainList.setAdapter(mainAdapter);

        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                initAdapter(Model.getGroups().get(position).getChildren());
                mainAdapter.setSelectItem(position);
                mainAdapter.notifyDataSetChanged();
            }
        });
        mainList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        // 一定要设置这个属性，否则ListView不会刷新
        initAdapter(Model.getGroups().get(0).getChildren());

        moreList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                moreAdapter.setSelectItem(position);
                moreAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initAdapter(ArrayList<ChildBean> list) {
        moreAdapter = new CustomGridViewAdapter(this, list);
        moreList.setAdapter(moreAdapter);
        moreAdapter.notifyDataSetChanged();
    }

}
