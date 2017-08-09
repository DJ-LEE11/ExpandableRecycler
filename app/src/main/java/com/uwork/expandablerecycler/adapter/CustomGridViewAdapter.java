package com.uwork.expandablerecycler.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.uwork.expandablerecycler.R;
import com.uwork.expandablerecycler.bean.ChildBean;

import java.util.List;


public class CustomGridViewAdapter extends BaseAdapter {

	private List<ChildBean> list;
	private Context context;
	private int position = 0;
	Holder view;

	public CustomGridViewAdapter(Context context, List<ChildBean> list) {
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		if (list != null && list.size() > 0)
			return list.size();
		else
			return 0;
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.item_gridview, null);
			view = new Holder(convertView);
			convertView.setTag(view);
		} else {
			view = (Holder) convertView.getTag();
		}
		if (list != null && list.size() > 0) {
			view.name.setText(list.get(position).getInfo());
		}

		return convertView;
	}

	public void setSelectItem(int position) {
		this.position = position;
	}

	private class Holder {
		private TextView name;

		public Holder(View view) {
			name = (TextView) view.findViewById(R.id.typename);
		}
	}

}
