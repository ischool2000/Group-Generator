package com.group.datahelper;

import java.util.ArrayList;
import java.util.List;

import com.group.DAO.GroupDAO;
import com.group.DAO.GroupStudentRDAO;
import com.group.DAO.StudentDAO;
import com.group.model.Group;
import com.group.model.GroupStudentR;
import com.group.model.Student;

public class GroupHelper {

	private GroupDAO groupDAO = new GroupDAO();
	private StudentDAO studentDAO = new StudentDAO();
	private GroupStudentRDAO groupStudentRDAO = new GroupStudentRDAO();
	public List<Student> createGroup(List<List<Integer>> list) {
		// TODO Auto-generated method stub
		List<Student> studentList = new ArrayList<Student>();
		for(int i = 0;i < list.size();i++){
			Group group = new Group();
			group.setName(String.valueOf(i));
			groupDAO.save(group);
			List<Integer> studentIdList = list.get(i);
			for(Integer studentId : studentIdList){
				GroupStudentR relation = new GroupStudentR();
				relation.setGroup(group);
				Student student = studentDAO.findById(studentId);
				studentList.add(student);
				relation.setStudent(student);
				groupStudentRDAO.save(relation);
			}
		}
		return studentList;
	}
	
}
