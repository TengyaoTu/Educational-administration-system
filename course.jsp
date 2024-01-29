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
        <tr>
            <td>课程编号</td>
            <td>课程名称</td>
            <td>上课教室</td>
            <td>上课时间</td>
            <td>课程学分</td>
            <td>任课教师ID</td>
        </tr>
     

       <c:forEach  items="${findAllCourse}"  var="course01"  > 
        <tr>
               
            <td>${course01.c_id}</td>
            <td>${course01.c_name}</td>
            <td>${course01.c_room}</td>
            <td>${course01.c_time}</td>
            <td>${course01.c_point}</td>
            <td>${course01.t_id}</td>  
            <td>
                <a href="http://localhost:8080/deleteCourse?id=${course01.c_id}">
               <button type="button" class="btn btn-warning">中止该课程</button>
            </a>
            </td>    
        </tr>
    
    
        </c:forEach>
    </table>
   

    
    
</body>
</html>