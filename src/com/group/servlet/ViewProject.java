package com.group.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.group.datahelper.ProjectHelper;
import com.group.model.Project;

public class ViewProject extends HttpServlet {
	ProjectHelper projectHelper = new ProjectHelper();
	/**
	 * Constructor of the object.
	 */
	public ViewProject() {
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

		int projectId = Integer.parseInt(request.getParameter("projectId"));
		Project project = projectHelper.getByProjectId(projectId);
		JSONObject projectJson = new JSONObject();
		projectJson.element("projectId", project.getProjectId());
		projectJson.element("name", project.getName());
		projectJson.element("groupSize", project.getGroupSize());
		projectJson.element("algorithm", project.getAlgorithm());
		
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		response.getWriter().write(projectJson.toString());
	}

}
