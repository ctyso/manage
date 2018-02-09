<%--查询区域--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<div class="layui-form" style="height:100%;">
   <div class="layui-row row">
    <div class="layui-col-md9">
      <div class="grid-demo grid-demo-bg1">
            <div class="layui-row" >
            <div class="layui-col-md4">
              <div class="grid-demo text-right">
                    <div class="layui-inline">
                            <label class="layui-form-label">用户名</label>
                            <div class="layui-input-inline">
                              <input type="text" name="username" lay-verify="required"  autocomplete="off" class="layui-input layui-input-set">
                            </div>
                    </div>
              </div>
            </div>
            <div class="layui-col-md4">
              <div class="grid-demo text-right">
                      <div class="layui-inline">
                        <label class="layui-form-label">用户名</label>
                        <div class="layui-input-inline">
                          <input type="text" name="username" lay-verify="required"  autocomplete="off" class="layui-input layui-input-set">
                        </div>
                      </div>
              </div>
            </div>
            <div class="layui-col-md4">
              <div class="grid-demo grid-demo-bg1 text-right">
                   <div class="layui-inline">
                            <label class="layui-form-label">用户名</label>
                            <div class="layui-input-inline" style="white-space:nowrap;">
                              <input type="text" name="username" lay-verify="required"  autocomplete="off" class="layui-input layui-input-set" >
                            </div>
                    </div>
              </div>
            </div>
          </div>
      </div>
    </div>
    <div class="layui-col-md3">
      <div class="grid-demo" style="display: inline-block;">
            <a href="javascript:;" class="layui-inline layui-btn layui-btn-small search-button" style="display: inline-block;"> <i class="layui-icon" >&#xe615;</i> 搜索</a>
            <a href="javascript:;" class="layui-inline layui-btn layui-btn-small search-button" style="display: inline-block;"><i class="layui-icon">&#xe640;</i>重置 </a>
      </div>
    </div> 
  </div>

  <div class="layui-row row">
    <div class="layui-col-md9">
      <div class="grid-demo grid-demo-bg1">
            <div class="layui-row" >
            <div class="layui-col-md4">
              <div class="grid-demo text-right">
                    <div class="layui-inline">
                            <label class="layui-form-label">用户名</label>
                            <div class="layui-input-inline">
                              <input type="text" name="username" lay-verify="required"  autocomplete="off" class="layui-input layui-input-set">
                            </div>
                    </div>
              </div>
            </div>
            <div class="layui-col-md4">
              <div class="grid-demo text-right">
                    <div class="layui-inline">
                            <label class="layui-form-label">用户名</label>
                            <div class="layui-input-inline">
                              <input type="text" name="username" lay-verify="required"  autocomplete="off" class="layui-input layui-input-set">
                            </div>
                     </div>
              </div>
            </div>
            <div class="layui-col-md4">
              <div class="grid-demo grid-demo-bg1 text-right">
                    <div class="layui-inline">
                            <label class="layui-form-label">用户名</label>
                            <div class="layui-input-inline" style="white-space:nowrap;">
                              <input type="text" name="username" lay-verify="required"  autocomplete="off" class="layui-input layui-input-set" >
                            </div>
                     </div>
              </div>
            </div>
          </div>
      </div>
    </div>
  </div>
</div>

<script>
layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form;
    form.render();
})
</script>