package com.group.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer studentId;
	private String name;
	private String email;
	private String validate;
	private Short gender;
	private Set classStudentRs = new HashSet(0);
	private Set studentSkillRs = new HashSet(0);
	private Set groupStudentRs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(String name, String email, String validate, Short gender,
			Set classStudentRs, Set studentSkillRs, Set groupStudentRs) {
		this.name = name;
		this.email = email;
		this.validate = validate;
		this.gender = gender;
		this.classStudentRs = classStudentRs;
		this.studentSkillRs = studentSkillRs;
		this.groupStudentRs = groupStudentRs;
	}

	// Property accessors

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getValidate() {
		return this.validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	public Short getGender() {
		return this.gender;
	}

	public void setGender(Short gender) {
		this.gender = gender;
	}

	public Set getClassStudentRs() {
		return this.classStudentRs;
	}

	public void setClassStudentRs(Set classStudentRs) {
		this.classStudentRs = classStudentRs;
	}

	public Set getStudentSkillRs() {
		return this.studentSkillRs;
	}

	public void setStudentSkillRs(Set studentSkillRs) {
		this.studentSkillRs = studentSkillRs;
	}

	public Set getGroupStudentRs() {
		return this.groupStudentRs;
	}

	public void setGroupStudentRs(Set groupStudentRs) {
		this.groupStudentRs = groupStudentRs;
	}

}