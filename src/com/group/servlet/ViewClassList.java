package com.group.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.group.datahelper.ClassHelper;
import com.group.datahelper.ProfessorHelper;
import com.group.model.Class;
import com.group.model.Project;
public class ViewClassList extends HttpServlet{
	ProfessorHelper professorHelper = new ProfessorHelper();
	ClassHelper classHelper = new ClassHelper();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int profId = (Integer) request.getSession().getAttribute("professorId");
		List classesList = professorHelper.getClasses(profId);
		
		JSONArray classArray = new JSONArray();
		for(int i = 0;i < classesList.size();i++){
			Class classes = (Class) classesList.get(i);
			JSONObject classJson = new JSONObject();
			List projectList = classHelper.getClasses(classes.getClassId());
			JSONArray projectArray = new JSONArray();
			for(int j = 0;j < projectList.size();j++){
				Project project = (Project) projectList.get(j);
				JSONObject projectJson = new JSONObject();
				projectJson.element("projectId", project.getProjectId());
				projectJson.element("name", project.getName());
				projectArray.add(projectJson);
			}
			classJson.element("classId", classes.getClassId());
			classJson.element("name", classes.getName());
			classJson.element("project", projectArray);
			classArray.add(classJson);
		}

		JSONObject object = new JSONObject();
		object.element("classArray", classArray);
		
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		response.getWriter().write(object.toString());
	}
}
