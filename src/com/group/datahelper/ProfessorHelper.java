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

	public Boolean addProssor(String username, String name, String password,
			String email) {
		// TODO Auto-generated method stub
		Professor professor = new Professor();
		professor.setEmail(email);
		professor.setName(name);
		professor.setPassword(password);
		professor.setUsername(username);
		try{
			professorDAO.save(professor);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		
		
	}
}
