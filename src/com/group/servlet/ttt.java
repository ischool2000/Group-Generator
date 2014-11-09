package com.group.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.group.util.gendersort;
import com.group.util.mainsort;
import com.group.util.ransort;

public class ttt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> studentid_list = new ArrayList<Integer>();
		for(int i=0; i < 74; i++){
			studentid_list.add(i);
		}
		int groupnum = 10;
		gendersort aa = new gendersort();
		List<List<Integer>> list = aa.gendersort(studentid_list, groupnum);
		for (int i = 0; i < list.size(); i++) {
		     System.out.println(list.get(i).toString());
		}
		
		

	}

}
