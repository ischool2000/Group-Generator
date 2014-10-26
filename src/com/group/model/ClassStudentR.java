package com.group.model;



/**
 * ClassStudentR entity. @author MyEclipse Persistence Tools
 */

public class ClassStudentR  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Student student;
     private Class classes;


    // Constructors

    /** default constructor */
    public ClassStudentR() {
    }

	/** minimal constructor */
    public ClassStudentR(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public ClassStudentR(Integer id, Student student, Class classes) {
        this.id = id;
        this.student = student;
        this.classes = classes;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }

    public Class getClasses() {
        return this.classes;
    }
    
    public void setClasses(Class classes) {
        this.classes = classes;
    }
   








}