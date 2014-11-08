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
	
	private static HashMap sortByValues(HashMap map) { 
		List list = new LinkedList(map.entrySet());
	    // Defined Custom Comparator here
	    Collections.sort(list, new Comparator() {
	    public int compare(Object o1, Object o2) {
	    return ((Comparable) ((Map.Entry) (o1)).getValue())
	            .compareTo(((Map.Entry) (o2)).getValue());
	    }
	    });

	       // Here I am copying the sorted list in HashMap
	       // using LinkedHashMap to preserve the insertion order
	    HashMap sortedHashMap = new LinkedHashMap();
	    for (Iterator it = list.iterator(); it.hasNext();) {
	         Map.Entry entry = (Map.Entry) it.next();
	         sortedHashMap.put(entry.getKey(), entry.getValue());
	    } 
	    return sortedHashMap;
	  }
}

