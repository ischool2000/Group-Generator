package com.group.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class mainsort {
	public List<List<Integer>> mainsort(HashMap<Integer, HashMap<Integer, Integer>> StudentSkill, List<Integer> ProjectSkill, int groupnum){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		HashMap<Integer, Integer> StudentWeight = new HashMap<Integer, Integer>();
        for(Map.Entry<Integer, HashMap<Integer, Integer>> studentEntry : StudentSkill.entrySet()){
        	int weight = 0;
            for(int skillID: studentEntry.getValue().keySet()){
            	if(ProjectSkill.contains(skillID)){
            		weight += 5*studentEntry.getValue().get(skillID);
            	}
            }
            StudentWeight.put(studentEntry.getKey(), weight);
        }
        HashMap<Integer, Integer> StudentWeightAfter = sortByValues(StudentWeight);;
        ArrayList<Integer> studentid_list = new ArrayList<Integer>();
        for(int key: StudentWeightAfter.keySet()){
            studentid_list.add(key);
        }
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
	
	private static HashMap<Integer, Integer> sortByValues(HashMap<Integer, Integer> map) { 
        Set<Entry<Integer, Integer>> set = map.entrySet();
        List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<Integer, Integer>>()
        {
            public int compare( Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        return map;
	}
}

