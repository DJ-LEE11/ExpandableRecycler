package com.uwork.expandablerecycler.adapter;

import android.content.Context;

import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter;
import com.donkingliang.groupedadapter.holder.BaseViewHolder;
import com.uwork.expandablerecycler.R;
import com.uwork.expandablerecycler.bean.ChildBean;
import com.uwork.expandablerecycler.bean.GroupBean;

import java.util.ArrayList;

/**
 * 这是普通的分组Adapter 每一个组都有头部、尾部和子项。
 */
public class GroupedListAdapter extends GroupedRecyclerViewAdapter {

    private GroupBean mGroup;
    private ArrayList<ChildBean> lists;

    public GroupedListAdapter(Context context, GroupBean group) {
        super(context);
        mGroup = group;
        lists = mGroup.getChildren();
    }

    public void setData(GroupBean group){
        if (group!=null){
            mGroup = group;
            lists = mGroup.getChildren();
        }
    }

    @Override
    public int getGroupCount() {
        return 1;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return lists == null ? 0 : lists.size();
    }

    @Override
    public boolean hasHeader(int groupPosition) {
        return true;
    }

    @Override
    public boolean hasFooter(int groupPosition) {
        return true;
    }

    @Override
    public int getHeaderLayout(int viewType) {
        return R.layout.adapter_header;
    }

    @Override
    public int getFooterLayout(int viewType) {
        return R.layout.adapter_footer;
    }

    @Override
    public int getChildLayout(int viewType) {
        return R.layout.item_gridview;
    }

    @Override
    public void onBindHeaderViewHolder(BaseViewHolder holder, int groupPosition) {
        holder.setText(R.id.tv_header, mGroup.getTitle());
    }

    @Override
    public void onBindFooterViewHolder(BaseViewHolder holder, int groupPosition) {
        holder.setText(R.id.tv_footer, mGroup.getTitle());
    }

    @Override
    public void onBindChildViewHolder(BaseViewHolder holder, int groupPosition, int childPosition) {
        ChildBean childBean = lists.get(childPosition);
        holder.setText(R.id.typename, childBean.getInfo());
    }
}
