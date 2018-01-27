package com.manage.base;

import java.util.Collections;
import java.util.List;

/**
 * 翻页对象
 * 
 * @author risun
 * 
 */
@SuppressWarnings("serial")
public class Page  {

	/**
	 * 每页显示记录数
	 */
	private int pageSize = 10;

	/**
	 * 查询结果总记录数
	 */
	private int totalRecord = 0;

	/**
	 * 当前页面
	 */
	private int currentPage = 1;

	/**
	 * 总共页数
	 */
	private int totalPage;

	/**
	 * 记录集
	 */
	private List<?> records = Collections.emptyList();
	/**
	 * 是否统计总记录数
	 */
	private boolean selectTotalRecord =true;
	/**
	 * 是否再查询完后清除缓存（拦截器拦截的位置在BaseExecutor内部的StatementHandler里，仅仅分页参数不同的查询可能出现返回一级缓存内容的情况）
	 */
	private boolean cleanCache =false;
	public Page() {
	}

	/**
	 * @param currentPage
	 *            当前页码
	 * @param pageSize
	 *            每页显示记录数
	 */
	public Page(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	/**
	 * @param currentPage
	 *            当前页码
	 * @param totalRecord
	 *            总记录数
	 * @param pageSize
	 *            每页显示记录数
	 */
	public Page(int currentPage, int totalRecord, int pageSize) {
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.pageSize = pageSize;
	}

	/**
	 * 开始记录位置
	 * 
	 * @return the recordStart
	 */
	public int getRecordStart() {
		if (this.currentPage > 0) {
			return (this.currentPage - 1) * this.pageSize + 1;
		} else {
			return 0;
		}
	}

	/**
	 * 结束记录位置
	 * 
	 * @return the recordEnd
	 */
	public int getRecordEnd() {
		if (this.currentPage > 0) {
			return this.currentPage * this.pageSize;
		} else {
			return 0;
		}
	}

	/**
	 * 每页显示记录数
	 * 
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 每页显示记录数
	 * 
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 获取总记录数
	 * 
	 * @return the totalRecord
	 */
	public int getTotalRecord() {
		return totalRecord;
	}

	/**
	 * 设置总记录数
	 * 
	 * @param totalRecord
	 *            the totalRecord to set
	 */
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	/**
	 * 当前页码
	 * 
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * 当前页码
	 * 
	 * @param currentPage
	 *            the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 总共页数
	 * 
	 * @return the totalPage
	 */
	public int getTotalPage() {
		this.totalPage = (int) Math.floor((this.totalRecord * 1.0d)
				/ this.pageSize);
		if (this.totalRecord % this.pageSize != 0) {
			this.totalPage++;
		}
		if (totalPage == 0) {
			return 1;
		}
		return totalPage;
	}

	/**
	 * 获取记录集
	 * 
	 * @return
	 */
	public List<?> getRecords() {
		return records;
	}

	/**
	 * 设置记录集
	 * 
	 * @param records
	 */
	public void setRecords(List<?> records) {
		this.records = records;
	}

	/**
	 * 字段定义名
	 * 
	 * @author xiezm
	 */
	public static class FieldDomain {

		/**
		 * 开始记录位置
		 */
		public static final String RECORD_START = "recordStart";

		/**
		 * 结束记录位置
		 */
		public static final String RECORD_END = "recordEnd";

		/**
		 * 每页显示记录数
		 */
		public static final String PAGE_SIZE = "pageSize";

		/**
		 * 查询结果总记录数
		 */
		public static final String TOTAL_RECORD = "totalRecord";

		/**
		 * 每页显示记录数
		 */
		public static final String CURRENT_PAGE = "currentPage";

		/**
		 * 总共页数
		 */
		public static final String TOTAL_PAGE = "totalPage";

		/**
		 * 记录集
		 */
		public static final String RECORDS = "records";
	}

	public boolean isSelectTotalRecord() {
		return selectTotalRecord;
	}

	public void setSelectTotalRecord(boolean selectTotalRecord) {
		this.selectTotalRecord = selectTotalRecord;
	}

	public boolean isCleanCache() {
		return cleanCache;
	}

	public void setCleanCache(boolean cleanCache) {
		this.cleanCache = cleanCache;
	}
}
