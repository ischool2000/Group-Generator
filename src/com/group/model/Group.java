package com.group.model;

import java.util.HashSet;
import java.util.Set;


/**
 * Group entity. @author MyEclipse Persistence Tools
 */

public class Group  implements java.io.Serializable {


    // Fields    

     private Integer groupId;
     private Project project;
     private String name;
     private Set groupStudentRs = new HashSet(0);


    // Constructors

    /** default constructor */
    public Group() {
    }

	/** minimal constructor */
    public Group(Integer groupId) {
        this.groupId = groupId;
    }
    
    /** full constructor */
    public Group(Integer groupId, Project project, String name, Set groupStudentRs) {
        this.groupId = groupId;
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
   








}