package com.byeongyeol.main;

import java.util.ArrayList;

public class SampleMainListData {

	private ArrayList<String[]> listData;

	public SampleMainListData()
	{
		listData = new ArrayList<String[]>();

		listData.add(0, new String[] { "�׽�Ʈ01", "0" });
		listData.add(1, new String[] { "�׽�Ʈ02", "1" });
		listData.add(2, new String[] { "�׽�Ʈ03", "2" });
		listData.add(3, new String[] { "�׽�Ʈ04", "3" });
		listData.add(4, new String[] { "�׽�Ʈ05", "4" });
		listData.add(5, new String[] { "�׽�Ʈ06", "5" });
		listData.add(6, new String[] { "�׽�Ʈ07", "6" });
		listData.add(7, new String[] { "�׽�Ʈ08", "7" });
		listData.add(8, new String[] { "�׽�Ʈ09", "8" });
		listData.add(9, new String[] { "�׽�Ʈ10", "9" });
	}

	public ArrayList<String[]> getMainListData()
	{
		return listData;
	}
}