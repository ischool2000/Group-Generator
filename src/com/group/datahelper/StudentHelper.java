package com.group.datahelper;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.group.DAO.ClassDAO;
import com.group.DAO.SkillDAO;
import com.group.DAO.StudentDAO;
import com.group.DAO.StudentSkillRDAO;
import com.group.model.Skill;
import com.group.model.Student;
import com.group.model.StudentSkillR;
import com.group.model.Class;
public class StudentHelper {
	ClassDAO classDAO = new ClassDAO();
	StudentDAO studentDAO = new StudentDAO();
	SkillDAO skillDAO = new SkillDAO();
	StudentSkillRDAO relationDAO = new StudentSkillRDAO();
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

	public List createGroup(List<List<Integer>> list) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addStudent(List<Student> studentsList, int classId) {
		// TODO Auto-generated method stub
		Class classes = classDAO.findById(classId);
		return false;
	}



}
