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
        var layui_row = $( "<div class='layui-row'>" );
        $.each( row , function( i , e ){
            var cols = e.cols || 1 ;
            // 根据不同的合并列来生成不同的布局
            if( 2 == cols ){
                layui_row.append( $( "<div class='layui-col-md8'>" ) );
            } else if( 3 == cols ){
                layui_row.append( $( "<div class='layui-col-md12'>" ) );
            } else{
                layui_row.append( $( "<div class='layui-col-md4'>" ) );
            }
        } );
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