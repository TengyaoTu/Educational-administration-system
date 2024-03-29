<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <title>测试</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <style type="text/css">
        .con4 {
    width: 300px;
    height: auto;
    overflow: hidden;
    margin: 20px auto;
    color: #FFFFFF;
}

.con4 .btn {
    width: 100%;
    height: 40px;
    line-height: 40px;
    text-align: center;
    background: #d8b49c;
    display: block;
    font-size: 16px;
    border-radius: 5px;
}

.upload {
    float: left;
    position: relative;
}

.upload_pic {
    display: block;
    width: 100%;
    height: 40px;
    position: absolute;
    left: 0;
    top: 0;
    opacity: 0;
    border-radius: 5px;
}

#cvs {
    border: 1px solid #000;
    margin: 20px 0 20px 50px;
}
    </style>
</head>

<body>
    <div class="con4">
        <form action="/upload" method="post" enctype="multipart/form-data">
        <canvas id="cvs" width="200" height="200"></canvas>	
        <span class="btn upload">上传头像<input type="file" class="upload_pic" id="upload" name="file"></span>
		
        
        <div style="margin: 80px;">
			<button  class="btn btn-primary mt-3" style="text-align: center;"
				id="btn_register" type="submit"><a><font style="color: aliceblue;">保存</font></a></button>
		</div>

         </form>
    </div>
    <script>
        //获取上传按钮
        var input1 = document.getElementById("upload");
        if (typeof FileReader === 'undefined') {
            //result.innerHTML = "抱歉，你的浏览器不支持 FileReader"; 
            input1.setAttribute('disabled', 'disabled');
        } else {
            input1.addEventListener('change', readFile, false);
            /*input1.addEventListener('change',function (e){
     	console.log(this.files);//上传的文件列表
     },false); */
        }

        function readFile() {
            var file = this.files[0]; //获取上传文件列表中第一个文件
            if (!/image\/\w+/.test(file.type)) {
                //图片文件的type值为image/png或image/jpg
                alert("文件必须为图片！");
                return false;
            }
            // console.log(file);
            var reader = new FileReader(); //实例一个文件对象
            reader.readAsDataURL(file); //把上传的文件转换成url
            //当文件读取成功便可以调取上传的接口
            reader.onload = function(e) {
                // console.log(this.result);//文件路径
                // console.log(e.target.result);//文件路径
                /*var data = e.target.result.split(',');
		var tp = (file.type == 'image/png')? 'png': 'jpg';
		var imgUrl = data[1];//图片的url，去掉(data:image/png;base64,)
		//需要上传到服务器的在这里可以进行ajax请求
		// console.log(imgUrl);
		// 创建一个 Image 对象 
		var image = new Image();
		// 创建一个 Image 对象 
		// image.src = imgUrl;
		image.src = e.target.result;
		image.onload = function(){
			document.body.appendChild(image);
		}*/
                var image = new Image();
                // 设置src属性 
                image.src = e.target.result;
                var max = 200;
                // 绑定load事件处理器，加载完成后执行，避免同步问题
                image.onload = function() {
                    // 获取 canvas DOM 对象 
                    var canvas = document.getElementById("cvs");
                    // 如果高度超标 宽度等比例缩放 *= 
                    /*if(image.height > max) {
				image.width *= max / image.height; 
				image.height = max;
			} */
                    // 获取 canvas的 2d 环境对象, 
                    var ctx = canvas.getContext("2d");
                    // canvas清屏 
                    ctx.clearRect(0, 0, canvas.width, canvas.height);
                    // 重置canvas宽高
                    /*canvas.width = image.width;
			canvas.height = image.height;
			if (canvas.width>max) {canvas.width = max;}*/
                    // 将图像绘制到canvas上
                    // ctx.drawImage(image, 0, 0, image.width, image.height);
                    ctx.drawImage(image, 0, 0, 200, 200);
                    // 注意，此时image没有加入到dom之中
                };
            }
        };
    </script>
</body>

</html>
