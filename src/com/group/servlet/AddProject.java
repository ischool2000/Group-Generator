package com.group.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.group.datahelper.SkillHelper;
import com.group.model.Skill;
/**
 * Servlet implementation class AddProject
 */
@WebServlet("/AddProject")
public class AddProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SkillHelper skillHelper = new SkillHelper();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List skillList = skillHelper.getAllSkill();
		// TODO Auto-generated method stub
		JSONArray skillArray = new JSONArray();
    	for(int i = 0;i < skillList.size();i++){
    		Skill skill = (Skill) skillList.get(i);
    		JSONObject skillObject = new JSONObject();
    		skillObject.element("skillId", skill.getSkillId());
    		skillObject.element("name", skill.getName());
    		skillArray.add(skillObject);
    	}
        
    	/*JSONArray itemArray = new JSONArray();
		JSONObject itemObject = new JSONObject();
		
		itemObject.element("item", "name");
		itemArray.add(itemObject);
		itemObject = new JSONObject();
		itemObject.element("item", "gender");
		itemArray.add(itemObject);
		itemObject = new JSONObject();
		itemObject.element("item", "email");
		itemArray.add(itemObject);

		JSONObject object = new JSONObject();
		object.element("skillArray", skillArray);
		object.element("itemArray", itemArray);*/
		
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		response.getWriter().write(skillArray.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

  