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
public class DoubleDataGroupedListAdapter extends GroupedRecyclerViewAdapter {

    private ArrayList<GroupBean> lists;

    public DoubleDataGroupedListAdapter(Context context, ArrayList<GroupBean> lists) {
        super(context);
        this.lists = lists;
    }

    public void setData(ArrayList<GroupBean> lists){
        this.lists = lists;
    }

    @Override
    public int getGroupCount() {
        return lists.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return lists.get(groupPosition).getChildren() == null ? 0 : lists.get(groupPosition).getChildren().size();
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
        holder.setText(R.id.tv_header, lists.get(groupPosition).getTitle());
    }

    @Override
    public void onBindFooterViewHolder(BaseViewHolder holder, int groupPosition) {
        holder.setText(R.id.tv_footer, lists.get(groupPosition).getTitle());
    }

    @Override
    public void onBindChildViewHolder(BaseViewHolder holder, int groupPosition, int childPosition) {
        ChildBean childBean = lists.get(groupPosition).getChildren().get(childPosition);
        holder.setText(R.id.typename, childBean.getInfo());
    }
}
