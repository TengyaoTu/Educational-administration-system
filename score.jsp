 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8" />
    <title>首页 - 选课系统</title>
    <link rel="icon" href="img/title.png"/>
    <link rel="stylesheet" type="text/css" href="../../static/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="../../static/css/index.css"/>
    <script type="text/javascript" src="../../static/jquery/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="../../static/bootstrap/js/bootstrap.js"></script>
    <script th:inline="javascript" type="text/javascript" src="../../static/js/style/student/menu.js"></script>
</head>
<body>
    <table class="table table-hover">
        
        <table class="table table-hover">
            <tr>
                <td>学生编号</td>
                <td>课程编号</td>
                <td>学生分数</td>
                <td>任课老师ID</td>
                <td>赋分</td>
            </tr>
            <c:forEach  items="${teacherfindAllSelect}"  var="course01"  > 
              <form action="../../../updateScore">  
                <tr>
                       
                    <td> <input value="${course01.s_id}"name="s_id"> </input></td>
                    <td>${course01.c_id}</td>
                    <td>${course01.s_point}</td>
                    <td>${course01.t_id}</td>
                    <td> <input value=" "name="point"> </input></td>
                   
                    <td>
                        <button  type="submit">上传分数</button>
                    </a>
                    </td>    
                </tr>
            
            </form>
             </c:forEach>
        
        
   
       
    </table>
   

    
    
</body>
</html>