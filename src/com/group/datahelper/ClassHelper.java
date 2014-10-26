package com.group.datahelper;

import com.group.DAO.ClassDAO;
import com.group.model.Professor;
import com.group.model.Class;
public class ClassHelper {
	
	ClassDAO classDAO = new ClassDAO();
	public Boolean createClass(int profId, String name) {
		// TODO Auto-generated method stub
		Professor professor = new Professor();
		professor.setProfessorId(profId);
		
		Class classes = new Class();
		classes.setName(name);
		
		return null;
	}

}
