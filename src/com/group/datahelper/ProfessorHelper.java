package com.group.datahelper;

import com.group.DAO.ProfessorDAO;
import com.group.model.Professor;

public class ProfessorHelper {
	
	ProfessorDAO professorDAO = new ProfessorDAO();
	public Professor getRandomOne(){
		Professor professor = (Professor) professorDAO.findAll().get(0);
		return professor;
		
	}
}
