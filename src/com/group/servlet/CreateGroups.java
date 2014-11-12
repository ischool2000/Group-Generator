package com.group.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group.datahelper.ClassHelper;
import com.group.datahelper.GroupHelper;
import com.group.datahelper.ProjectHelper;
import com.group.datahelper.StudentHelper;
import com.group.model.Skill;
import com.group.model.Student;
import com.group.util.gendersort;
import com.group.util.mainsort;
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
    ProjectHelper projectHelper = new ProjectHelper();
    GroupHelper groupHelper = new GroupHelper();
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
		//int classId = Integer.parseInt(request.getParameter("classId"));
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		int classId = projectHelper.getClassId(projectId);
		
		if(algorithm == 1){ //randomsort
			ArrayList<Integer> studentid_list = classHelper.getStudentIdListbyClassId(classId);
			ransort aa = new ransort();
			List<List<Integer>> list = aa.randomsort(studentid_list, groupnum);
			boolean flag = groupHelper.createGroup(list, projectId);
			
			object.element("flag", flag);
			
		}
		else if(algorithm == 2){//sort
			HashMap<Integer, HashMap<Integer, Integer>> StudentSkill = classHelper.getStudentSkillListbyClassId(classId);
			mainsort aa = new mainsort();
			List<Integer> ProjectSkill = projectHelper.getProjectSkillListbyProjectId(projectId);
			List<List<Integer>> list = aa.mainsort(StudentSkill, ProjectSkill, groupnum);
			boolean flag = groupHelper.createGroup(list, projectId);
			
			object.element("flag", flag);
		}
		
		else if(algorithm == 3){//gendersort
			ArrayList<Integer> studentid_list = classHelper.getStudentIdListbyClassIdSortByGender(classId);
			gendersort aa = new gendersort();
			List<List<Integer>> list = aa.gendersort(studentid_list, groupnum);
			boolean flag = groupHelper.createGroup(list, projectId);
			
			object.element("flag", flag);
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
