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
		
		String name = (String) request.getAttribute("username");
		String pwd  = (String) request.getAttribute("password");
		
		Boolean isMatch = professorHelper.isMatch(name, pwd);
		
		JSONObject object = new JSONObject();
		
		if(isMatch){						
			object.element("isMatch", "true");
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
		//Professor professor = professorHelper.getRandomOne();
		
		String name = (String) request.getAttribute("username");
		String pwd  = (String) request.getAttribute("password");
		
		Boolean isMatch = professorHelper.isMatch(name, pwd);
		
		JSONObject object = new JSONObject();
		
		if(isMatch){						
			object.element("isMatch", "true");
		}else{
			object.element("isMatch", "false");
		}
				
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		response.getWriter().write(object.toString());
	}

}