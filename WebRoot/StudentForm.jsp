<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'StudentForm.jsp' starting page</title>
    
<script type="text/javascript">
 var skillArray = '<%=request.getSession().getAttribute("skillArray")%>' ;
 var name ='<%=request.getSession().getAttribute("name")%>';
 var id = '<%=request.getSession().getAttribute("id")%>';
 
 // Just show the text, you can delete it at any time
 window.onload = function() {
	 document.getElementById("show").innerHTML = id + " " + name + " " + skillArray + " ";
	}

 </script>
  </head>
  
  <body>
   <div id="show">?
   </div> <br>
  </body>
</html>
