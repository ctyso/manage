<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="${JS_PATH}/jquery/jquery-3.3.1.min.js"></script>
    <script src="${JS_PATH}/layui/layui.all.js"></script>
    <link rel="stylesheet" href="${JS_PATH}/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${CSS_PATH}/component.css" media="all">
    <title>Document</title>
</head>
<body>
    <div>
        <jsp:include page="demo/headnav.jsp"></jsp:include>
    </div>
    <div class="panel">
		<div>
		  <jsp:include page="demo/leftnva.jsp"></jsp:include>
		</div>
		<div class="content">
            <fieldset class="layui-elem-field site-demo-button" style="height: 175px;">
                <legend style="font-size:18px;font-family:'黑体';font: #0c0c0c">查询</legend>
                <jsp:include page="demo/querypanel.jsp"></jsp:include>
            </fieldset>
	        <div class="toolbar">
	            <jsp:include page="demo/layer.jsp"></jsp:include>
	        </div>
	        <div>
		        <fieldset class="layui-elem-field site-demo-button" style="padding: 0 15px 2px 15px">
	                <legend style="font-size:18px;font-family:'黑体';font: #0c0c0c">列表</legend>
	                <jsp:include page="demo/datatable.jsp"></jsp:include>
	            </fieldset>
	        </div>
		</div>
    </div>
</body>
</html>