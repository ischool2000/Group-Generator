package com.group.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Class entity. @author MyEclipse Persistence Tools
 */

public class Class implements java.io.Serializable {

	// Fields

	private Integer classId;
	private Professor professor;
	private String name;
	private Set classStudentRs = new HashSet(0);
	private Set projects = new HashSet(0);
	private Set students = new HashSet(0);
	// Constructors

	/** default constructor */
	public Class() {
	}

	/** full constructor */
	public Class(Professor professor, String name, Set classStudentRs,
			Set projects) {
		this.professor = professor;
		this.name = name;
		this.classStudentRs = classStudentRs;
		this.projects = projects;
	}

	// Property accessors

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getClassStudentRs() {
		return this.classStudentRs;
	}

	public void setClassStudentRs(Set classStudentRs) {
		this.classStudentRs = classStudentRs;
	}

	public Set getProjects() {
		return this.projects;
	}

	public void setProjects(Set projects) {
		this.projects = projects;
	}

	/**
	 * @return the students
	 */
	public Set getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(Set students) {
		this.students = students;
	}

}