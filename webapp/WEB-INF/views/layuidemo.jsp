<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <jsp:include page="include.jsp"></jsp:include>
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
            <div>
                <div class="title"><i class="iconfont icon-biaotitubiao"></i><span>查询面板</span></div>
                <div class="search-block">
                    <jsp:include page="demo/querypanel.jsp"></jsp:include>
                </div>
                
            </div>
            <div class="toolbar">
                <jsp:include page="demo/layer.jsp"></jsp:include>
            </div>
            <div>
                <div class="title" style="margin-bottom:-10px"><i class="iconfont icon-biaotitubiao"></i><span>列表</span></div>
                <jsp:include page="demo/datatable.jsp"></jsp:include>
            </div>
        </div>
    </div>
</body>
</html>