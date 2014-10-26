package com.group.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ransort {
	public List<List<Integer>> randomsort(ArrayList<Integer> studentid_list, int groupnum){
		Collections.shuffle(studentid_list);
		int student_per_group = Math.round(studentid_list.size()/groupnum);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int p = 0;
		for(int i=0; i < groupnum-1; i++){
			list.add(studentid_list.subList(p, p+student_per_group));
			p += student_per_group;
		}
		list.add(studentid_list.subList(p, studentid_list.size()));
		return list;
	}
}
