;!function (window, $, undefined) {
   // 查询地址
   var queryUrl;
   var querypanel = {
      init:function( option ){
         // 标题
         var title = option.title || "查询";
         queryUrl = option.queryUrl || "请写入有效的请求URL";
         // 查询行，目前只按照两行来布局
         var rows = option.rows || [];
         // 输入框组
         var inputs = [];
         // 生成输入区域
         $.each( rows , function( i , row ){
            var input_row = [];
            $.each( row , function( i , e ){
               var field = e.field || '';
               var label = e.label || '';
               var check = e.check;
               var input = window[e.type].init( { field : field, label : label, check : check } );
               input_row.push( input );
            } );
            inputs.push( input_row );
         } );
         return createPanel( title , inputs )
      },
      create:function( option ){
          // 控件上级的id
          var id = option.id;
          // 获取父级
          var parent = $("#" + id);
          // 图标
          var icon = option.icon || 'icon-biaotitubiao';
          // 标题
          var title = option.title || '查询面板';
          // 设置标题到父级
          $(parent).append("<div class='title'><i class='iconfont "+icon+"'></i><span>"+title+"</span></div>")
          // 设置外框到父级
          $(parent).append( this.init( option ) );
      },
      query:function(){
          var parms = {};
          // 更新表格数据
          $.each( $(".layui-form .input") , function( i , input ){ 
            var value = $(input).val();
            if( value ) parms[$(input).attr("field")] = value;
          } );
          $.post( queryUrl , parms , function( data ){
              
          } );
      },
      reset:function(){
          $.each( $(".layui-form .input") , function( i , input ){
              $(input).val("");
          });
      }
   } 
   /**
    * 创建外框
    * @param title 标题
    * @param inputs 实体
    */
   function createPanel( title , inputs ){
      var search_block = $( "<div class='search-block'>" );
    
      var layui_div_form = $( "<div class='layui-form' style='height:100%;'>" );

      // 第一行
      var layui_row1 = $( "<div class='layui-row row'>" );
      var layui_col_md9_1 = $( "<div class='layui-col-md9'>" );
      var grid_demo_1 = $( "<div class='grid-demo grid-demo-bg1'>" );
      var layui_row_1 = $( "<div class='layui-row'>" );

      // 输入区
      $.each( inputs[0] , function( i , input ){
         var layui_col_md4_1 = $( "<div class='layui-col-md4'>" );
         layui_col_md4_1.append( input );
         layui_row_1.append( layui_col_md4_1 );
      } );

      // 按钮区，会不会有点流氓
      var layui_col_md3_1 = $( "<div class='layui-col-md3'>" );
      layui_col_md3_1.html( "<div class='grid-demo' style='display: inline-block;'>"
            +"<a href='javascript:querypanel.query();' class='layui-inline layui-btn layui-btn-small search-button' style='display: inline-block;'><i class='layui-icon'>&#xe615;</i>搜索</a>" 
            +"<a href='javascript:querypanel.reset();' class='layui-inline layui-btn layui-btn-small search-button' style='display: inline-block;'><i class='layui-icon'>&#xe640;</i>重置</a>"
            +"</div>");
      
      // 反正就是套娃呗╮(╯▽╰)╭,给输入区嵌套外框
      grid_demo_1.append( layui_row_1 );
      layui_col_md9_1.append( grid_demo_1 );
      layui_row1.append( layui_col_md9_1 );
      layui_row1.append( layui_col_md3_1 );

      // 第二行
      var layui_row2 = $( "<div class='layui-row row'>" );
      var layui_col_md9_2 = $( "<div class='layui-col-md9'>" );
      var grid_demo_2 = $( "<div class='grid-demo grid-demo-bg1'>" );
      var layui_row_2 = $( "<div class='layui-row'>" );
      // 输入区
      $.each( inputs[1] , function( i , input ){ 
         var layui_col_md4_2 = $( "<div class='layui-col-md4'>" );
         layui_col_md4_2.append( input ); 
         layui_row_2.append( layui_col_md4_2 );
      });
      // 给输入区嵌套外框
      grid_demo_2.append( layui_row_2 );
      layui_col_md9_2.append( grid_demo_2 );
      layui_row2.append( layui_col_md9_2 );
      
      // 把两行都加到外层form去
      layui_div_form.append( layui_row1 );
      layui_div_form.append( layui_row2 );

      search_block.append( layui_div_form );
      return search_block;
   }
   window.querypanel= querypanel;
}(window, jQuery);