package com.group.datahelper;

import java.util.List;

import com.group.DAO.ClassDAO;
import com.group.DAO.ProjectDAO;
import com.group.DAO.ProjectSkillRDAO;
import com.group.DAO.SkillDAO;
import com.group.model.Project;
import com.group.model.ProjectSkillR;
import com.group.model.Skill;
import com.group.model.Class;
public class ProjectHelper {
	ProjectDAO projectDAO = new ProjectDAO();
	SkillDAO skillDAO = new SkillDAO();
	ProjectSkillRDAO projectSkillDAO = new ProjectSkillRDAO();
	ClassDAO classDAO = new ClassDAO();
	public Project createProject(int professorId, int classId, String domain, String servlet, String name, int groupSize, List<Integer> skillList) {
		// TODO Auto-generated method stub
		Project project = new Project();
		project.setName(name);
		project.setGroupSize(groupSize);
	
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

}
