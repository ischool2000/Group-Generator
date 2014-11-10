package com.group.datahelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.group.DAO.ClassDAO;
import com.group.model.Professor;
import com.group.model.Class;
import com.group.model.Project;
import com.group.model.Student;
import com.group.model.StudentSkillR;
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
		ArrayList<Integer> studentIdList = new ArrayList();
		Class classes = classDAO.findById(classId);
		Set<Student> set = classes.getStudents();
		for(Student student : set){
			studentIdList.add(student.getStudentId());
		}
		return studentIdList;
	}

	public  List getClasses(int classId) {
		// TODO Auto-generated method stub
		List projectList = new ArrayList();
		Class classes = classDAO.findById(classId);
		Set<Project> set = classes.getProjects();
		for(Project project : set){
			projectList.add(project);
		}
		return projectList;
	}

	public HashMap<Integer, HashMap<Integer, Integer>> getStudentSkillListbyClassId(
			int classId) {
		// TODO Auto-generated method stub
		//HashMap<studentId, HashMap<skillId, scale>>
		ArrayList<Integer> studentIdList = new ArrayList();
		Class classes = classDAO.findById(classId);
		Set<Student> set = classes.getStudents();
		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer, HashMap<Integer, Integer>>();
		
		for(Student student : set){
			HashMap<Integer, Integer> skillMap = new HashMap<Integer, Integer>();
			Set<StudentSkillR> skillR = student.getStudentSkillRs();
			for(StudentSkillR relation : skillR){
				skillMap.put(relation.getSkill().getSkillId(), relation.getScale());
			}
			map.put(student.getStudentId(), skillMap);
		}
		return map;
	}

	public Class getClassByClassId(int classId) {
		// TODO Auto-generated method stub
		Class classes = classDAO.findById(classId);
	
		return classes;
	}

	public ArrayList<Integer> getStudentIdListbyClassIdSortByGender(int classId) {
		// TODO Auto-generated method stub
		
		Class classes = classDAO.findById(classId);
		Set<Student> set = classes.getStudents();
		ArrayList<Integer> studentIdList = new ArrayList();
		ArrayList<Integer> femaleList = new ArrayList();
		for(Student student : set){
			if (student.getGender() == 0){
				studentIdList.add(student.getStudentId());
			}else{
				femaleList.add(student.getStudentId());
			}
			
			for(Integer id : femaleList){
				studentIdList.add(id);
			}
		
		}
		return studentIdList;
		
	}

	public boolean deleteClassById(int classId) {
		// TODO Auto-generated method stub
		try{
			Class classes = classDAO.findById(classId);
			classDAO.delete(classes);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	

	

}
