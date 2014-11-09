package com.group.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.group.datahelper.ClassHelper;
import com.group.model.Class;
import com.group.model.Student;
public class ViewClass extends HttpServlet {
	ClassHelper classHelper = new ClassHelper();
	/**
	 * Constructor of the object.
	 */
	public ViewClass() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int classId = Integer.parseInt(request.getParameter("classId"));
		Class classes = classHelper.getClassByClassId(classId);
		JSONObject object = new JSONObject();
		object.element("classId", classes.getClassId());
		object.element("name", classes.getName());
		JSONArray studentArray = new JSONArray();
		for(Student student : (Set<Student>) classes.getStudents()){
			JSONObject studentJson = new JSONObject();
			studentJson.element("name", student.getName());
			studentJson.element("email", student.getEmail());
			studentArray.add(studentJson);
		}
		object.element("studentArray", studentArray);
		
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		response.getWriter().write(object.toString());
	}
	

}
