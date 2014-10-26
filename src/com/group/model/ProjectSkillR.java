package com.group.model;



/**
 * ProjectSkillR entity. @author MyEclipse Persistence Tools
 */

public class ProjectSkillR  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Skill skill;
     private Project project;


    // Constructors

    /** default constructor */
    public ProjectSkillR() {
    }

	/** minimal constructor */
    public ProjectSkillR(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public ProjectSkillR(Integer id, Skill skill, Project project) {
        this.id = id;
        this.skill = skill;
        this.project = project;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Skill getSkill() {
        return this.skill;
    }
    
    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Project getProject() {
        return this.project;
    }
    
    public void setProject(Project project) {
        this.project = project;
    }
   








}