<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8" />
    <title>首页 - 学生选课系统</title>
    <link rel="icon" href="img/title.png"/>
    <link rel="stylesheet" type="text/css" href="../../static/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="../../static/css/index.css"/>
    <script type="text/javascript" src="../../static/jquery/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="../../static/bootstrap/js/bootstrap.js"></script>
    <script th:inline="javascript" type="text/javascript" src="../../static/js/style/student/menu.js"></script>
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
                <span class="glyphicon glyphicon glyphicon-home"></span>&nbsp;&nbsp;首页
            </span>
        </div>
        <div name="fragment">
            <div class="course-userInfo">
                <table class="table">
                    <thead class="">
                        <tr>
                            <th>个人信息</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>老师工号：${teacher.t_id}
                            </td>
                        </tr>
                        <tr>
                            <td>老师姓名：${teacher.t_name}
                            </td>
                        </tr>
                        <tr>
                            <td>老师性别：${teacher.t_sex}
                            </td>
                        </tr>
                        <tr>
                            <td>老师所属专业：${teacher.t_major}
                            </td>
                        </tr>
                        
                    </tbody>
                </table>
            </div>
            <div class="course-indexInfo">
                <div class="course-indexInfo-title">
                    <img src="../../static/img/title2.png" width="20" height="20"/>&nbsp;&nbsp;选课说明:
                </div>
                <ul>
                    <li>开设课程中可以开设课程</li>
                    <li>在选课中心进行对学生选择课程的成绩录入</li>
                    <li>点击已选课程能查看所选课程以及退课操作</li>
                  
                </ul>
            </div>
            <div class="course-indexInfo">
                <div class="course-indexInfo-title">
                    <img src="../../static/img/title3.png" width="20" height="20"/>&nbsp;&nbsp;选课开发情况:
                </div>
                <table class="table table-bordered">
                    <tr>
                        <td>选课模式：正选</td>
                        <td>选课策略：可选可退</td>
                    </tr>
                    <tr>
                        <td>开始时间：2022/8/10</td>
                        <td>结束时间：2022/8/24</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>