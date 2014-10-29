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

import net.sf.json.JSONObject;

/**
 * Servlet implementation class CreateProject
 */
@WebServlet("/CreateProject")
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
	    int groupSize = Integer.parseInt(request.getParameter("groupSize"));
	    String url =  (String) request.getParameter("url");
	    int algorithm = Integer.parseInt(request.getParameter("algorithm"));
	    int reportType = Integer.parseInt(request.getParameter("reportType"));
	    String studentSkillRs = (String) request.getParameter("studentSkillRs");
	    int id = Integer.parseInt(request.getParameter("id"));

        Boolean flag = classHelper.CreateProject(name, groupSize, url, algorithm, reportType, studentSkillRs, id);
		
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

  