<%--数据表格--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<table id="table" lay-filter="test"></table>
<script>
        layui.use('table', function(){
          var table = layui.table;
          //第一个实例
          table.render({
            elem: '#table'
            ,height: 600// 只显示数据高度 full  撑开最小高度 full-200
            ,url: '${APP_PATH}/user/login/queryList.htm' // 数据接口
            ,page: true //开启分页
            ,cellMinWidth: '80'
            ,loading: true // 在翻页时是否显示加载框
            ,text:"暂无数据"// 空数据时候的提示
            ,cols: [[ // 表头
              {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
              ,{field: 'username', title: '用户名', width:80}
              ,{field: 'sex', title: '性别', width:80, sort: true}
              ,{field: 'city', title: '城市', width:80} 
              ,{field: 'sign', title: '签名', width: 177}
              ,{field: 'experience', title: '积分', width: 80, sort: true}
              ,{field: 'score', title: '评分', width: 80, sort: true}
              ,{field: 'classify', title: '职业', width: 100}
              ,{field: 'wealth', title: '财富', sort: true}
            ]],
            // 数据渲染结束后的回调
            done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                // console.log(res);
                
                //得到当前页码
                // console.log(curr); 
                
                //得到数据总量
                // console.log(count);
            },
            // 自定义排序字段和排序方式
            initSort: {
                  field: 'id' //排序字段，对应 cols 设定的各字段名
                  ,type: 'desc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
            },
            // 样式渲染
            skin: 'row' //行边框风格  line （行边框风格）  row （列边框风格）  nob （无边框风格）
            ,even: true //开启隔行背景
            ,size: 'sm' //小尺寸的表格  sm （小尺寸）  lg （大尺寸）
          });
          table.render();
        });
    </script>