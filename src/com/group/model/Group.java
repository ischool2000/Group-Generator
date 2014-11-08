package com.group.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Group entity. @author MyEclipse Persistence Tools
 */

public class Group implements java.io.Serializable {

	// Fields

	private Integer groupId;
	private Project project;
	private String name;
	private Set groupStudentRs = new HashSet(0);
	private Set students = new HashSet(0);
	// Constructors

	/** default constructor */
	public Group() {
	}

	/** full constructor */
	public Group(Project project, String name, Set groupStudentRs) {
		this.project = project;
		this.name = name;
		this.groupStudentRs = groupStudentRs;
	}

	// Property accessors

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getGroupStudentRs() {
		return this.groupStudentRs;
	}

	public void setGroupStudentRs(Set groupStudentRs) {
		this.groupStudentRs = groupStudentRs;
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