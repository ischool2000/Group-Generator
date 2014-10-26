package com.group.model;

import java.util.HashSet;
import java.util.Set;


/**
 * Project entity. @author MyEclipse Persistence Tools
 */

public class Project  implements java.io.Serializable {


    // Fields    

     private Integer projectId;
     private String name;
     private Integer groupSize;
     private Integer groupNumber;
     private String url;
     private Integer algorithm;
     private Integer reportType;
     private Set groups = new HashSet(0);
     private Set projectSkillRs = new HashSet(0);
     private Set classProjectRs = new HashSet(0);


    // Constructors

    /** default constructor */
    public Project() {
    }

	/** minimal constructor */
    public Project(Integer projectId) {
        this.projectId = projectId;
    }
    
    /** full constructor */
    public Project(Integer projectId, String name, Integer groupSize, Integer groupNumber, String url, Integer algorithm, Integer reportType, Set groups, Set projectSkillRs, Set classProjectRs) {
        this.projectId = projectId;
        this.name = name;
        this.groupSize = groupSize;
        this.groupNumber = groupNumber;
        this.url = url;
        this.algorithm = algorithm;
        this.reportType = reportType;
        this.groups = groups;
        this.projectSkillRs = projectSkillRs;
        this.classProjectRs = classProjectRs;
    }

   
    // Property accessors

    public Integer getProjectId() {
        return this.projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroupSize() {
        return this.groupSize;
    }
    
    public void setGroupSize(Integer groupSize) {
        this.groupSize = groupSize;
    }

    public Integer getGroupNumber() {
        return this.groupNumber;
    }
    
    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getAlgorithm() {
        return this.algorithm;
    }
    
    public void setAlgorithm(Integer algorithm) {
        this.algorithm = algorithm;
    }

    public Integer getReportType() {
        return this.reportType;
    }
    
    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    public Set getGroups() {
        return this.groups;
    }
    
    public void setGroups(Set groups) {
        this.groups = groups;
    }

    public Set getProjectSkillRs() {
        return this.projectSkillRs;
    }
    
    public void setProjectSkillRs(Set projectSkillRs) {
        this.projectSkillRs = projectSkillRs;
    }

    public Set getClassProjectRs() {
        return this.classProjectRs;
    }
    
    public void setClassProjectRs(Set classProjectRs) {
        this.classProjectRs = classProjectRs;
    }
   








}