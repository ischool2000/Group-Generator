package com.group.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group.datahelper.ProjectHelper;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class DeleteProject
 */
@WebServlet("/DeleteProject")
public class DeleteProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProjectHelper projectHelper = new ProjectHelper();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int projectId = Integer.parseInt(request.getParameter("projectId")); 
		boolean flag = projectHelper.deleteProjectById(projectId);
		
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
