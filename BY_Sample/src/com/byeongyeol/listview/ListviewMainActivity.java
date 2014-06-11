package com.byeongyeol.listview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.byeongyeol.sample.R;

public class ListviewMainActivity extends Activity implements OnItemClickListener {
	
	private ListView			mListView;
	private MainListAdapter		mListAdapter;
	private ArrayList<String[]>	listData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listviewmainactivity);
		
		ListviewMainListData mListviewMainListData = new ListviewMainListData();
		listData = mListviewMainListData.getMainListData();

		initUI();
	}
	
	private void initUI() 
	{
		mListAdapter = new MainListAdapter(this, listData);

		mListView = (ListView) findViewById(R.id.main_list);
		mListView.setFadingEdgeLength(0);
		mListView.setOnItemClickListener(this);
		mListView.setAdapter(mListAdapter);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
	{
		Toast.makeText(this, "현재 위치는? = " + position, Toast.LENGTH_SHORT).show();
		
		Intent mIntent = null;
		
		int pos = Integer.valueOf(listData.get(position)[1]);

		switch (pos)
		{
			case 0:
				mIntent = new Intent(this, ListviewSampleDefalutListView.class);
				break;
	
			default:
				break;
		}
		
		if (mIntent != null)
			startActivity(mIntent);
	}
	
	public class MainListAdapter extends BaseAdapter {
		
		private Context				mContext;
		private LayoutInflater		inflater;
		private ArrayList<String[]>	mListData;

		public MainListAdapter(Context context, ArrayList<String[]> listData) 
		{
			mContext	= context;
			inflater	= LayoutInflater.from(mContext);
			mListData	= listData;
		}

		@Override
		public int getCount() 
		{
			return mListData.size();
		}

		@Override
		public Object getItem(int position) 
		{
			return mListData.get(position);
		}

		@Override
		public long getItemId(int position) 
		{
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) 
		{
			final String[] item = mListData.get(position);

			TextView item_title;

			convertView = inflater.inflate(R.layout.main_list_item, null);
			
			item_title = (TextView) convertView.findViewById(R.id.title);
			item_title.setText(item[0].toString());

			return convertView;
		}
	}
}
