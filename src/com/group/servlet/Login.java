package com.group.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.group.datahelper.ProfessorHelper;
import com.group.model.Professor;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProfessorHelper professorHelper = new ProfessorHelper();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = (String) request.getParameter("username");
		String pwd  = (String) request.getParameter("password");
		
		Professor professor = professorHelper.getProfessor(name);
		JSONObject object = new JSONObject();
		if(professor != null){
			
			Boolean isMatch = professor.getPassword().equals(pwd);
			if(isMatch){
				request.getSession().setAttribute("professorId", professor.getProfessorId());	
				object.element("isMatch", "true");
				object.element("name", professor.getName());
			}else{
				object.element("isMatch", "false");
			}
		}else{
			object.element("isMatch", "false");
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
		
		
		String name = (String) request.getParameter("username");
		String pwd  = (String) request.getParameter("password");
		
		Professor professor = professorHelper.getProfessor(name);
		
		Boolean isMatch = professor.getPassword().equals(pwd);
		
		JSONObject object = new JSONObject();
		if(isMatch){
			request.getSession().setAttribute("professorId", professor.getProfessorId());
			request.getSession().setAttribute("name", professor.getName());	
			object.element("isMatch", true);
		}else{
			object.element("isMatch", false);
		}
		
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		response.getWriter().write(object.toString());
	}

}
