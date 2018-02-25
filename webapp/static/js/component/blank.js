;!function (window, $, undefined) {
    var blank = {
        init:function( option ){
            // 创建控件布局层
            return createInput();
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

    /**
     * 创建控件实体
     */
    function createInput() {
        return $("<div>").css( "height" , "38px" );
    }
    window.blank= blank;
}(window, jQuery);