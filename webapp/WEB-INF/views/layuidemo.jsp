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
        .fifty-percent{
            display: inline-block;
            width: 49%；
        }
    </style>
    
    <title>Document</title>
</head>
<body>
    <jsp:include page="demo/datatable.jsp"></jsp:include>
</body>
</html>