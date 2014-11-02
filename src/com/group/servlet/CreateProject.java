package com.group.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group.datahelper.ClassHelper;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class CreateProject
 */
@WebServlet("/Create_Project")
public class CreateProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static ClassHelper classHelper = new ClassHelper();   
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
    	String name = (String) request.getParameter("name");
    	int skillId= (Integer) request.getSession().getAttribute("skillId");
        
        Boolean flag = classHelper.createProject(name, skillId);
		
		JSONArray array = new JSONArray();
		array.add(value);
		
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		response.getWriter().write(array.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

  