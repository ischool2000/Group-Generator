package com.group.model;



/**
 * ClassProjectR entity. @author MyEclipse Persistence Tools
 */

public class ClassProjectR  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Class classes;
     private Project project;


    // Constructors

    /** default constructor */
    public ClassProjectR() {
    }

	/** minimal constructor */
    public ClassProjectR(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public ClassProjectR(Integer id, Class classes, Project project) {
        this.id = id;
        this.classes = classes;
        this.project = project;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Class getClasses() {
        return this.classes;
    }
    
    public void setClasses(Class classes) {
        this.classes = classes;
    }

    public Project getProject() {
        return this.project;
    }
    
    public void setProject(Project project) {
        this.project = project;
    }
   








}