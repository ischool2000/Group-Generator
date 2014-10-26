package com.group.util;

import java.util.ArrayList;
import java.util.Collections;

public class randomstudent {
	public ArrayList<Integer> randomsort(ArrayList<Integer> student_id_list){
		Collections.shuffle(student_id_list);
		return student_id_list;
	}
}
