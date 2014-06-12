package com.byeongyeol.listview;

import java.util.ArrayList;

public class ListviewMainListData {

	private ArrayList<String[]> listData;

	public ListviewMainListData()
	{
		listData = new ArrayList<String[]>();

		listData.add(new String[] { "기본 리스트뷰", "0" });
		listData.add(new String[] { "버튼이 있는 리스트뷰", "1" });
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