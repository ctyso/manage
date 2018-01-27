package com.manage.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class SysMenuEntity implements Serializable {
    private String id;

    private String menuEncrypt;

    private String menuNm;

    private String supMenuId;

    private Integer pathIncVal;

    private String menuPath;

    private Short levelNum;

    private Integer orderNo;

    private String isFuncMenu;

    private String menuUri;

    private String menuStyleNm;

    private String isValid;

    private String remark;

    private String insertUser;

    private Date insertTime;

    private String updateUser;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuEncrypt() {
        return menuEncrypt;
    }

    public void setMenuEncrypt(String menuEncrypt) {
        this.menuEncrypt = menuEncrypt;
    }

    public String getMenuNm() {
        return menuNm;
    }

    public void setMenuNm(String menuNm) {
        this.menuNm = menuNm;
    }

    public String getSupMenuId() {
        return supMenuId;
    }

    public void setSupMenuId(String supMenuId) {
        this.supMenuId = supMenuId;
    }

    public Integer getPathIncVal() {
        return pathIncVal;
    }

    public void setPathIncVal(Integer pathIncVal) {
        this.pathIncVal = pathIncVal;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public Short getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(Short levelNum) {
        this.levelNum = levelNum;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getIsFuncMenu() {
        return isFuncMenu;
    }

    public void setIsFuncMenu(String isFuncMenu) {
        this.isFuncMenu = isFuncMenu;
    }

    public String getMenuUri() {
        return menuUri;
    }

    public void setMenuUri(String menuUri) {
        this.menuUri = menuUri;
    }

    public String getMenuStyleNm() {
        return menuStyleNm;
    }

    public void setMenuStyleNm(String menuStyleNm) {
        this.menuStyleNm = menuStyleNm;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInsertUser() {
        return insertUser;
    }

    public void setInsertUser(String insertUser) {
        this.insertUser = insertUser;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}