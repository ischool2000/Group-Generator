package com.group.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Skill entity. @author MyEclipse Persistence Tools
 */

public class Skill implements java.io.Serializable {

	// Fields

	private Integer skillId;
	private String name;
	private Set studentSkillRs = new HashSet(0);
	private Set projectSkillRs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Skill() {
	}

	/** full constructor */
	public Skill(String name, Set studentSkillRs, Set projectSkillRs) {
		this.name = name;
		this.studentSkillRs = studentSkillRs;
		this.projectSkillRs = projectSkillRs;
	}

	// Property accessors

	public Integer getSkillId() {
		return this.skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getStudentSkillRs() {
		return this.studentSkillRs;
	}

	public void setStudentSkillRs(Set studentSkillRs) {
		this.studentSkillRs = studentSkillRs;
	}

	public Set getProjectSkillRs() {
		return this.projectSkillRs;
	}

	public void setProjectSkillRs(Set projectSkillRs) {
		this.projectSkillRs = projectSkillRs;
	}

}