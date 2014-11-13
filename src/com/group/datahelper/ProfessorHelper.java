package com.group.datahelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.group.DAO.ClassDAO;
import com.group.DAO.DAOManager;
import com.group.DAO.ProfessorDAO;
import com.group.model.Professor;
import com.group.model.Class;
public class ProfessorHelper {
	
	ProfessorDAO professorDAO = DAOManager.getProfessorDAO();
	ClassDAO classDAO = DAOManager.getClassDAO();
	public Professor getRandomOne(){
		Professor professor = (Professor) professorDAO.findAll().get(0);
		return professor;
		
	}
	
	public Boolean isMatch(String username, String password){
		System.out.println("isMatch: username " + username + " password" + password);
		List proList = professorDAO.findByUsername(username);
		if(proList.isEmpty()){
			System.out.println("no user");
			return false;
		}else{
			Professor professor = (Professor)proList.get(0);
			if(professor.getPassword().equals(password)){
				System.out.println(professor.getPassword());
				return true;
			}
				
			else return false;
		}
	}

	public Boolean addProssor(String username, String name, String password,
			String email) {
		// TODO Auto-generated method stub
		if(!professorDAO.findByUsername(username).isEmpty()
				|| !professorDAO.findByEmail(email).isEmpty())
			return false;
		
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

	public Professor getProfessor(String username) {
		// TODO Auto-generated method stub
		List proList = professorDAO.findByUsername(username);
		if(proList.isEmpty())
			return null;
		return (Professor) proList.get(0);
	}

	public List getClasses(int profId) {
		// TODO Auto-generated method stub
		Professor professor = professorDAO.findById(profId);
		Set<Class> set = professor.getClasses();
		List classesList = new ArrayList<Class>();
		System.out.println(set);
		for(Class classes : set){
			classesList.add(classes);
		}
		return classesList;
	}
}
