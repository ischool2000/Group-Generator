function jumpToCreation(_this){
            var url="projcreation.html?"+"classId="+$(_this).val();
            window.location.href=url;
}

 //this getQueryString() function comes from http://www.cnblogs.com/jiekk/archive/2011/06/28/2092444.html
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) 
        return unescape(r[2]); 
    return null;
        }
        
$(document).ready(function(){
    
    if(document.getElementById("index")){
      $('#submitbutton').bind('click',function(){
        $.ajax({
             type: "GET",
             url: "http://angchen.cu.cc/GroupGen/Login",
             data: {username:$("#username").val(), password:$("#password").val()},
             dataType: "jsonp",
             success: function(data){
                 if(data.isMatch=='true')
                     window.location.href='view.html';
                 else
                     alert("Fail to log in! Please check your username and password.");
                }
            });
        });
    }
    
    if(document.getElementById("ViewClassList")){
        $.ajax({
             type: "GET",
             url: "http://angchen.cu.cc/GroupGen/ViewClassList",
             data: {},
             dataType: "jsonp",
             success: function(data){
                 //alert(data.classArray.length);
                 for(var i=0;i<data.classArray.length;i++){
                    var s='';
                    s+='<div class="col-md-5">';
                    s+='<div class="class-card">';       
                    s+='<input type="hidden" value="'+data.classArray[i].classId+'">';
                    s+='<a class="glyphicon glyphicon-remove-sign deleteClass" "title="Delete this class" href="javascript:void(0)">';
                    s+='</a>';
                    s+='<h5 style="margin-top:-10%;" ><a class="class-name" href="javascript:void(0);">'+data.classArray[i].name;
                    //s+='<a class="viewClass" href="javascript:void(0);">View Class Student</a>';
                    s+='</a></h5>';
                    s+='<ul class="project-list">';
                    for(var j=0;j<data.classArray[i].project.length;j++){
                        s+='<li class="project-name"><a href="viewPro.html?projId='+data.classArray[i].project[j].projectId+'">'+data.classArray[i].project[j].name+'</a>';
                        s+='<input type="hidden" value="'+data.classArray[i].project[j].projectId+'">';
                        s+='<a class="deleteProject" href="javascript:void(0)">delete</a>';
                        s+='</li>';
                    }
                    s+='</ul>';
                    s+='<button id="addProject" value="'+data.classArray[i].classId+'" \n\
                        class="btn btn-success btn-sm" onclick="jumpToCreation(this);">Add project</button>';
                    $(".row").prepend(s);
                }
            }
        });
        $(document).on('mouseenter', '.project-name', function() {
            $(this).find(".deleteProject").show();
        });
        $(document).on('mouseleave', '.project-name', function() {
            $(this).find(".deleteProject").hide();
        });
   
        //alert($(".deleteClass"));
        $(document).on('click','.deleteClass',function(){
            $.ajax({
                type: "GET",
                url: "http://angchen.cu.cc/GroupGen/DeleteClass",
                data: {classId: $(this).prev().val()},
                dataType: "jsonp",
                success: function(data){
                    if(data.flag==true)
                        window.location.reload();
                    else
                        alert("Fail to delete ");
                }
            });
        });
        
        $(document).on('click','.deleteProject',function(){
            $.ajax({
                type: "GET",
                url: "http://angchen.cu.cc/GroupGen/DeleteProject",
                data: {projectId: $(this).prev().val()},
                dataType: "jsonp",
                success: function(data){
                    if(data.flag==true)
                        window.location.reload();
                    else
                        alert("Fail to delete ");
                }
            });
        });
        
        $(document).on("click", ".class-name", function(e) {
            var s="";
            $.ajax({
                type: "GET",
                url: "http://angchen.cu.cc/GroupGen/ViewClass",
                data: {classId: $(this).parent().prev().prev().val()},
                dataType: "jsonp",
                success: function(data){
                    s+='<table class="table table-bordered">';
                    s+='<tr style="font-weight:bold;">';
                    s+='<td>Student Name</td>';
                    s+='<td>Student Email</td>';
                    s+='</tr>';
                    for(var i=0;i<data.studentArray.length;i++){
                        s+='<tr>';
                        s+='<td>'+data.studentArray[i].name+'</td>';
                        s+='<td>'+data.studentArray[i].email+'</td>';
                        s+='</tr>';
                    }
                    s+='</table>';
                    var className=data.name;
                    bootbox.dialog({
                        title: "Class Name: "+className,
                        message: s
                    });
                }
            });   
        });
        
        $(document).on("click", "#btn-addclass", function(e) {
            bootbox.prompt("Enter class name", function(result) {
                if(result!=null){
                    $.ajax({
                        type: "GET",
                        url: "http://angchen.cu.cc/GroupGen/Create_Class",
                        data: {name:result},
                        dataType: "jsonp",
                        success: function(data){
                            if(data.flag==true)
                                location.reload();
                            else
                                alert("Fail to add class");
                       }
                   });
                }
            });
        });
        
    }
     
    if(document.getElementById("projcreation")){
        $("#classId").val(getQueryString("classId"));
        $.ajax({
            type: "GET",
            url: "http://angchen.cu.cc/GroupGen/ViewSkill",
            data: {},
            dataType: "jsonp",
            success: function(data){
                var s="";
                for(var i=0;i<data.skillArray.length;i++){
                    s+='<label class="checkbox-inline">';
                    s+='<input name="skill" value="'+data.skillArray[i].skillId+'"type="checkbox"> '+data.skillArray[i].name;
                    s+='</label>';
                }
                $(".checkbox").prepend(s);
            }
        });
        $("#btn-create-projecta").bind('click',function(){
            window.location.href='view.html';
        });
        $("#btn-create-project").bind('click',function(){
            var id = document.getElementsByName('skill');
            var skillIds = new Array();
            for(var i = 0; i < id.length; i++){
                if(id[i].checked){
                    var myObject=new Object();
                    myObject.skillId=id[i].value;
                    skillIds.push(myObject);
                }
            }
            var myJson=JSON.stringify(skillIds);
            $.ajax({
                type: "GET",
                url: "http://angchen.cu.cc/GroupGen/CreateProject",
                data: {skillArray:myJson, groupNum:$("#groupSize").val(), name:$("#projectName").val()
                       ,classId:parseInt($("#classId").val())},
                dataType: "jsonp",
                success: function(data){
                   //if(data.flag==true)
                        window.location.href='viewPro.html?projId='+data.projectId;
                   //else
                        //alert("Fail to create");
                }
            });
        });

        $(document).on("click", "#addSkill", function(e) {
            bootbox.prompt("Enter skill name", function(result) {
             if(result!=null){
                 var skillName=result;
                  $.ajax({
                    type: "GET",
                    url: "http://angchen.cu.cc/GroupGen/AddSkill",
                    data: {name:skillName},
                    dataType: "jsonp",
                    success: function(data){
                        if(data.flag==true){
                            var s="";
                            s+='<label class="checkbox-inline">';
                            s+='<input name="skill" value="'+data.skillId+'"type="checkbox"> '+data.skillName;
                            s+='</label>';
                            $(".checkbox").append(s);                      
                        }
                        else
                            alert("Fail to add skill");
                    }
                });
            }
            });
        });
    }
    
    if(document.getElementById("viewPro")){
        $("#projId").val(getQueryString("projId"));
        var projId=$("#projId").val();
        $.ajax({
            type: "GET",
            url: "http://angchen.cu.cc/GroupGen/ViewProject",
            data: {projectId:projId},
            dataType: "jsonp",
            success: function(data){
                var s="";
                s='<div class="panel-body">'+data.name+'</div>';
                $("#project-name-panel").append(s);
                s='<div class="panel-body" id="project-url">'+data.url+'</div>';
                $("#project-url-panel").append(s);
                s='<div class="panel-body" id="group-num">'+data.groupNum+'</div>';
                $("#group-num-panel").append(s);
                s='<ul class="skill-list">';
                for(var i=0;i<data.skillArray.length;i++){
                    s+='<li class="skill-item">'+data.skillArray[i].name+'</li>';
                }
                s+='</ul>';
                $("#relevent-skill").append(s);
            }
        });
        
        $("#btn-generatea").bind('click',function(){
            window.location.href='view.html';
        });
        $("#btn-generate").bind('click',function(){
            $.ajax({
                type: "GET",
                url: "http://angchen.cu.cc/GroupGen/CreateGroups",
                data: {projectId:projId, algorithm:$("#algorithm").val(), groupNum:$("#group-num").val(),},
                dataType: "jsonp",
                success: function(data){
                    if(data.flag==true)
                        window.location.reload();
                    else
                        alert("Fail to create!");
                }
            });
        });
        
        $(document).on("click", "#viewGroup", function(e) {
            var s="";
            $.ajax({
                type: "GET",
                url: "http://angchen.cu.cc/GroupGen/ViewGroups",
                data: {projectId:projId},
                dataType: "jsonp",
                success: function(data){
                    if(data.StudentGroup!=null){   
                        s+='<table class="table table-bordered">';
                        s+='<tr style="font-weight:bold;">';
                        s+='<td>Group Number</td>';
                        s+='<td>Student Name</td>';
                        s+='<td>Student Email</td>';
                        s+='<td>Student Gender</td>';
                        s+='</tr>';
                        for(var i=0;i<data.StudentGroup.length;i++){
                            s+='<tr>';
                            s+='<td rowspan="'+data.StudentGroup[i].student.length+'">'+data.StudentGroup[i].name+'</td>';
                            s+='<td>'+data.StudentGroup[i].student[0].name+'</td>';
                            s+='<td>'+data.StudentGroup[i].student[0].email+'</td>';
                            s+='<td>'+data.StudentGroup[i].student[0].gender+'</td>';
                            s+='</tr>';
                            for(var j=1;j<data.StudentGroup[i].student.length;j++){   
                                s+='<tr>';
                                s+='<td>'+data.StudentGroup[i].student[j].name+'</td>';
                                s+='<td>'+data.StudentGroup[i].student[j].email+'</td>';
                                s+='<td>'+data.StudentGroup[i].student[j].gender+'</td>';
                                s+='</tr>';
                            }
                        }
                        s+='</table>'; 
                        bootbox.dialog({
                            title:"Student Group",
                            message: s
                        });
                    }
                }
            });
            /*bootbox.dialog({
                title:"Student Group",
                message: s
            });      */ 
        });
    }
    
    if(document.getElementById("registration")){ 
        function chkEmail(str) {   
            return str.search(/[\w\-]{1,}@[\w\-]{1,}\.[\w\-]{1,}/)==0?true:false 
        } //regular expression comes from http://www.jb51.net/article/19801.htm
        function docheck() 
        {   
            if($("#username").val()=="") { 
                alert("Please Enter Username"); 
                return false; 
            } 
            if($("#password").val()=="") { 
                alert("Please Enter Password"); 
                return false; 
            } 
            if($("#password").val()!= $("#cpassword").val()) { 
                alert("Please Confirm Password"); 
                return false; 
            }   
            if($("#email").val()=="") { 
                alert("Please Enter Email"); 
                return false; 
            } 
            if(!chkEmail($("#email").val())) { 
                alert("Wrong Email Adress"); 
                return false; 
            } 
            return true; 
        } 
        $("#btn-create-accounta").bind('click',function(){
            window.location.href='index.html';
        });
        $("#btn-create-account").bind('click',function(){
            if(docheck()){
                $.ajax({
                    type: "GET",
                    url: "http://angchen.cu.cc/GroupGen/Register",
                    data: {username:$("#username").val(), password:$("#password").val(), email:$("#email").val(),
                           name:$("#name").val()},
                    dataType: "jsonp",
                    success: function(data){
                        //alert(data.classArray.length);
                        if(data.flag==true)
                            window.location.href='refresh.html';
                        else
                            alert("Fail to register.");
                    }
                });
            }
        });
    }
    
    if(document.getElementById("refresh")){
        setTimeout(function(){
            window.location.href='index.html';
        },2000);
    }
    
    $("#logout").bind('click',function(){
        $.ajax({
             type: "GET",
             url: "http://angchen.cu.cc/GroupGen/Logoff",
             data: {},
             dataType: "jsonp",
             success: function(data){
                 if(data.flag==true)
                    window.location.href='index.html';
                 else
                    alert("Fail to log off!");
            }
        });
    });
});

