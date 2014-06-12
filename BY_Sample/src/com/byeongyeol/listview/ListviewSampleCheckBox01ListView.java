package com.byeongyeol.listview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.byeongyeol.sample.R;

public class ListviewSampleCheckBox01ListView extends Activity implements OnClickListener {

	private Context				mContext;
	private ArrayList<String[]>	listData;
	private ListView			mListView;
	private MainListAdapter		mListAdapter;
	private Button 				btnAllCheck;
	private Button				btnAllUnCheck;
	private Button				btnConfirmation;
	private TextView			tvResult;
	
	public Context getmContext() { return mContext; }
	public void setmContext(Context mContext) { this.mContext = mContext; }

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listviewsamplecheckbox01listview);
		
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
		btnAllCheck = (Button) findViewById(R.id.btn_all_check);
		btnAllUnCheck = (Button) findViewById(R.id.btn_all_uncheck);
		btnConfirmation = (Button) findViewById(R.id.btn_check_confirmation);
		tvResult = (TextView) findViewById(R.id.result);
		
		btnAllCheck.setOnClickListener(this);
		btnAllUnCheck.setOnClickListener(this);
		btnConfirmation.setOnClickListener(this);
		
		mListAdapter = new MainListAdapter(this, listData);

		mListView = (ListView) findViewById(R.id.main_list);
		mListView.setFadingEdgeLength(0);
		mListView.setAdapter(mListAdapter);
	}
	
	private void setListCheck(boolean flag)
	{
		if (mListAdapter != null)
		{
			mListAdapter.setAllCheck(flag);
			mListAdapter.notifyDataSetChanged();
		}
	}
	
	private void confirmationChecked()
	{
		if (mListAdapter != null && tvResult != null)
		{
			SparseBooleanArray checkedArray = mListAdapter.getCheckedArray();
			int size = checkedArray.size();
			if (size > 0)
			{
				String ret = "";
				for (int i = 0; i < size; i++)
				{
					int key = checkedArray.keyAt(i);
					ret += mListAdapter.getListData(key)[1];
					ret += ", ";

				}
				tvResult.setText(ret.substring(0, ret.length() - 2));
			}
			else
			{
				tvResult.setText("");
			}
		}
	}
	
	@Override
	public void onClick(View v) {
		
		switch (v.getId())
		{
		case R.id.btn_all_check:
			setListCheck(true);
			break;
			
		case R.id.btn_all_uncheck:
			setListCheck(false);
			break;
			
		case R.id.btn_check_confirmation:
			confirmationChecked();
			break;

		default:
			break;
		}
	}
	
	public class MainListAdapter extends BaseAdapter {
		
		private Context				mContext;
		private LayoutInflater		inflater;
		private ArrayList<String[]>	mListData;
		
		private boolean[] 						isCheckedArray;
		private SparseBooleanArray 				mCheckedSparseArray;
		
		private ListItemHolder 				viewHolder = null;

		public MainListAdapter(Context context, ArrayList<String[]> listData) 
		{
			mContext	= context;
			inflater	= LayoutInflater.from(mContext);
			mListData	= listData;
			
			mCheckedSparseArray = new SparseBooleanArray();
			isCheckedArray = new boolean[mListData.size()];
		}
		
		public void addItem(ArrayList<String[]> item)
		{
			mListData.removeAll(item);
			mListData.addAll(item);
		}
		
		public String[] getListData(int position) 
		{
			return mListData.get(position);
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
		
		public void setAllCheck(boolean isCheck)
		{
			if (isCheckedArray != null)
			{
				for (int i = 0; i < isCheckedArray.length; i++)
				{
					isCheckedArray[i] = isCheck;
					if (isCheck)
					{
						mCheckedSparseArray.append(i, true);
					}
					else
					{
						mCheckedSparseArray.delete(i);
					}
				}
			}
		}
		
		public void setClear() 
		{
			mListData.clear();
		}
		
		public int getCheckedArraySize() 
		{
			return mCheckedSparseArray.size();
		}

		public SparseBooleanArray getCheckedArray() 
		{
			return mCheckedSparseArray;
		}

		public void clearCheckedArray() 
		{
			mCheckedSparseArray.clear();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			final String[] item = mListData.get(position);

			if (convertView == null)
			{
				convertView = inflater.inflate(R.layout.list_checkbox01_item, null);
				viewHolder = new ListItemHolder(convertView);
			}
			else
			{
				viewHolder = (ListItemHolder) convertView.getTag();
			}

			TextView item_title = (TextView) viewHolder.getTitle();
			final ToggleButton item_delCheck = viewHolder.getCheckbox();

			final int arrPosition = position;

			item_delCheck.setTag(position);

			item_delCheck.setOnCheckedChangeListener(new OnCheckedChangeListener() {
						@Override
						public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
							Integer id = (Integer) buttonView.getTag();
							if (isChecked == true)
							{
								isCheckedArray[arrPosition] = true;
								mCheckedSparseArray.append(id, true);
							}
							else
							{
								isCheckedArray[arrPosition] = false;
								mCheckedSparseArray.delete(id);
							}
						}
					});
			if (isCheckedArray.length != 0)
			{
				if (isCheckedArray[arrPosition])
				{
					item_delCheck.setChecked(true);
				}
				else
				{
					item_delCheck.setChecked(false);
				}
			}

			item_title.setText(item[0].toString());

			convertView.setTag(viewHolder);

			return convertView;
		}
		
		private class ListItemHolder
		{
			public View mVewBase;
			public ToggleButton item_delCheck;
			public TextView title;

			public ListItemHolder(View base)
			{
				this.mVewBase = base;
			}

			public ToggleButton getCheckbox()
			{
				if (item_delCheck == null)
				{
					item_delCheck = (ToggleButton) mVewBase.findViewById(R.id.btn_checkbox);
				}
				return item_delCheck;
			}

			public TextView getTitle()
			{
				if (title == null)
				{
					title = (TextView) mVewBase.findViewById(R.id.title);
				}
				return title;
			}
		}
	}
}