;!function (window, $, undefined) {
   var datatable = {
      create:function( option ){
          // 控件上级的id
          var id = option.id;
          // 表格高度
          var height = option.height || 600; // 只显示数据高度 full  撑开最小高度 full-200
          // 数据接口
          var dataUrl = option.dataUrl || '请写入正确的数据请求地址';
          // 是否分页
          var isPage = option.isPage || true;
          // 单元格最小宽度
          var cellMinWidth = '80';
          // 翻页时是否显示加载框
          var isShowLoadingbox = true;
          // 空数据时提示
          var blackTip = option.blackTip || "暂无数据";
          // 表格渲染结束之后的回调 res数据集，curr 当前页码 ，count得到数据总量
          var loadResult = option.loadResult || function(res, curr, count){};
          // 排序字段和排序方式 { field 'id'., type : 'desc' } ，尽量还是排序之后再交与前端
          var initSort = undefined;
          // 样式渲染    行边框风格  line （行边框风格）  row （列边框风格）  nob （无边框风格）
          var skin = 'row';
          // 隔行背景
          var even = true;
          // 表格尺寸 小尺寸的表格  sm （小尺寸)  lg （大尺寸）
          var size = 'sm';
          // 数据列
          var cols = option.cols || [];
          var resultCols = [];
          
          $.each( cols , function( i , col ){
            var tempCol = {};
            tempCol.field = col.field;
            tempCol.title = col.title;
            tempCol.width = col.width;
            tempCol.fixed = col.align;
            resultCols.push( tempCol );
          } );
      
          layui.use('table', function(){
              var table = layui.table;
              table.render( {
                  elem: "#"+id
                  ,height: height
                  ,url: dataUrl
                  ,page: isPage
                  ,cellMinWidth: cellMinWidth
                  ,loading: isShowLoadingbox
                  ,text:blackTip
                  ,cols: [resultCols]
                  ,done: loadResult
                  ,initSort: initSort
                  ,skin: skin
                  ,even: even
                  ,size: size
                } );
              table.render();
            });
      }
   }

   window.datatable= datatable;
}(window, jQuery);