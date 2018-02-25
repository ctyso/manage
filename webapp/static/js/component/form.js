;!function (window, $, undefined) {
    var form = {
        create:function( option ){
            // 控件父级的id
            var id = option.id;
            // 获取父级
            var parent = $( "#" + id );
            // 获取内容区域
            var content = option.content || [];
            // 数据表格加载项
            var tables = [];
            // 解析内容
            $.each( content , function( i , e ){
               // 定义区域
               var field = {};
               if( "toolbar" === e.type ) field = initToolbar( field , i , e );
               else if( "datatable" === e.type ) field = initDatatable( field , tables , i , e );
               else if( "block" === e.type ) field = initBlock( field , i , e );
               else { console.log( "暂时不支持该组件,能不能不要乱写类型"+e.type ); return; }
               $( field ).addClass( "field" );
               parent.append( field );
            } )
            // 初始化表单样式
            initFormStyle();
            if( tables.length ) loadTable( tables );
        }
    }
    
    /**
     * 初始化工具栏
     * 
     * @param i 内容索引
     * @param e 内容体
     */
    function initToolbar( field , i , e ){
        e.id = "toolbar"+i;
        field = window[ e.type ].init( e );
        return field;
    }
    
    /**
     * 初始化数据表格
     * 
     * @param i 内容索引
     * @param e 内容体
     */
    function initDatatable( field , tables , i , e ){
        // 这外层是为了控制生成表格的宽度
        var $div = $( "<div>" );
        field = window[e.type].init( e );
        field.attr( "id" , "datatable"+i );
        $div.append( field );
        tables.push( { id : i , option : e } );
        return $div;
    }
    
    /**
     * 初始化模块元素
     * 
     * @param i 内容索引
     * @param e 内容体
     */
    function initBlock( field , i , e ){
       var title = e.title || "";
       var icon = e.icon || "icon-biaotitubiao";
       var rows = e.rows || [];
       // 外围布局块
       var field = $("<div class='form-block'>");
       field.html( "<div class='title form-block-title'><i class='iconfont "+icon+"'></i><span>"+title+"</span></div>" );
       // 目前支持一行最多摆放3个表单元素的方式来布局
       $.each( rows , function( rowIndex, row ){
          // 行区域布局
          var rowField;
          // 1.根据不同的行内元素数量,生成不同的行布局
          rowField = createRowField( row );
          // 2.解析行内元素
          analysiRowElement( rowField , row );

          // 3.放置行布局到外围布局
          field.append( rowField );
       } );
       return field;
    }
    
    /**
     * 生成行布局
     * 
     * @param row 行内元素
     */
    function createRowField( row ){
       var length = row.length;
       if( 1 >= length ) return createRow1( row );
       if( 2 == length ) return createRow2( row );
       if( 3 == length ) return createRow3();
    }
    
    /**
     * 创建1个行表单元素布局
     */
    function createRow1( row ){
      var layui_row = $( "<div class='layui-row'>" );
      $.each( row , function( i , e ){
          var cols = e.cols || 1 ;
          if( 2 == cols ){
              var layui_col_md8 = $( "<div class='layui-col-md8'>" );
              layui_row.append( layui_col_md8 );
          } else if( 3 == cols ){
              var layui_col_md12 = $( "<div class='layui-col-md12'>" );
              layui_row.append( layui_col_md12 );
          } else{
              var layui_col_md4 = $( "<div class='layui-col-md4'>" );
              layui_row.append( layui_col_md4 );
          }
      } );
      return layui_row;
    }
    
    /**
     * 创建2个行表单元素布局
     * @parm row 行内元素
     */
    function createRow2( row ){
       var layui_row = $( "<div class='layui-row'>" );
       $.each( row , function( i , e ){
           var cols = e.cols || 1 ;
           if( 2 == cols ){
               var layui_col_md8 = $( "<div class='layui-col-md8'>" );
               layui_row.append( layui_col_md8 );
           } else if( 3 == cols ){
               var layui_col_md12 = $( "<div class='layui-col-md12'>" );
               layui_row.append( layui_col_md12 );
           } else{
               var layui_col_md4 = $( "<div class='layui-col-md4'>" );
               layui_row.append( layui_col_md4 );
           }
       } );
       return layui_row;
    }
    
    /**
     * 创建3个行表单元素布局
     */
    function createRow3(){
    	 var layui_row = $( "<div class='layui-row'>" );
         for( var i = 0 ; i < 3 ; i++ ) layui_row.append( $( "<div class='layui-col-md4'>" ) );
         return layui_row;
    }
    
    /**
     * 解析行内元素,并将解析之后的元素放置到行布局中
     * 
     * @param rowField 行布局块
     * @param inputs 行内元素
     */
    function analysiRowElement( rowField , row ){
       $.each( row , function( inputsIndex , input ){
           $( rowField ).children( "div" )[ inputsIndex ].append( window[ input.type ].init( { field : input.field, label : input.label, check : input.check } )[0] );
       } );
    }
    
    /**
     * 初始化表单样式
     */
    function initFormStyle(){
       $( ".grid-demo" ).removeClass( "text-right" );
       $( ".layui-row" ).addClass( "form-row" );
       $( ".layui-row>div>.grid-demo" ).html( $( ".layui-col-md8>.grid-demo>.layui-inline" ).html() );
       $( ".layui-row>div>.grid-demo" ).css( "margin-bottom","0px" ).css( "padding-right" , "15px" ).attr( "class" , "layui-form-item" );
       $( ".layui-row>div>.layui-form-item>.layui-input-inline" ).attr( "class" , "layui-input-block" )
       $( ".layui-row>div>.layui-form-item>.layui-input-block>input" ).attr( "class" , "layui-input" );
       //$( ".layui-col-md8>.grid-demo" ).css( "text-align" , "left" );
       /*$( ".layui-col-md8>.grid-demo>.layui-inline>label" ).css( "float","none" ).css( "display","inline-block" );
       $( ".layui-col-md8>.grid-demo>.layui-inline>.layui-input-inline" ).css( "width","63.98%" );
       $( ".layui-col-md8>.grid-demo>.layui-inline>.layui-input-inline>input" ).css( "width","100%" );*/
    }
    
    /**
     * 加载数据表格
     * @param i 数据表格ID
     * @param e 数据表格配置项
     */
    function loadTable( tables ){
        $.each( tables , function( index , table ){
            var i = table.id;
            var e = table.option
            e.id = "datatable"+i;
            datatable.load( e );
        } );
    }
    window.form= form;
}(window, jQuery);