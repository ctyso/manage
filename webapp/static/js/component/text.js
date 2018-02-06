;!function (window, $, undefined) {
    var text = {
        init:function( option ){
            // 对应的字段名
            var field = option.field || "";
            // 标签名称
            var label = option.label || "";
            // 检测输入内容
            var check = option.check;
            // 创建控件实体
            var input = createInput( field , check );
            // 创建控件布局层
            return createInputPanel( label , input );
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
     * @param name 字段名称
     * @param check 校验
     * {
     * required（必填项）
     * phone（手机号）
     * email（邮箱）
     * url（网址）
     * number（数字）
     * date（日期）
     * identity（身份证）
     * 自定义值
     * }
     */
    function createInput( field  , check  ) {
        var input = $("<input type='text' class='layui-input layui_input_set' autocomplete='off'>")
                 .attr( "field" , field )
                 .attr( "lay-verify" , check );
        return input;
    }
    window.text= text;
}(window, jQuery);