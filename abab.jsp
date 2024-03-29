﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>jquery table编辑插件</title>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css" href="jquerytable/css/style.css">

<link rel="stylesheet" type="text/css" href="jquerytable/css/bootstrap.min.css">

<script src="jquerytable/js/jquery.min.js"></script>
<script src="jquerytable/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="jquerytable/js/bootbox.min.js"></script>



</head>
<body>
    
<div class="box">
	<form action="fresh">
	</form>
    
    <div class="content">
        <!--搜索输入框及查询、重置按钮-->
        <div class="container content_width">
            <div class="person_search">
                <div class="search_input">
                    <div class="input-group mb-3">
                        <span>姓名：</span>
                        <input id="Ktext" type="text" class="form-control" placeholder="请输入姓名">
                    </div>
                </div>
                <div class="search_input">
                    <div class="input-group mb-3" hidden>
                        <span>学号：</span>
                        <input id="job_num" type="text" class="form-control" placeholder="请输入学号">
                    </div>
                </div>
                <div class="search_input">
                    <button class="btn btn-primary search_btn" type="button" id="search_btn">查询</button>
                    <button class="btn btn-primary search_btn" type="button" id="back_btn">重置</button>
                </div>
            </div>
            <div class="line"></div>
        </div>
        <!--添加按钮及bootstrap的模态框-->
        
        <div class="export">
            
           
            <div class="modal fade" id="renyuan">
            
                <div class="modal-dialog modal-lg modal_position">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">添加</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        
                        <div class="modal-body">
                        	<form action="http://localhost:8080/register_admin" method="get" class="needs-validation" novalidate>
                         
                            <table id="xztb" class="table">
                                <!--新修改弹窗的样式-->
                                <tbody>
                                <tr>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>姓名</label>
                                    </td>
                                    <td><input class="userName" type="text" placeholder="请输入姓名" name="name"></td>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>学号</label>
                                    </td>
                                    <td><input class="jobNum" type="number" placeholder="请输入学号" name="id"></td>
                                </tr>
                                <tr>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>性别</label>
                                    </td>
                                    <td><input class="phoneNum" type="text" placeholder="请输入性别" name="sex"></td>
                                    <td class="tb_bg"><label for="">统一身份认证号</label></td>
                                    <td><input type="text" placeholder="请输入统一身份认证号" name="uniaccount"></td>
                                </tr>
                                <tr>
                                    <td class="tb_bg"><label for="">省市</label></td>
                                    <td><input type="text" placeholder="请输入省市" name="area"></td>
                                    <td class="tb_bg"><label for="">专业</label></td>
                                    <td><input type="text" placeholder="请输入专业" name="colleges"></td>
                                </tr>
                                </tbody>
                                
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                            <button  type="submit"  class="btn btn-secondary" onlick="hello()">确定</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </form>
        
        <!--表格列表-->
        <div id = "app">
        <table id="tb" class="table">
            <thead>
            <tr>
                <th>姓名</th>
                <th>性别</th>
                <th>学号</th>
                <th>统一身份认证号</th>
                <th>省市</th>
                <th>专业</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="show_tbody">
            <c:forEach  items="${findAllStudent}"  var="student01"  >
             <form action="change">
             
             
            <tr>
                <td><input value="${student01.name}" id="name01" name="name"></input></td>
                <td><input value=${student01.sex} name="sex"></input></td>
                <td><input value=${student01.id}   disabled="disabled">
                <input type="hidden" value=${student01.id}  name="id" >
                
                
                </input></td>
                <td><input value=${student01.uniaccount} name="uniaccount"></input></td>
                <td><input value=${student01.area}  name="area"></input></td>
                <td><input value=${student01.colleges} name="colleges"></input></td>
                

                <td>
                   <button  type="submit">修改</button>
                    <a href="http://localhost:8080/delete?id=${student01.id}" class="del">删除</a>
                </td>
            </tr>
            </form>
            </c:forEach>
            
            </tbody>
        </table>
    </div>
  
</div>
<script src="jquerytable/js/mejs.js"></script>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
</div>


</body>
</html>