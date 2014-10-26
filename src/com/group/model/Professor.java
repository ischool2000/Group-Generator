package com.group.model;

import java.util.HashSet;
import java.util.Set;


/**
 * Professor entity. @author MyEclipse Persistence Tools
 */

public class Professor  implements java.io.Serializable {


    // Fields    

     private Integer professorId;
     private String username;
     private String password;
     private String name;
     private String email;
     private Set professorClassRs = new HashSet(0);


    // Constructors

    /** default constructor */
    public Professor() {
    }

	/** minimal constructor */
    public Professor(Integer professorId) {
        this.professorId = professorId;
    }
    
    /** full constructor */
    public Professor(Integer professorId, String username, String password, String name, String email, Set professorClassRs) {
        this.professorId = professorId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.professorClassRs = professorClassRs;
    }

   
    // Property accessors

    public Integer getProfessorId() {
        return this.professorId;
    }
    
    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
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

    public Set getProfessorClassRs() {
        return this.professorClassRs;
    }
    
    public void setProfessorClassRs(Set professorClassRs) {
        this.professorClassRs = professorClassRs;
    }
   








}