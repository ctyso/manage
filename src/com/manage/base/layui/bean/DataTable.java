/**
 * 
 */
package com.manage.base.layui.bean;

import java.util.List;
import java.util.Map;

import com.util.ObjectUtil;

/**
 * 数据表格格返回对象
 *
 * @author YKZHUO
 */
public class DataTable {
    // 返回码
    private int code;
    // 数据总数
    private int count;
    // 数据
    private List<Map<String, Object>> data;
    // 消息
    private String msg;

    public DataTable(List<Map<String, Object>> data) {
        this.code = 0;
        this.msg = "";
        this.count = ObjectUtil.isNull( data ) ? 0 : data.size();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode( int code ) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount( int count ) {
        this.count = count;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData( List<Map<String, Object>> data ) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg( String msg ) {
        this.msg = msg;
    }

}
