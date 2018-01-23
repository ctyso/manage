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
    <style>
        .panel{
            margin-top: 3px;
            height:860px;
        }
        .panel>div{
            height:100%;
            display: inline-block;
        }
        
        .panel>div:FIRST-CHILD{
            width:14%;
            display: inline-block;
            float: left;
            background:#282B33 ;
            margin:0 3px
        }
        
        .clearfix{
		    zoom:1;
		}
        
        #content{
            width: 84%;
            box-sizing: border-box;
        }
        #content>div{
            width:100%;
            display: inline-block;
        }
        .toolbar{
            padding:10px 10px 0 0;
            text-align: right;
        }
        .clearfix{
            
        }
    </style>
    
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
		<div id="content" class="clearfix">
			<div style="height: 200px"></div>
	        <div class="toolbar">
	            <jsp:include page="demo/layer.jsp"></jsp:include>
	        </div>
	        <div>
	           <jsp:include page="demo/datatable.jsp"></jsp:include>
	        </div>
		</div>
    </div>
</body>
</html>