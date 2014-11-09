package com.group.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.group.datahelper.ClassHelper;

/**
 * Servlet implementation class DeleteClass
 */
@WebServlet("/DeleteClass")
public class DeleteClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ClassHelper classHelper = new ClassHelperHelper();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int classId = Integer.parseInt(request.getParameter("classId")); 
		boolean flag = classHelper.deleteClassById(classId);
		
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
