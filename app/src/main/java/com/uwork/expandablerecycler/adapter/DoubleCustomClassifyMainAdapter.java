package com.uwork.expandablerecycler.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uwork.expandablerecycler.R;
import com.uwork.expandablerecycler.bean.GroupBean;

import java.util.ArrayList;

public class DoubleCustomClassifyMainAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ArrayList<GroupBean>> list;
    private int mCurrentPosition = 0;
    Holder hold;

    public DoubleCustomClassifyMainAdapter(Context context, ArrayList<ArrayList<GroupBean>> list) {
        this.context = context;
        this.list = list;
    }

    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = View.inflate(context, R.layout.custom_item_classify_mainlist, null);
            hold = new Holder(view);
            view.setTag(hold);
        } else {
            hold = (Holder) view.getTag();
        }

        String title = "";
        ArrayList<GroupBean> groupBeen = list.get(position);
        for (int i = 0; i < groupBeen.size(); i++) {
            title = title + groupBeen.get(i).getTitle();
        }

        hold.txt.setText(title);
        hold.layout.setBackgroundColor(0xFFEBEBEB);
        if (position == mCurrentPosition) {
            hold.layout.setBackgroundColor(0xFFFFFFFF);
        }
        return view;
    }

    public void setSelectItem(int position) {
        this.mCurrentPosition = position;
    }

    public int getSelectItem() {
        return mCurrentPosition;
    }

    private static class Holder {
        LinearLayout layout;
        TextView txt;

        public Holder(View view) {
            txt = (TextView) view.findViewById(R.id.mainitem_txt);
            layout = (LinearLayout) view.findViewById(R.id.mainitem_layout);
        }
    }
}
