package com.group.servlet;

import java.io.IOException;
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

import com.group.datahelper.ClassHelper;
import com.group.datahelper.GroupHelper;
import com.group.model.Skill;
import com.group.model.Student;
import com.group.model.Group;

/**
 * Servlet implementation class ViewGroups
 */
@WebServlet("/ViewGroups")
public class ViewGroups extends HttpServlet {
	private static final long serialVersionUID = 1L;
    GroupHelper groupHelper = new GroupHelper();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewGroups() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		HashMap<Group, List<Student>> studentGroupList = groupHelper.getStudentGroupbyProjectId(projectId);
		// TODO Auto-generated method stub
		JSONObject StudentGroupObject = new JSONObject();
        for(Map.Entry<Group, List<Student>> studentEntry : studentGroupList.entrySet()){
        	JSONArray GroupArray = new JSONArray();
            List<Student> Students = studentEntry.getValue();
            for(int j=0; j < Students.size(); j++){
            	JSONObject studentObject = new JSONObject();
    	    	studentObject.element("name", Students.get(j).getName());
    	    	studentObject.element("email", Students.get(j).getEmail());
    	    	studentObject.element("gender", Students.get(j).getGender());
            	GroupArray.add(studentObject);
        	}
            StudentGroupObject.element(studentEntry.getKey().getName(), GroupArray);
        }

        
    	JSONObject object = new JSONObject();
    	object.element("StudentGroup", StudentGroupObject);

		
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
