package com.group.DAO;

public class DAOManager {
	private static ClassDAO classDAO;
	private static ClassStudentRDAO classStudentRDAO;
	private static GroupDAO groupDAO;
	private static GroupStudentRDAO groupStudentRDAO;
	private static ProfessorDAO professorDAO;
	private static ProjectDAO projectDAO;
	private static ProjectSkillRDAO projectSkillRDAO;
	private static SkillDAO skillDAO;
	private static StudentDAO studentDAO;
	private static StudentSkillRDAO studentSkillRDAO;
	public static ClassDAO getClassDAO() {
		if(classDAO == null)
			classDAO = new ClassDAO();
		return classDAO;
	}
	public static ClassStudentRDAO getClassStudentRDAO() {
		if(classStudentRDAO == null)
			classStudentRDAO = new ClassStudentRDAO();
		return classStudentRDAO;
	}
	public static GroupDAO getGroupDAO() {
		if(groupDAO == null)
			groupDAO = new GroupDAO();
		return groupDAO;
	}
	public static GroupStudentRDAO getGroupStudentRDAO() {
		if(groupStudentRDAO == null)
			groupStudentRDAO = new GroupStudentRDAO();
		return groupStudentRDAO;
	}
	public static ProfessorDAO getProfessorDAO() {
		if(professorDAO == null)
			professorDAO = new ProfessorDAO();
		return professorDAO;
	}
	public static ProjectDAO getProjectDAO() {
		if(projectDAO == null)
			projectDAO = new ProjectDAO();
		return projectDAO;
	}
	public static ProjectSkillRDAO getProjectSkillRDAO() {
		if(projectSkillRDAO == null)
			projectSkillRDAO = new ProjectSkillRDAO();
		return projectSkillRDAO;
	}
	public static SkillDAO getSkillDAO() {
		if(skillDAO == null)
			skillDAO = new SkillDAO();
		return skillDAO;
	}
	public static StudentDAO getStudentDAO() {
		if(studentDAO == null)
			studentDAO = new StudentDAO();
		return studentDAO;
	}
	public static StudentSkillRDAO getStudentSkillDAO() {
		if(studentSkillRDAO == null)
			studentSkillRDAO = new StudentSkillRDAO();
		return studentSkillRDAO;
	}
}
