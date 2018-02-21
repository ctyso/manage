;!function (window, $, undefined) {
    var toolbar = {
        init:function( option ){
            var buttons = option.buttons || [];
            var align = option.align || 'left';
            var toolbar = $("<div class='toolbar'>");
            $.each( buttons , function( i , button ){
                var icon = button.icon || '&#xe608';
                var click = button.click; 
                var text = button.text || '新按钮';
                var a = $("<a class='layui-btn layui-btn-small'>")
                            .click( click )
                            .append( $("<i class='layui-icon'>").html( icon ) )
                            .append( text );
                toolbar.append( a );
            });
            return toolbar;
        },
        create:function( option ){
            // 控件上级的id
            var id = option.id;
            // 获取父级
            var parent = $("#" + id);
            // 设置外框到父级
            $(parent).append( this.init( option ) );
        }
    }

    window.toolbar= toolbar;
}(window, jQuery);