<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
		<title>修改密码</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
		<script type="text/javascript" src="./js/gong.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.bundle.min.js"></script>
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
            
        </div>
        <!-- 引入其他页面 -->
        <div name="fragment">
            <form class="form-group"  th:fragment="info" action="changeunipassword">
            	
            	<!--<div class="form-inline">
                    <label>请输入起始密码：</label>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="text" class="form-control" name="password_old" th:value="${session.student.getS_password()}"/>
                </div>-->
                <div class="form-floating mb-3 mt-3">
                    
                    <input type="text" class="form-control" placeholder="请输入新密码" id="password" name="unipassword" th:value="${session.student.getS_password()}"/>
                    <label for="email">请输入新密码</label>
                </div>
                 <td><input   disabled="disabled">
                <input type="hidden" value=${student.id}  name="id" >
                
                
                </input></td>
                
                <div class="form-floating mb-3 mt-3">
                    
                    <input type="text" class="form-control" placeholder="请输入新密码" id="password_2">
                    <label for="email">请确认新密码</label>
                </div>
               <p id="msg_pwd" style="margin-left: 5px"></p>
                <div style="text-align:center">
					<button type="submit" class="btn btn-primary mt-3" style="text-align: center;"
						id="btn_register">提交</button>
				</div>
                
            </form>
        </div>
    </div>
</div>

<script>
	// 如果验证不通过禁止提交表单
(function() {
	'use strict';
	window.addEventListener('load', function() {
		// 获取表单验证样式
		var forms = document.getElementsByClassName('needs-validation');
		// 循环并禁止提交
		var validation = Array.prototype.filter.call(forms, function(form) {
			form.addEventListener('submit', function(event) {
				if (form.checkValidity() === false) {
					event.preventDefault();
					event.stopPropagation();
				}
				form.classList.add('was-validated');
			}, false);
		});
	}, false);
})();

$(document).ready(function() {
	$('#password').on('input propertychange', function() {
		//input propertychange即实时监控键盘输入包括粘贴
		var pwd = $.trim($(this).val());
		//获取this，即ipwd的val()值，trim函数的作用是去除空格
		var rpwd = $.trim($("#password_2").val());
		if (rpwd != "") {
			if (pwd == "" && rpwd == "") {
				//若都为空，则提示密码不能为空，为了用户体验（在界面上用required同时做了处理）
				$("#msg_pwd").html("<font color='red'>密码不能为空</font>");
			} else {
				if (pwd == rpwd) { //相同则提示密码匹配
					$("#msg_pwd").html("<font color='green'>两次密码匹配通过</font>");
					$("#btn_register").attr("disabled", false); //使按钮无法点击
				} else { //不相同则提示密码匹配
					$("#msg_pwd").html("<font color='red'>两次密码不匹配</font>");
					$("#btn_register").attr("disabled", true);
				}
			}
		}
	})
})

//由于是两个输入框，所以进行两个输入框的几乎相同的判断
$(document).ready(function() {
	$('#password_2').on('input propertychange', function() {
		var pwd = $.trim($(this).val());
		var rpwd = $.trim($("#password").val());
		if (pwd == "" && rpwd == "") {
			$("#msg_pwd").html("<font color='red'>密码不能为空</font>");
		} else {
			if (pwd == rpwd) {
				$("#msg_pwd").html("<font color='green'>两次密码匹配通过</font>");
				$("#btn_register").attr("disabled", false);
			} else {
				$("#msg_pwd").html("<font color='red'>两次密码不匹配</font>");
				$("#btn_register").attr("disabled", true);
			}
		}
	})
})

</script>

</body>
</html>