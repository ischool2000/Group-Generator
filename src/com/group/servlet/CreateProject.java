package com.group.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private static final String servlet = "/ViewStudentForm";
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
		int professorId = (Integer) request.getSession().getAttribute("professorId");
		int classId = Integer.parseInt(request.getParameter("classId"));
		String name = request.getParameter("name");
		int groupSize = Integer.parseInt(request.getParameter("groupSize"));
		String jsonObject = request.getParameter("skillArray");
		
		JSONArray skillArray = new JSONArray();
		skillArray = skillArray.fromObject(jsonObject);
		
		List<Integer> skillList = new ArrayList();
		for(int i = 0;i < skillArray.size();i++){
			JSONObject skillObject = (JSONObject) skillArray.get(i);
			skillList.add(skillObject.getInt("skillId"));
		}
		String domain = request.getServerName() +  ":" + request.getServerPort() + request.getContextPath();
		Project project =  projectHelper.createProject(professorId, classId, domain, servlet, name, groupSize, skillList);
		JSONObject object = new JSONObject();
		if(project == null){
			object.element("flag", "false");
		}else{
			object.element("name", project.getName());
			object.element("url", project.getUrl());
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
  