package com.group.datahelper;

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
	public Boolean createProject(int projectId, String name, int groupSize,
			int groupNumber, String url, int algorithm, int reportType) {
		// TODO Auto-generated method stub
		Project project = new Project();
		project.setName(name);
		project.setGroupNumber(groupNumber);
		project.setUrl(url);
		project.setAlgorithm(algorithm);
		project.setReportType(reportType);
		return true;
	}

}
