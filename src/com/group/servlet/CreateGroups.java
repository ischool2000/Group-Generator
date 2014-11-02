package com.group.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group.datahelper.ClassHelper;
import com.group.datahelper.StudentHelper;
import com.group.model.Skill;
import com.group.model.Student;
import com.group.util.ransort;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class CreateGroups
 */
@WebServlet("/CreateGroups")
public class CreateGroups extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ClassHelper classHelper = new ClassHelper();
    StudentHelper studentHelper = new StudentHelper();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateGroups() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject object = new JSONObject();
		int algorithm = Integer.parseInt(request.getParameter("algorithm"));
		int groupnum = Integer.parseInt(request.getParameter("groupnum"));
		String skillSet = (String)request.getParameter("skillSet");
		int classId = Integer.parseInt(request.getParameter("classId"));

		if(algorithm == 1){ //randomsort
			ArrayList<Integer> studentid_list = classHelper.getStudentIdListbyClassId(classId);
			ransort aa = new ransort();
			List<List<Integer>> list = aa.randomsort(studentid_list, groupnum);
			List studentList = studentHelper.getStudentbyGroupList(list);
			JSONArray studentArray = new JSONArray();
	    	for(int i = 0;i < studentList.size();i++){
	    		Student student = (Student) studentList.get(i);
	    		JSONObject studentObject = new JSONObject();
	    		studentObject.element("name", student.getName());
	    		studentObject.element("email", student.getEmail());
	    		studentArray.add(studentObject);
	    	}
			
			object.element("studentArray", studentArray);
			
		}
		else if(algorithm == 2){//sort
			JSONArray skillArray = new JSONArray();
			skillArray.fromObject(skillSet);
			List<Integer> ProjectSkill = new ArrayList<Integer>();
			for(int i = 0; i < skillArray.size(); i++){
				JSONObject skillObject = (JSONObject) skillArray.get(i);
				ProjectSkill.add(skillObject.getInt("skillId"));
			}
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
