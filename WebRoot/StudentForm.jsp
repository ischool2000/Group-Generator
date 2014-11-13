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

     <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="style.css" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

    <script src="bootstrap/js/bootstrap.min.js"></script>

    <script src="bootstrap/js/bootbox.min.js"></script>

    <script src="bootstrap/js/script.js"></script>

    <script type="text/javascript"> 
    $(document).ready(function(){
    	
    

     var skillArray = <%=request.getAttribute("skillArray")%>;

     var name = '<%=request.getAttribute("name")%>';

     var ID = <%=request.getAttribute("id")%>;

     var s="";

     for(var i=0;i<skillArray.length;i++){

         s+='<p class="relevent-skill">';

         s+='<input name="skills" type="checkbox" value="'+skillArray[i].id+'" />'+skillArray[i].name;

         s+='<span style="float:right">';

         s+='<input type="radio" name="'+skillArray[i].id+'Proficiency" value="1" />&nbsp;&nbsp;High&nbsp;&nbsp;';

         s+='<input type="radio" name="'+skillArray[i].id+'Proficiency" value="2" />&nbsp;&nbsp;Medium&nbsp;&nbsp;';

         s+='<input type="radio" name="'+skillArray[i].id+'Proficiency" value="3" />&nbsp;&nbsp;Low&nbsp;&nbsp;';

         s+='</span>';

         s+='</p>';

     }
     
     $(".checkbox").append(s);
     

     $(document).on('click',"#btn-submit-profile",function(){

        var id = document.getElementsByName('skills');

            var skills = new Array();

            for(var i = 0; i < id.length; i++){

                if(id[i].checked){

                    var myObject=new Object();

                    myObject.skillId=id[i].value;

                    myObject.scale=$("input[name='"+id[i].value+"Proficiency']:checked").val();

                    skills.push(myObject);

                }

            }

        var myJson=JSON.stringify(skills);

         $.ajax({

            type: "GET",

            url: "http://angchen.cu.cc/GroupGen/Submission",

            data: {name:$("#student-name-input").val(), email:$("#email-input").val(),

                   validate:$("#validate-input").val(), gender:$("input[name='gender']:checked").val(),

                   projectId:ID, skillSet:myJson},

            dataType: "jsonp",

            success: function(data){

            }

        });

     });
    });




    

     </script>

  </head>

  

  <body>

    <div style="display:none;" id="show"></div>

   

    <nav class="navbar navbar-default" role="navigation" style = "background-color:#428BCA;margin:-3px -3px -3px -3px;">

        <div class="container-fluid">

            <p class="navbar-text" style="color:white;"><strong>Group Generator</strong></p>

        </div>

    </nav>





<!-- Middle content section -->

<div class="container-fluid">

    <h4 class="page-title"><%=request.getAttribute("name")%></h4>

</div>





<div class="container">

<div  class = "form-style">

    <input id="projId" type="hidden" value="<%=request.getAttribute("id")%>"/>

    <div class="form-group form-item">

      <label >Name:</label>

      <input id="student-name-input" type="text" class="form-control" placeholder="Your name">

    </div>

<!--end the project name input -->

    <div class="form-group form-item">

      <label >Email:</label>

      <input id="email-input" type="email" class="form-control" placeholder="E-mail adress">

    </div>

    <div class="form-group form-item">

      <label >Validate:</label>

      <input id="validate-input" type="text" class="form-control" placeholder="Validation">

    </div>

    <div class="form-group form-item">

      <label >Gender:</label>

      <p>

          <input type="radio" name="gender" value="0" />&nbsp;&nbsp; Male

      <input style="margin-left: 5%" type="radio" name="gender" value="1" />&nbsp;&nbsp; Female

      </p>

    </div>



    <div class="form-group form-item">

      <label>Your skills:</label>

        <div class="checkbox" style="margin-left:10%">
        </div>

    </div>



    <button class="btn btn-success btn-lg" id="btn-submit-profile">Join!</button>

</div>

</div>

  </body>

</html>
