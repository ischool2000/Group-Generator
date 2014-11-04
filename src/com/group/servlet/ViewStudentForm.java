package com.group.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.group.datahelper.ProjectHelper;
import com.group.model.Project;
import com.group.model.ProjectSkillR;
import com.group.model.Skill;

public class ViewStudentForm extends HttpServlet {
	ProjectHelper projectHelper = new ProjectHelper();
	/**
	 * Constructor of the object.
	 */
	public ViewStudentForm() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int professorId = Integer.parseInt(request.getParameter("professorId"));
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		Project project = projectHelper.getProjectById(projectId, professorId);
		if(project == null){
			response.sendRedirect("/Wrongurl.jsp");
		}else{
			//List skillList = new ArrayList();
			
			JSONArray skillArray = new JSONArray();
			Set skillSet = project.getSkills();
			System.out.println(skillSet.size());
			Iterator itr = skillSet.iterator();
			while(itr.hasNext()){
				Skill skill = (Skill) itr.next();
				//skillList.add(skill);
				
				JSONObject skillJson = new JSONObject();
				skillJson.element("id", skill.getSkillId());
				skillJson.element("name", skill.getName());
				skillArray.add(skillJson);
			}
			request.setAttribute("id", project.getProjectId());
			request.setAttribute("name", project.getName());
			request.setAttribute("skillArray", skillArray);
			RequestDispatcher rd=request.getRequestDispatcher("StudentForm.jsp");
			rd.forward(request,response);
			
		}
	}

}
