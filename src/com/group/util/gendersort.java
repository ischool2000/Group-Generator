package com.group.util;

import java.util.ArrayList;
import java.util.List;

public class gendersort {
	public List<List<Integer>> gendersort(ArrayList<Integer> studentid_list, int groupnum){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int student_per_group = Math.round(((float)studentid_list.size())/groupnum);
		int ph = 0, pt = studentid_list.size()-1;
		for(int i=0; i < groupnum-1; i++){
	        ArrayList<Integer> subList = new ArrayList<Integer>();
			while(subList.size() != student_per_group){
				subList.add(studentid_list.get(ph));ph++;
				if(subList.size() != student_per_group){
					subList.add(studentid_list.get(pt));pt--;
				}
			}
			list.add(subList);
		}
		list.add(studentid_list.subList(ph, pt+1));
		return list;
	}
}
