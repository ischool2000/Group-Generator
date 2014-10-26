package com.group.model;



/**
 * GroupStudentR entity. @author MyEclipse Persistence Tools
 */

public class GroupStudentR  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Student student;
     private Group group;


    // Constructors

    /** default constructor */
    public GroupStudentR() {
    }

	/** minimal constructor */
    public GroupStudentR(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public GroupStudentR(Integer id, Student student, Group group) {
        this.id = id;
        this.student = student;
        this.group = group;
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

    public Group getGroup() {
        return this.group;
    }
    
    public void setGroup(Group group) {
        this.group = group;
    }
   








}