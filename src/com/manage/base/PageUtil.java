package com.manage.base;

/**
 * 自动分页（设置了page后将在接下来程序的第一个查询进行分页查询）
 * Created by risun on 2017/1/6.
 */
public class PageUtil {
	private static final ThreadLocal<Page> pageConntext = new ThreadLocal<Page>();

	public static Page getPage() {
		return pageConntext.get();
	}

	public static void setPage(Page page){
		pageConntext.set(page);
	}
	public static void setPage(int currentPage, int pageSize){
		Page page =new Page(currentPage,pageSize);
		pageConntext.set(page);
	}
	public static void setPage(int currentPage, int pageSize,boolean selectTotalRecord){
		Page page =new Page(currentPage,pageSize);
		page.setSelectTotalRecord(selectTotalRecord);
		pageConntext.set(page);
	}
	public static void setPage(Page page,boolean selectTotalRecord){		
		page.setSelectTotalRecord(selectTotalRecord);
		pageConntext.set(page);
	}
	public static void removePage(){
		pageConntext.remove();
	}
}