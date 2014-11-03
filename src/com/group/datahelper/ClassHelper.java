package com.group.datahelper;

import java.util.ArrayList;

import com.group.DAO.ClassDAO;
import com.group.model.Professor;
import com.group.model.Class;
import com.group.model.Project;
public class ClassHelper {
	
	ClassDAO classDAO = new ClassDAO();
	public Boolean createClass(int profId, String name) {
		// TODO Auto-generated method stub
		Professor professor = new Professor();
		professor.setProfessorId(profId);
		
		Class classes = new Class();
		classes.setName(name);
		classes.setProfessor(professor);
		
		try{
			classDAO.save(classes);
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	
		return true;
	}
	
	public ArrayList<Integer> getStudentIdListbyClassId(int classId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
