package com.group.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.group.util.mainsort;
import com.group.util.ransort;

public class ttt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> studentid_list = new ArrayList<Integer>();
		Random rn = new Random();
		HashMap<Integer, HashMap<Integer, Integer>> StudentSkill = new HashMap<Integer, HashMap<Integer, Integer>>();
		for(int i=0; i < 99; i++){
			HashMap<Integer, Integer> skill = new HashMap<Integer, Integer>();
			for(int j=1; j < 5; j++){
				skill.put(j, rn.nextInt(4));			
			}
			StudentSkill.put(i, skill);
		}
		List<Integer> ProjectSkill = new ArrayList<Integer>();
		ProjectSkill.add(1);
		ProjectSkill.add(2);
		int groupnum = 10;
		mainsort aa = new mainsort();
		List<List<Integer>> list = aa.mainsort(StudentSkill, ProjectSkill, groupnum);
		for (int i = 0; i < list.size(); i++) {
		     System.out.println(list.get(i).toString());
		}
		
		

	}

}
