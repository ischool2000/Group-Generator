package com.group.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.group.datahelper.StudentHelper;
import com.group.model.Student;
import com.group.model.ClassStudentR;


/**
 * Servlet implementation class Submission
 */
@WebServlet("/Submission")
public class Submission extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentHelper studentHelper = new StudentHelper();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Submission() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = (String) request.getParameter("name");
		String email  = (String) request.getParameter("email");
		String validate  = (String) request.getParameter("validate");
		Short gender  = Short.parseShort(request.getParameter("gender"));
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		String skillSet = (String)request.getParameter("skillSet");
		JSONArray skillArray = new JSONArray();
		skillArray.fromObject(skillSet);
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		for(int i = 0; i < skillArray.size(); i++){
			JSONObject skillObject = (JSONObject) skillArray.get(i);
			map.put(skillObject.getInt("skillId"), skillObject.getString("scale"));
		}
		
		
		boolean flag = studentHelper.addStudent(name, email, validate, gender, projectId, map); 		
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
