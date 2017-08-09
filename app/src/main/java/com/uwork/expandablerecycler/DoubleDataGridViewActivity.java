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
import com.uwork.expandablerecycler.adapter.DoubleCustomClassifyMainAdapter;
import com.uwork.expandablerecycler.adapter.DoubleDataNoFooterAdapter;
import com.uwork.expandablerecycler.bean.GroupBean;
import com.uwork.expandablerecycler.model.Model;

import java.util.ArrayList;

public class DoubleDataGridViewActivity extends Activity {
    private ListView mainList;
    private RecyclerView moreList;
    private DoubleDataNoFooterAdapter mNoFooterAdapter;
    private DoubleCustomClassifyMainAdapter mainAdapter;
    private int mCurrentGroupIndex = -1;
    private ArrayList<ArrayList<GroupBean>> mAllList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_gridview);
        mAllList = Model.getDoubleData();
        initView();
    }

    private void initView() {
        mainList = (ListView) findViewById(R.id.classify_main_list);
        mainAdapter = new DoubleCustomClassifyMainAdapter(this, mAllList);
        mainAdapter.setSelectItem(0);
        mainList.setAdapter(mainAdapter);
        //左边列表点击事件
        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                mCurrentGroupIndex = position;
                initAdapter(mAllList.get(position));
                mainAdapter.setSelectItem(position);
                mainAdapter.notifyDataSetChanged();
            }
        });
        mainList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        moreList = (RecyclerView) findViewById(R.id.classify_more_list);
        mNoFooterAdapter = new DoubleDataNoFooterAdapter(this, mAllList.get(0));
        //右边列表头部点击事件
        mNoFooterAdapter.setOnHeaderClickListener(new GroupedRecyclerViewAdapter.OnHeaderClickListener() {
            @Override
            public void onHeaderClick(GroupedRecyclerViewAdapter adapter, BaseViewHolder holder, int groupPosition) {
                Toast.makeText(DoubleDataGridViewActivity.this, "组头：groupPosition = " + groupPosition,
                        Toast.LENGTH_LONG).show();
            }
        });
        //右边列表Item点击事件
        mNoFooterAdapter.setOnChildClickListener(new GroupedRecyclerViewAdapter.OnChildClickListener() {
            @Override
            public void onChildClick(GroupedRecyclerViewAdapter adapter, BaseViewHolder holder, int groupPosition, int childPosition) {
                if (mCurrentGroupIndex!=-1){
                    Toast.makeText(DoubleDataGridViewActivity.this, mAllList.get(mCurrentGroupIndex).get(groupPosition).getChildren().get(childPosition).getInfo()
                            ,Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(DoubleDataGridViewActivity.this, mAllList.get(0).get(groupPosition).getChildren().get(childPosition).getInfo()
                            ,Toast.LENGTH_LONG).show();
                }

            }
        });
        moreList.setAdapter(mNoFooterAdapter);
        moreList.setLayoutManager(new GroupedGridLayoutManager(this, 3, mNoFooterAdapter));
    }

    private void initAdapter(ArrayList<GroupBean> groupBeen) {
        mNoFooterAdapter.setData(groupBeen);
        mNoFooterAdapter.notifyDataSetChanged();
    }

}
