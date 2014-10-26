package com.group.model;

import java.util.HashSet;
import java.util.Set;


/**
 * Class entity. @author MyEclipse Persistence Tools
 */

public class Class  implements java.io.Serializable {


    // Fields    

     private Integer classId;
     private String name;
     private Set classProjectRs = new HashSet(0);
     private Set professorClassRs = new HashSet(0);
     private Set classStudentRs = new HashSet(0);


    // Constructors

    /** default constructor */
    public Class() {
    }

	/** minimal constructor */
    public Class(Integer classId) {
        this.classId = classId;
    }
    
    /** full constructor */
    public Class(Integer classId, String name, Set classProjectRs, Set professorClassRs, Set classStudentRs) {
        this.classId = classId;
        this.name = name;
        this.classProjectRs = classProjectRs;
        this.professorClassRs = professorClassRs;
        this.classStudentRs = classStudentRs;
    }

   
    // Property accessors

    public Integer getClassId() {
        return this.classId;
    }
    
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set getClassProjectRs() {
        return this.classProjectRs;
    }
    
    public void setClassProjectRs(Set classProjectRs) {
        this.classProjectRs = classProjectRs;
    }

    public Set getProfessorClassRs() {
        return this.professorClassRs;
    }
    
    public void setProfessorClassRs(Set professorClassRs) {
        this.professorClassRs = professorClassRs;
    }

    public Set getClassStudentRs() {
        return this.classStudentRs;
    }
    
    public void setClassStudentRs(Set classStudentRs) {
        this.classStudentRs = classStudentRs;
    }
   








}