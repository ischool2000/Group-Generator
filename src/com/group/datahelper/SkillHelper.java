package com.group.datahelper;

import java.util.List;

import com.group.DAO.DAOManager;
import com.group.DAO.SkillDAO;
import com.group.model.Skill;

public class SkillHelper {

	private SkillDAO skillDAO = DAOManager.getSkillDAO();
	public List getAllSkill() {
		// TODO Auto-generated method stub
		List skillList = skillDAO.findAll();
		return skillList;
	}
	
	public int addSkill(String name){
		Skill skill = new Skill();
		skill.setName(name);
		List skillList = skillDAO.findByName(name);
		if(skillList.isEmpty()){
			try {
				skillDAO.save(skill);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;
			}
		}else
			return -1;
		
		return skill.getSkillId();
	}
	
}
