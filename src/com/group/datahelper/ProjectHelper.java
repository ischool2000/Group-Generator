package com.group.datahelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.group.DAO.ClassDAO;
import com.group.DAO.DAOManager;
import com.group.DAO.ProjectDAO;
import com.group.DAO.ProjectSkillRDAO;
import com.group.DAO.SkillDAO;
import com.group.model.Project;
import com.group.model.ProjectSkillR;
import com.group.model.Skill;
import com.group.model.Class;
public class ProjectHelper {
	ProjectDAO projectDAO = DAOManager.getProjectDAO();
	SkillDAO skillDAO = DAOManager.getSkillDAO();
	ProjectSkillRDAO projectSkillDAO = DAOManager.getProjectSkillRDAO();
	ClassDAO classDAO = DAOManager.getClassDAO();
	public Project createProject(int professorId, int classId, int groupNum, String domain, String servlet, String name,  List<Integer> skillList) {
		// TODO Auto-generated method stub
		Project project = new Project();
		project.setName(name);
		project.setGroupNumber(groupNum);
	
		try{
			Class classes = classDAO.findById(classId);
			project.setClasses(classes);
			projectDAO.save(project);
			project.setUrl(domain + servlet + "?professorId=" + professorId + "&projectId="  + project.getProjectId());
			projectDAO.update(project);
			for(int skillId :  skillList){
				Skill skill = skillDAO.findById(skillId);
				ProjectSkillR relation = new ProjectSkillR();
				relation.setProject(project);
				relation.setSkill(skill);
				projectSkillDAO.save(relation);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}		
		return project;
	}
	public Project getProjectById(int projectId, int professorId) {
		// TODO Auto-generated method stub
		Project project = projectDAO.findById(projectId);
		return project;
	}
	
	public List<Integer> getProjectSkillListbyProjectId(int projectId) {
		// TODO Auto-generated method stub
		List<Integer> skillIdList = new ArrayList<Integer>();
		Project project = projectDAO.findById(projectId);
		Set<Skill> set = project.getSkills();
		for(Skill skill : set){
			skillIdList.add(skill.getSkillId());
		}
		return skillIdList;
	}
	public Project getByProjectId(int projectId) {
		// TODO Auto-generated method stub
		Project project = projectDAO.findById(projectId);
		project.getSkills();
		return project;
	}
	public boolean deleteProjectById(int projectId) {
		// TODO Auto-generated method stub
		try{
			  Project project = projectDAO.findById(projectId);
			  System.out.println(project.getProjectId());
			   projectDAO.delete(project);
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	  
		return true;
	}
	public List<Skill> getProjectSkillbyProjectId(int projectId) {
		// TODO Auto-generated method stub
		List<Skill> skillList = new ArrayList<Skill>();
		Project project = projectDAO.findById(projectId);
		Set<Skill> set = project.getSkills();
		for(Skill skill : set){
			skillList.add(skill);
		}
		return skillList;
	}
	public int getClassId(int projectId) {
		// TODO Auto-generated method stub
		Project project = projectDAO.findById(projectId);
		if(project != null){
			return project.getClasses().getClassId();
		}	
		return -1;
	}
	


}
