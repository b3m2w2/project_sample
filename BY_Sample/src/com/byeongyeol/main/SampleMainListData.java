package com.byeongyeol.main;

import java.util.ArrayList;

public class SampleMainListData {

	private ArrayList<String[]> listData;

	public SampleMainListData()
	{
		listData = new ArrayList<String[]>();

		listData.add(new String[] { "ListView", "0" });
//		listData.add(new String[] { "테스트02", "1" });
//		listData.add(new String[] { "테스트03", "2" });
//		listData.add(new String[] { "테스트04", "3" });
//		listData.add(new String[] { "테스트05", "4" });
//		listData.add(new String[] { "테스트06", "5" });
//		listData.add(new String[] { "테스트07", "6" });
//		listData.add(new String[] { "테스트08", "7" });
//		listData.add(new String[] { "테스트09", "8" });
//		listData.add(new String[] { "테스트10", "9" });
	}

	public ArrayList<String[]> getMainListData()
	{
		return listData;
	}
}