/**
 * 
 */
package com.manage.base.layui.bean;

import javax.servlet.http.HttpServletRequest;

import com.util.StringUtil;

/**
 * TODO: 请设置类型说明
 *
 * @author YKZHUO
 */
/**
 * 页面分页信息
 * 
 * @author gopher
 * 
 */
public class PageInfo {

    /**
     * 当前第几页
     */
    private int pageIndex;

    /**
     * 分页条数
     */
    private int pageSize;

    public PageInfo(int pageIndex, int pageSize) {
        this.setPageIndex( pageIndex == Integer.MIN_VALUE ? 0 : pageIndex );
        // 获取页面记录条数
        this.setPageSize( pageSize == Integer.MIN_VALUE ? 20 : pageSize );
    }

    /*
     * 构造器
     */
    public PageInfo(HttpServletRequest request) {
        int pageindex = StringUtil.toInt( request.getParameter( "page" ) );
        this.setPageIndex( pageindex == Integer.MIN_VALUE ? 0 : pageindex );
        int pageSize = StringUtil.toInt( request.getParameter( "limit" ) );
        // 获取页面记录条数
        this.setPageSize( pageSize == Integer.MIN_VALUE ? 20 : pageSize );
    }

    /**
     * 当前第几页
     */
    public int getPageIndex() {
        return pageIndex;
    }

    /**
     * 当前第几页
     */
    public void setPageIndex( int pageIndex ) {
        this.pageIndex = pageIndex;
    }

    /**
     * 分页条数
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 分页条数
     */
    public void setPageSize( int pageSize ) {
        this.pageSize = pageSize;
    }

}
