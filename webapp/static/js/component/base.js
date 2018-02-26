/**
 * 创建外框
 * @param labelName 标签名
 * @param input 实体
 */
function createInputPanel( labelName , input ){
    var grid_demo_div = $( "<div class='grid-demo'>" );
    var layui_inline_div = $( "<div class='layui-form-item'>" ).css( "margin" , "0px" ).css( "padding-right" , "15px" );
    var layui_form_label = $( "<label class='layui-form-label'>" ).html( labelName );
    var layui_input_inline = $( "<div class='layui-input-block'>" ).append( input );
    grid_demo_div.append( layui_inline_div );
    layui_inline_div.append( layui_form_label )
              .append( layui_input_inline );
    return grid_demo_div;
}