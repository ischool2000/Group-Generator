package com.group.datahelper;

import java.util.List;

import com.group.DAO.ProfessorDAO;
import com.group.model.Professor;

public class ProfessorHelper {
	
	ProfessorDAO professorDAO = new ProfessorDAO();
	
	public Professor getRandomOne(){
		Professor professor = (Professor) professorDAO.findAll().get(0);
		return professor;
		
	}
	
	public Boolean isMatch(String username, String passwood){
		List proList = professorDAO.findByUsername(username);
		if(proList.isEmpty())
			return false;
		else{
			Professor professor = (Professor)proList.get(0);
			if(professor.getPassword().equals(professor))
				return true;
			else return false;
		}
	}
}
