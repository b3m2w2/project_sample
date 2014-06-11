package com.byeongyeol.main;

import java.util.ArrayList;

public class SampleMainListData {

	private ArrayList<String[]> listData;

	public SampleMainListData()
	{
		listData = new ArrayList<String[]>();

		listData.add(0, new String[] { "테스트01", "0" });
		listData.add(1, new String[] { "테스트02", "1" });
		listData.add(2, new String[] { "테스트03", "2" });
		listData.add(3, new String[] { "테스트04", "3" });
		listData.add(4, new String[] { "테스트05", "4" });
		listData.add(5, new String[] { "테스트06", "5" });
		listData.add(6, new String[] { "테스트07", "6" });
		listData.add(7, new String[] { "테스트08", "7" });
		listData.add(8, new String[] { "테스트09", "8" });
		listData.add(9, new String[] { "테스트10", "9" });
	}

	public ArrayList<String[]> getMainListData()
	{
		return listData;
	}
}