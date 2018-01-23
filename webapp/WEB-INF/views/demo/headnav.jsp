<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<div style="text-align: right;">
	<ul class="layui-nav">
	  <li class="layui-nav-item">
	    <a href="">控制台<span class="layui-badge">9</span></a>
	  </li>
	  <li class="layui-nav-item">
	    <a href="">个人中心<span class="layui-badge-dot"></span></a>
	  </li>
	  <li class="layui-nav-item" lay-unselect="">
	    <a href="javascript:;"><img src="${IMG_PATH}/avatar.png" class="layui-nav-img">cg</a>
	    <dl class="layui-nav-child">
	      <dd><a href="javascript:;">修改信息</a></dd>
	      <dd><a href="javascript:;">安全管理</a></dd>
	      <dd><a href="javascript:;">退了</a></dd>
	    </dl>
	  </li>
	</ul>
</div>
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
