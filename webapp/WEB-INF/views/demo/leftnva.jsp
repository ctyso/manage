<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="width: 100%">
  <li class="layui-nav-item layui-nav-itemed">
    <a href="javascript:;">默认展开</a>
    <dl class="layui-nav-child">
      <dd><a href="javascript:;">选项一</a></dd>
      <dd><a href="javascript:;">选项二</a></dd>
      <dd><a href="javascript:;">选项三</a></dd>
      <dd><a href="">跳转项</a></dd>
    </dl>
  </li>
  <li class="layui-nav-item">
    <a href="javascript:;">解决方案</a>
    <dl class="layui-nav-child">
      <dd><a href="">移动模块</a></dd>
      <dd><a href="">后台模版</a></dd>
      <dd><a href="">电商平台</a></dd>
    </dl>
  </li>
  <li class="layui-nav-item"><a href="">云市场</a></li>
  <li class="layui-nav-item"><a href="">社区</a></li>
</ul>
<script>
layui.use('element', function(){
  var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
  
  //监听导航点击
  element.on('nav(demo)', function(elem){
    //console.log(elem)
    layer.msg(elem.text());
  });
  
  element.render();
});
</script>