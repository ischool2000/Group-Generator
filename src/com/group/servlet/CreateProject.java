package com.group.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.group.datahelper.ProjectHelper;
import com.group.model.Project;
/**
 * Servlet implementation class Register
 */
@WebServlet("/CreateProject")
public class CreateProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProjectHelper projectHelper = new ProjectHelper();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List projectList = projectHelper.getAllProject();
		// TODO Auto-generated method stub
		JSONArray array = new JSONArray();
    	for(int i = 0;i < projectList.size();i++){
    		Project project = (Project) projectList.get(i);
    		JSONObject projectObject = new JSONObject();
    		projectObject.element("name", project.getName());
    		projectObject.element("gender", project.getGender());
    		projectObject.element("email", project.getEmail());
    		array.add(projectObject);
    	}
        

		
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
  