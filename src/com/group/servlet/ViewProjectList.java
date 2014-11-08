package com.group.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.group.datahelper.ClassHelper;
import com.group.model.Class;
import com.group.model.Project;

public class ViewProjectList extends HttpServlet {
	ClassHelper classHelper = new ClassHelper();
	/**
	 * Constructor of the object.
	 */
	public ViewProjectList() {
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
		List projectList = classHelper.getClasses(classId);
		
		JSONArray projectArray = new JSONArray();
		for(int i = 0;i < projectList.size();i++){
			Project project = (Project) projectList.get(i);
			JSONObject projectJson = new JSONObject();
			projectJson.element("projectId", project.getProjectId());
			projectJson.element("name", project.getName());
			projectArray.add(projectJson);
		}
		JSONObject object = new JSONObject();
		object.element("projectArray", projectArray);
		
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		response.getWriter().write(object.toString());
	}

}
