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
<div id='main1' style="padding: 10px;"></div>
<div id='main2'></div>
<div id='main3'></div>
<div id='main4'></div>
<jsp:include page="demo/form.jsp"></jsp:include>
    <script>
       $(function(){
          // 文本输入框
          text.create({
             id: 'main1',
             field:"username", 
             label:"用户名"
          }); 
          
          // 查询区域
          querypanel.create({
               id:"main2",
               title:'查询面板',
               icon : 'icon-biaotitubiao',
               queryUrl:'${APP_PATH}/user/login/queryList.htm',
               rows:[
                   [
                      { type: "text" , field:"username", label:"用户名" },
                      { type: "text" , field:"username", label:"用户名" },
                      { type: "text" , field:"username", label:"用户名" },
                   ],
                   [
                      { type:"text", field:"city", label:"城市" },
                      { type:"text", field:"city", label:"城市" },
                      { type:"text", field:"city", label:"城市" },
                   ]
               ]
            });
          // 工具栏  ,字体图标icon http://www.layui.com/doc/element/icon.html
          toolbar.create({
              id : 'main3',
              align:'left',
              buttons:[
                   {text:'新增',icon:"&#xe608",click:add},
                   {text:'导入',icon:"&#xe608",click:importData}
              ]
          });
          
          // 数据表格
          datatable.create({
             id : 'main4',
             dataUrl:'${APP_PATH}/user/login/queryList.htm',
             title:'列表',
             icon : 'icon-biaotitubiao',
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
          });
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