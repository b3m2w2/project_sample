package com.byeongyeol.listview;

import java.util.ArrayList;

public class ListviewMainListData {

	private ArrayList<String[]> listData;

	public ListviewMainListData()
	{
		listData = new ArrayList<String[]>();

		listData.add(new String[] { "�⺻ ����Ʈ��", "0" });
		listData.add(new String[] { "��ư�� �ִ� ����Ʈ��", "1" });
//		listData.add(new String[] { "�׽�Ʈ03", "2" });
//		listData.add(new String[] { "�׽�Ʈ04", "3" });
//		listData.add(new String[] { "�׽�Ʈ05", "4" });
//		listData.add(new String[] { "�׽�Ʈ06", "5" });
//		listData.add(new String[] { "�׽�Ʈ07", "6" });
//		listData.add(new String[] { "�׽�Ʈ08", "7" });
//		listData.add(new String[] { "�׽�Ʈ09", "8" });
//		listData.add(new String[] { "�׽�Ʈ10", "9" });
	}

	public ArrayList<String[]> getMainListData()
	{
		return listData;
	}
}