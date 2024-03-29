<%@ page import="/shixun_beifen_day19_origin/src/main/java/com/chinasoft/pojo/Course.java" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8" />
    <title>已开设课程 - 学生选课系统</title>
    <link rel="icon" href="../../static/img/title.png"/>
    <link rel="stylesheet" type="text/css" href="../../static/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="../../static/css/index.css"/>
    <script type="text/javascript" src="../../static/jquery/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="../../static/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="../../static/js/style/dialog.js"></script>
    <script type="text/javascript" src="../../static/js/ajax/student.js"></script>
    <script th:inline="javascript" type="text/javascript" src="../../static/js/style/student/menu.js"></script>
    <script th:inline="javascript" type="text/javascript" src="../../static/js/style/student/select.js"></script>
</head>
<body>
<!-- 加载菜单栏部分 -->
<div th:replace="student/menu/menu :: header"></div>
<!-- 右侧部分 -->
<div class="course-right">
    <!-- 加载用户栏 -->
    <div th:replace="student/menu/user :: header"></div>
    <!-- 界面显示栏 -->
    <div class="course-show">
        <div class="course-show-title">
            <span name="select">
                <span class="glyphicon glyphicon glyphicon-check"></span>
                &nbsp;&nbsp;已选课程
            </span>
        </div>
        <div name="fragment">
            <table class="table table-bordered table-hover table-striped" style="color: #8692a1;">
                <thead>
                <tr>
                    <th>课程编号</th>
                    <th>课程名</th>
                    <th>上课地点</th>
                    <th>上课时间</th>
                    <th>学分</th>
                    <th>积分</th>
                    <th>操作</th>
                </tr>
                </thead>
                
                
                <tbody>
                    <c:forEach  items="${findAllCourse}"  var="course01"  > 
                        <tr>
                               
                            <td>${course01.c_id}</td>
                            <td>${course01.c_name}</td>
                            <td>${course01.c_room}</td>
                            <td>${course01.c_time}</td>
                            <td>${course01.c_point}</td>
                            <td>${course01.t_id}</td>      
                        </tr>
                </tbody>
                
            </table>
        </div>
    </div>
</div>

</body>
</html>