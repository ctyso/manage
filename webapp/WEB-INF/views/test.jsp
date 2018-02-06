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
<div id='main1'></div>
<div id='main2'></div>
    <script>
       $(function(){
    	   // 文本输入框
    	   text.create({
    		   id: 'main1',
    		   name:"username", 
    		   label:"用户名"
    	   }); 
    	   
    	   // 查询区域
    	   querypanel.create({
               id:"main2",
               title:"查询",
               rows:[
                   [
                      { type: "text" , name:"username", label:"用户名" },
                      { type: "text" , name:"username", label:"用户名" },
                      { type: "text" , name:"username", label:"用户名" },
                   ],
                   [
                      { type:"text", name:"city", label:"城市" },
                      { type:"text", name:"city", label:"城市" },
                      { type:"text", name:"city", label:"城市" },
                   ]
               ]
            });
       });
      
    </script>
</body>
</html>