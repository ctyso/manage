package com.manage.sys.entity;

import java.io.Serializable;
/**
 * 模块菜单表
 * 
 * @author SmartChenwx
 */
public class Module implements Serializable{

	private static final long serialVersionUID = 1L;
	/** 模块id */
	private Long moduleId;
	/** 模块名称 */
	private String title;
	/** 模块图标 */
	private String icon;
	/** 是否默认展开标识（0：否，1：是） */
	private Integer spread;
	/** 链接地址 */
	private String href;
	/** 是否是最后的节点 */
	private Integer leaf;
	/** 父节点（最初始的节点值为"-1"） */
	private String fatherCode;

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getSpread() {
		return spread;
	}

	public void setSpread(Integer spread) {
		this.spread = spread;
	}

	public Integer getLeaf() {
		return leaf;
	}

	public void setLeaf(Integer leaf) {
		this.leaf = leaf;
	}

	public String getFatherCode() {
		return fatherCode;
	}

	public void setFatherCode(String fatherCode) {
		this.fatherCode = fatherCode;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
