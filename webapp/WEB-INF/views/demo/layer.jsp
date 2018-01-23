<%--弹出层--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<button class="layui-btn" onclick="openWindow()">新增</button>
<script>
    function openWindow(){
    	//eg1
    	// layer.alert('酷毙了', {icon: 1});
    	//eg2
    	// layer.msg('不开心。。', {icon: 5});
    	//eg3
    	// layer.load(1); //风格1的加载
        layer.open({
        	skin: 'demo-class',
            title:'登录',
            area: ['1200px', '600px'],
            type: 2, // 0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
            content:  ['${APP_PATH}/user/login/form.htm'],// 内容区域，可以是文字也可以是页面 ['/datatable.jsp','no']
            success: function(layero, index){
                console.log(layero, index);
            }
        });
    }
</script>