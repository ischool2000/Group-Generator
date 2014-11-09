package com.group.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.group.datahelper.SkillHelper;

public class AddSkill extends HttpServlet {
	SkillHelper skillHelper = new SkillHelper();
	/**
	 * Constructor of the object.
	 */
	public AddSkill() {
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

		String name = request.getParameter("name");
		int skillId = skillHelper.addSkill(name);
		JSONObject object = new JSONObject();
		if(skillId == -1){
			object.element("flag", false);
		}else{
			object.element("flag", true);
			object.element("skillId", skillId);
		}
		
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		response.getWriter().write(object.toString());
	}

}
