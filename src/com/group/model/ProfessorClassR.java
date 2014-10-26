package com.group.model;



/**
 * ProfessorClassR entity. @author MyEclipse Persistence Tools
 */

public class ProfessorClassR  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Professor professor;
     private Class classes;


    // Constructors

    /** default constructor */
    public ProfessorClassR() {
    }

	/** minimal constructor */
    public ProfessorClassR(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public ProfessorClassR(Integer id, Professor professor, Class classes) {
        this.id = id;
        this.professor = professor;
        this.classes = classes;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Professor getProfessor() {
        return this.professor;
    }
    
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Class getClasses() {
        return this.classes;
    }
    
    public void setClasses(Class classes) {
        this.classes = classes;
    }
   








}