package com.group.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group.datahelper.StudentHelper;
import com.group.model.Student;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentHelper studentHelper = new StudentHelper();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentList = (String)request.getParameter("studentList");
		int classId = Integer.parseInt(request.getParameter("classId"));
		
		JSONArray studentArray = new JSONArray();
		studentArray = studentArray.fromObject(studentList);
		List<Student> studentsList = new ArrayList<Student>();

		for(int i = 0; i < studentArray.size(); i++){
			JSONObject studentObject = (JSONObject) studentArray.get(i);
			Student student = new Student();
			student.setEmail(studentObject.getString("email"));
			student.setName(studentObject.getString("name"));
			student.setValidate(studentObject.getString("validate"));
			studentsList.add(student);

		}
		boolean flag = studentHelper.addStudent(studentsList, classId);
		
		JSONObject object = new JSONObject();
		object.element("flag", flag);
		
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		response.getWriter().write(object.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
