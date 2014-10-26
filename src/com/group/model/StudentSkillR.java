package com.group.model;



/**
 * StudentSkillR entity. @author MyEclipse Persistence Tools
 */

public class StudentSkillR  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Skill skill;
     private Student student;
     private Integer scale;


    // Constructors

    /** default constructor */
    public StudentSkillR() {
    }

	/** minimal constructor */
    public StudentSkillR(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public StudentSkillR(Integer id, Skill skill, Student student, Integer scale) {
        this.id = id;
        this.skill = skill;
        this.student = student;
        this.scale = scale;
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

    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getScale() {
        return this.scale;
    }
    
    public void setScale(Integer scale) {
        this.scale = scale;
    }
   








}