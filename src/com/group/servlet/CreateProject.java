package com.group.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class CreateProject
 */
@WebServlet("/CreateProject")
public class CreateProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		int projectId = (Integer) request.getAttribute("projectId");
		String name = (String) request.getAttribute("name");
	    int groupSize = (Integer) request.getAttribute("groupSize");
	    int groupNumber = (Integer) request.getAttribute("groupNumber");
	    String url =  (String) request.getAttribute("url");
	    int algorithm = (Integer) request.getAttribute("algorithm");
	    int reportType = (Integer) request.getAttribute("reportType");

        Boolean flag = classHelper.createClass(projectId,name, groupSize, groupNumber, url, algorithm, reportType);
		
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

  