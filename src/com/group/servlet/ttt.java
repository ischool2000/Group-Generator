package com.group.servlet;

import java.util.ArrayList;
import java.util.List;

import com.group.util.ransort;

public class ttt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> studentid_list = new ArrayList<Integer>();
		for(int i = 0; i < 74; i++)
			studentid_list.add(i);
		ransort aa = new ransort();
		List<List<Integer>> list = aa.randomsort(studentid_list, 18);
		for (int i = 0; i < list.size(); i++) {
		     System.out.println(list.get(i).toString());
		}
		
		

	}

}
