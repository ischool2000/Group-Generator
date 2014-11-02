package com.group.datahelper;

import java.util.List;

import com.group.DAO.SkillDAO;

public class SkillHelper {

	private SkillDAO skillDAO = new SkillDAO();
	public List getAllSkill() {
		// TODO Auto-generated method stub
		List skillList = skillDAO.findAll();
		return skillList;
	}
	
	
}
