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
