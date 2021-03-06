package com.group.datahelper;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.group.DAO.ClassDAO;
import com.group.DAO.ClassStudentRDAO;
import com.group.DAO.DAOManager;
import com.group.DAO.SkillDAO;
import com.group.DAO.StudentDAO;
import com.group.DAO.StudentSkillRDAO;
import com.group.model.ClassStudentR;
import com.group.model.Skill;
import com.group.model.Student;
import com.group.model.StudentSkillR;
import com.group.model.Class;
public class StudentHelper {
	ClassDAO classDAO = DAOManager.getClassDAO();
	StudentDAO studentDAO = DAOManager.getStudentDAO();
	SkillDAO skillDAO = DAOManager.getSkillDAO();
	StudentSkillRDAO relationDAO = DAOManager.getStudentSkillDAO();
	ClassStudentRDAO classStudentRDAO = DAOManager.getClassStudentRDAO();
	public boolean addStudent(int studentId, short gender, Map<Integer, Integer> map) {
		try{
			System.out.println("map.size : " + map.size());
		
			Iterator it = map.entrySet().iterator();
		    while (it.hasNext()) {
		    	StudentSkillR relation = new StudentSkillR();
		        Map.Entry pairs = (Map.Entry)it.next();
		        Student student = studentDAO.findById(studentId);
		        student.setGender(gender);
		        studentDAO.update(student);
		        Skill skill = skillDAO.findById((Integer)pairs.getKey());
		        relation.setScale((Integer) pairs.getValue());
		        relation.setSkill(skill);
		        relation.setStudent(student);
		        relationDAO.save(relation);
		    }
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Student getStudentByEmail(String email) {
		// TODO Auto-generated method stub
		List<Student> studentList = studentDAO.findByEmail(email);
		if(studentList.isEmpty())
			return null;
		
		return studentList.get(0);
	}

	

	public boolean addStudent(List<Student> studentList, int classId) {
		// TODO Auto-generated method stub
		try{
			Class classes = classDAO.findById(classId);
			ClassStudentR relation = new ClassStudentR();
			for(Student student : studentList){
				if(studentDAO.findByEmail(student.getEmail()).isEmpty()){
					studentDAO.save(student);
					
				}else{
					student = (Student) studentDAO.findByEmail(student.getEmail()).get(0);
				}
				
				relation.setClasses(classes);
				relation.setStudent(student);
				
				if(!classStudentRDAO.isExist(relation)){
					classStudentRDAO.save(relation);
				}
				
			}
		}catch(Exception e){
			return false;
		}
		
		return true;
	}



}
