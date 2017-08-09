package com.uwork.expandablerecycler;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter;
import com.donkingliang.groupedadapter.holder.BaseViewHolder;
import com.donkingliang.groupedadapter.layoutmanger.GroupedGridLayoutManager;
import com.uwork.expandablerecycler.adapter.CustomClassifyMainAdapter;
import com.uwork.expandablerecycler.adapter.NoFooterAdapter;
import com.uwork.expandablerecycler.bean.GroupBean;
import com.uwork.expandablerecycler.model.Model;

public class CustomGridViewActivity extends Activity {
    private ListView mainList;
    private RecyclerView moreList;
    private NoFooterAdapter mNoFooterAdapter;
    CustomClassifyMainAdapter mainAdapter;
    private int mCurrentGroupIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_gridview);
        initView();
    }

    private void initView() {
        mainList = (ListView) findViewById(R.id.classify_main_list);
        mainAdapter = new CustomClassifyMainAdapter(this, Model.getGroups());
        mainAdapter.setSelectItem(0);
        mainList.setAdapter(mainAdapter);

        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                mCurrentGroupIndex = position;
                initAdapter(Model.getGroups().get(position));
                mainAdapter.setSelectItem(position);
                mainAdapter.notifyDataSetChanged();
            }
        });
        mainList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        // 一定要设置这个属性，否则ListView不会刷新

        moreList = (RecyclerView) findViewById(R.id.classify_more_list);
        mNoFooterAdapter = new NoFooterAdapter(this, Model.getGroups().get(0));
        mNoFooterAdapter.setOnHeaderClickListener(new GroupedRecyclerViewAdapter.OnHeaderClickListener() {
            @Override
            public void onHeaderClick(GroupedRecyclerViewAdapter adapter, BaseViewHolder holder, int groupPosition) {
                Toast.makeText(CustomGridViewActivity.this, "组头：groupPosition = " + groupPosition,
                        Toast.LENGTH_LONG).show();
            }
        });
        mNoFooterAdapter.setOnChildClickListener(new GroupedRecyclerViewAdapter.OnChildClickListener() {
            @Override
            public void onChildClick(GroupedRecyclerViewAdapter adapter, BaseViewHolder holder, int groupPosition, int childPosition) {
                if (mCurrentGroupIndex!=-1){
                    Toast.makeText(CustomGridViewActivity.this, Model.getGroups().get(mCurrentGroupIndex).getChildren().get(childPosition).getInfo()
                            ,Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(CustomGridViewActivity.this, Model.getGroups().get(0).getChildren().get(childPosition).getInfo()
                            ,Toast.LENGTH_LONG).show();
                }

            }
        });
        moreList.setAdapter(mNoFooterAdapter);
        moreList.setLayoutManager(new GroupedGridLayoutManager(this, 2, mNoFooterAdapter));
    }

    private void initAdapter(GroupBean groupBean) {
        mNoFooterAdapter.setData(groupBean);
        mNoFooterAdapter.notifyDataSetChanged();
    }


}
