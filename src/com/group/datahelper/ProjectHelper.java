package com.group.datahelper;

import java.util.List;

import com.group.DAO.ProjectSkillRDAO;
import com.group.DAO.SkillDAO;
import com.group.model.Project;
import com.group.model.ProjectSkillR;
import com.group.model.Skill;

public class ProjectHelper {

	SkillDAO skillDAO = new SkillDAO();
	ProjectSkillRDAO projectSkillDAO = new ProjectSkillRDAO();
	public boolean createProject(String name, int groupSize, List<Integer> skillList) {
		// TODO Auto-generated method stub
		Project project = new Project();
		project.setName(name);
		project.setGroupSize(groupSize);
		
		for(int skillId :  skillList){
			Skill skill = skillDAO.findById(skillId);
			ProjectSkillR relation = new ProjectSkillR();
			relation.setProject(project);
			relation.setSkill(skill);
			try {
				projectSkillDAO.save(relation);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
				
			}
		}		
		
		return true;
	}

}
