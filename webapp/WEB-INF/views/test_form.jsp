<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <jsp:include page="include.jsp"></jsp:include>
    <title>Document</title>
</head>
<body>
<div id='form'></div>
    <script>
       $(function(){
           form.create({
               id : 'form',
               content : [{
                  type:'toolbar',
                  align:'left',
                  buttons:[
                       {text:'新增',icon:"&#xe608",click:add},
                       {text:'导入',icon:"&#xe608",click:importData}
                  ]
               },
               {
                  type:'block',
                  title:"用户信息",
                  icon : 'icon-biaotitubiao',
                  rows:[
                      [
                         { type: "text" , field:"username", label:"用户名" }
                      ],
                      [
                         { type: "text" , field:"username", label:"用户名" , cols:"2" }
                      ],
                      [
                          { type: "text" , field:"username", label:"用户名" , cols:"3" }
                      ]
                  ]
               },
               {
                   type:'block',
                   title:"用户信息",
                   icon : 'icon-biaotitubiao',
                   rows:[
                       [
                           { type:"text", field:"city", label:"城市" },
                           { type:"text", field:"city", label:"城市" }
                       ],
                       [
                           { type:"blank" },
                           { type:"text", field:"city", label:"城市" }
                       ],
                       [
                          { type:"text", field:"city", label:"城市" , cols:"2" },
                          { type:"text", field:"city", label:"城市" }
                       ],
                       [
                           { type:"text", field:"city", label:"城市" },
                           { type:"text", field:"city", label:"城市" , cols:"2" }
                       ]
                   ]
               },
               {
                   type:'block',
                   title:"用户信息",
                   icon : 'icon-biaotitubiao',
                   rows:[
                       [
                          { type: "text" , field:"username", label:"用户名" },
                          { type: "text" , field:"username", label:"用户名" },
                          { type: "text" , field:"username", label:"用户名" },
                       ]
                   ]
                },
               {
                   type:'datatable',
                   title:"列表",
                   icon : 'icon-biaotitubiao',
                   dataUrl:'${APP_PATH}/user/login/queryList.htm',
                   cols : [
                      {field: 'id', title: 'ID', width:80, align: 'left'},
                      {field: 'username', title: '用户名', width:80, align: 'left'},
                      {field: 'sex', title: '性别', width:80, align: 'left'},
                      {field: 'city', title: '城市', width:80, align: 'left'},
                      {field: 'sign', title: '签名', width:177, align: 'left'},
                      {field: 'experience', title: '积分', width:80, align: 'left'},
                      {field: 'score', title: '评分', width:80, align: 'left'},
                      {field: 'classify', title: '职业', width:100, align: 'left'},
                      {field: 'wealth', title: '财富',  align: 'left'},
                      {
                          title:'操作',
                          width:178,
                          align:'center',
                          toolbar:[{
                              text:'修改',
                              click : change
                          },
                          {
                              text:'删除',
                              click : del
                          }]
                      }
                   ]
               }]});
       });

       function add(){
           alert('add');
       }
       function importData(){
           alert('importData');
       }
       function change(){
           alert('change');
       }function del(){
           alert('del');
       }
    </script>
</body>
</html>