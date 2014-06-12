package com.byeongyeol.listview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.byeongyeol.sample.R;

public class ListviewSampleButtonListView extends Activity implements OnItemClickListener {

	private Context				mContext;
	private ListView			mListView;
	private MainListAdapter		mListAdapter;
	private ArrayList<String[]>	listData;
	
	public Context getmContext() { return mContext; }
	public void setmContext(Context mContext) { this.mContext = mContext; }

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.samplemainactivity);
		
		setmContext(this);
		
		listData = new ArrayList<String[]>();
		
		for (int i = 0; i < 20; i++)
		{
			listData.add(new String[] { "Button ListView " + i , String.valueOf(i) });
		}

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
			Button item_btn_test;

			convertView = inflater.inflate(R.layout.list_button_item, null);
			
			item_title = (TextView) convertView.findViewById(R.id.title);
			item_title.setText(item[0].toString());
			
			item_btn_test = (Button) convertView.findViewById(R.id.btn_test);
			item_btn_test.setFocusable(false);
			item_btn_test.setClickable(false);
			
			item_btn_test.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v)
				{
					runOnUiThread(new Runnable() {
						@Override
						public void run()
						{
							Toast.makeText(getmContext(), item[1] + " 버튼 클릭", Toast.LENGTH_SHORT).show();
						}
					});
				}
			});

			return convertView;
		}
	}
}
