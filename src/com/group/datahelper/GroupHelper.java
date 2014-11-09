package com.group.datahelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.group.DAO.GroupDAO;
import com.group.DAO.GroupStudentRDAO;
import com.group.DAO.ProjectDAO;
import com.group.DAO.StudentDAO;
import com.group.model.Group;
import com.group.model.GroupStudentR;
import com.group.model.Project;
import com.group.model.Student;

public class GroupHelper {

	private GroupDAO groupDAO = new GroupDAO();
	private StudentDAO studentDAO = new StudentDAO();
	private GroupStudentRDAO groupStudentRDAO = new GroupStudentRDAO();
	private ProjectDAO projectDAO = new ProjectDAO();
	public boolean createGroup(List<List<Integer>> list, int projectId) {
		// TODO Auto-generated method stub
		//List<Student> studentList = new ArrayList<Student>();
		int result = groupDAO.deleteByProjectId(projectId);
		System.out.println("result" + result);
		try{
			for(int i = 0;i < list.size();i++){
			
				Group group = new Group();
				group.setName("Group " + (i + 1));
				Project project = projectDAO.findById(projectId);
				group.setProject(project);
				groupDAO.save(group);
				List<Integer> studentIdList = list.get(i);
				for(Integer studentId : studentIdList){
				GroupStudentR relation = new GroupStudentR();
				relation.setGroup(group);
				Student student = studentDAO.findById(studentId);
				//studentList.add(student);
				relation.setStudent(student);
				groupStudentRDAO.save(relation);
				}
			}
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public HashMap<Group, List<Student>> getStudentGroupbyProjectId(
			int projectId) {
		// TODO Auto-generated method stub
		Project project = projectDAO.findById(projectId);
		Set <Group> set = project.getGroups();
		HashMap<Group, List<Student>> map = new HashMap<Group, List<Student>>();
		for(Group group : set){
			Set<Student> studentSet = group.getStudents();
			List<Student> list = new ArrayList();
			
			for(Student student : studentSet){
				list.add(student);
			}
			map.put(group, list);
		}
		return map;
	}
	
}
