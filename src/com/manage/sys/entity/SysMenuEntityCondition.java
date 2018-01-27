package com.manage.sys.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysMenuEntityCondition {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysMenuEntityCondition() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMenuEncryptIsNull() {
            addCriterion("menu_encrypt is null");
            return (Criteria) this;
        }

        public Criteria andMenuEncryptIsNotNull() {
            addCriterion("menu_encrypt is not null");
            return (Criteria) this;
        }

        public Criteria andMenuEncryptEqualTo(String value) {
            addCriterion("menu_encrypt =", value, "menuEncrypt");
            return (Criteria) this;
        }

        public Criteria andMenuEncryptNotEqualTo(String value) {
            addCriterion("menu_encrypt <>", value, "menuEncrypt");
            return (Criteria) this;
        }

        public Criteria andMenuEncryptGreaterThan(String value) {
            addCriterion("menu_encrypt >", value, "menuEncrypt");
            return (Criteria) this;
        }

        public Criteria andMenuEncryptGreaterThanOrEqualTo(String value) {
            addCriterion("menu_encrypt >=", value, "menuEncrypt");
            return (Criteria) this;
        }

        public Criteria andMenuEncryptLessThan(String value) {
            addCriterion("menu_encrypt <", value, "menuEncrypt");
            return (Criteria) this;
        }

        public Criteria andMenuEncryptLessThanOrEqualTo(String value) {
            addCriterion("menu_encrypt <=", value, "menuEncrypt");
            return (Criteria) this;
        }

        public Criteria andMenuEncryptLike(String value) {
            addCriterion("menu_encrypt like", value, "menuEncrypt");
            return (Criteria) this;
        }

        public Criteria andMenuEncryptNotLike(String value) {
            addCriterion("menu_encrypt not like", value, "menuEncrypt");
            return (Criteria) this;
        }

        public Criteria andMenuEncryptIn(List<String> values) {
            addCriterion("menu_encrypt in", values, "menuEncrypt");
            return (Criteria) this;
        }

        public Criteria andMenuEncryptNotIn(List<String> values) {
            addCriterion("menu_encrypt not in", values, "menuEncrypt");
            return (Criteria) this;
        }

        public Criteria andMenuEncryptBetween(String value1, String value2) {
            addCriterion("menu_encrypt between", value1, value2, "menuEncrypt");
            return (Criteria) this;
        }

        public Criteria andMenuEncryptNotBetween(String value1, String value2) {
            addCriterion("menu_encrypt not between", value1, value2, "menuEncrypt");
            return (Criteria) this;
        }

        public Criteria andMenuNmIsNull() {
            addCriterion("menu_nm is null");
            return (Criteria) this;
        }

        public Criteria andMenuNmIsNotNull() {
            addCriterion("menu_nm is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNmEqualTo(String value) {
            addCriterion("menu_nm =", value, "menuNm");
            return (Criteria) this;
        }

        public Criteria andMenuNmNotEqualTo(String value) {
            addCriterion("menu_nm <>", value, "menuNm");
            return (Criteria) this;
        }

        public Criteria andMenuNmGreaterThan(String value) {
            addCriterion("menu_nm >", value, "menuNm");
            return (Criteria) this;
        }

        public Criteria andMenuNmGreaterThanOrEqualTo(String value) {
            addCriterion("menu_nm >=", value, "menuNm");
            return (Criteria) this;
        }

        public Criteria andMenuNmLessThan(String value) {
            addCriterion("menu_nm <", value, "menuNm");
            return (Criteria) this;
        }

        public Criteria andMenuNmLessThanOrEqualTo(String value) {
            addCriterion("menu_nm <=", value, "menuNm");
            return (Criteria) this;
        }

        public Criteria andMenuNmLike(String value) {
            addCriterion("menu_nm like", value, "menuNm");
            return (Criteria) this;
        }

        public Criteria andMenuNmNotLike(String value) {
            addCriterion("menu_nm not like", value, "menuNm");
            return (Criteria) this;
        }

        public Criteria andMenuNmIn(List<String> values) {
            addCriterion("menu_nm in", values, "menuNm");
            return (Criteria) this;
        }

        public Criteria andMenuNmNotIn(List<String> values) {
            addCriterion("menu_nm not in", values, "menuNm");
            return (Criteria) this;
        }

        public Criteria andMenuNmBetween(String value1, String value2) {
            addCriterion("menu_nm between", value1, value2, "menuNm");
            return (Criteria) this;
        }

        public Criteria andMenuNmNotBetween(String value1, String value2) {
            addCriterion("menu_nm not between", value1, value2, "menuNm");
            return (Criteria) this;
        }

        public Criteria andSupMenuIdIsNull() {
            addCriterion("sup_menu_id is null");
            return (Criteria) this;
        }

        public Criteria andSupMenuIdIsNotNull() {
            addCriterion("sup_menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupMenuIdEqualTo(String value) {
            addCriterion("sup_menu_id =", value, "supMenuId");
            return (Criteria) this;
        }

        public Criteria andSupMenuIdNotEqualTo(String value) {
            addCriterion("sup_menu_id <>", value, "supMenuId");
            return (Criteria) this;
        }

        public Criteria andSupMenuIdGreaterThan(String value) {
            addCriterion("sup_menu_id >", value, "supMenuId");
            return (Criteria) this;
        }

        public Criteria andSupMenuIdGreaterThanOrEqualTo(String value) {
            addCriterion("sup_menu_id >=", value, "supMenuId");
            return (Criteria) this;
        }

        public Criteria andSupMenuIdLessThan(String value) {
            addCriterion("sup_menu_id <", value, "supMenuId");
            return (Criteria) this;
        }

        public Criteria andSupMenuIdLessThanOrEqualTo(String value) {
            addCriterion("sup_menu_id <=", value, "supMenuId");
            return (Criteria) this;
        }

        public Criteria andSupMenuIdLike(String value) {
            addCriterion("sup_menu_id like", value, "supMenuId");
            return (Criteria) this;
        }

        public Criteria andSupMenuIdNotLike(String value) {
            addCriterion("sup_menu_id not like", value, "supMenuId");
            return (Criteria) this;
        }

        public Criteria andSupMenuIdIn(List<String> values) {
            addCriterion("sup_menu_id in", values, "supMenuId");
            return (Criteria) this;
        }

        public Criteria andSupMenuIdNotIn(List<String> values) {
            addCriterion("sup_menu_id not in", values, "supMenuId");
            return (Criteria) this;
        }

        public Criteria andSupMenuIdBetween(String value1, String value2) {
            addCriterion("sup_menu_id between", value1, value2, "supMenuId");
            return (Criteria) this;
        }

        public Criteria andSupMenuIdNotBetween(String value1, String value2) {
            addCriterion("sup_menu_id not between", value1, value2, "supMenuId");
            return (Criteria) this;
        }

        public Criteria andPathIncValIsNull() {
            addCriterion("path_inc_val is null");
            return (Criteria) this;
        }

        public Criteria andPathIncValIsNotNull() {
            addCriterion("path_inc_val is not null");
            return (Criteria) this;
        }

        public Criteria andPathIncValEqualTo(Integer value) {
            addCriterion("path_inc_val =", value, "pathIncVal");
            return (Criteria) this;
        }

        public Criteria andPathIncValNotEqualTo(Integer value) {
            addCriterion("path_inc_val <>", value, "pathIncVal");
            return (Criteria) this;
        }

        public Criteria andPathIncValGreaterThan(Integer value) {
            addCriterion("path_inc_val >", value, "pathIncVal");
            return (Criteria) this;
        }

        public Criteria andPathIncValGreaterThanOrEqualTo(Integer value) {
            addCriterion("path_inc_val >=", value, "pathIncVal");
            return (Criteria) this;
        }

        public Criteria andPathIncValLessThan(Integer value) {
            addCriterion("path_inc_val <", value, "pathIncVal");
            return (Criteria) this;
        }

        public Criteria andPathIncValLessThanOrEqualTo(Integer value) {
            addCriterion("path_inc_val <=", value, "pathIncVal");
            return (Criteria) this;
        }

        public Criteria andPathIncValIn(List<Integer> values) {
            addCriterion("path_inc_val in", values, "pathIncVal");
            return (Criteria) this;
        }

        public Criteria andPathIncValNotIn(List<Integer> values) {
            addCriterion("path_inc_val not in", values, "pathIncVal");
            return (Criteria) this;
        }

        public Criteria andPathIncValBetween(Integer value1, Integer value2) {
            addCriterion("path_inc_val between", value1, value2, "pathIncVal");
            return (Criteria) this;
        }

        public Criteria andPathIncValNotBetween(Integer value1, Integer value2) {
            addCriterion("path_inc_val not between", value1, value2, "pathIncVal");
            return (Criteria) this;
        }

        public Criteria andMenuPathIsNull() {
            addCriterion("menu_path is null");
            return (Criteria) this;
        }

        public Criteria andMenuPathIsNotNull() {
            addCriterion("menu_path is not null");
            return (Criteria) this;
        }

        public Criteria andMenuPathEqualTo(String value) {
            addCriterion("menu_path =", value, "menuPath");
            return (Criteria) this;
        }

        public Criteria andMenuPathNotEqualTo(String value) {
            addCriterion("menu_path <>", value, "menuPath");
            return (Criteria) this;
        }

        public Criteria andMenuPathGreaterThan(String value) {
            addCriterion("menu_path >", value, "menuPath");
            return (Criteria) this;
        }

        public Criteria andMenuPathGreaterThanOrEqualTo(String value) {
            addCriterion("menu_path >=", value, "menuPath");
            return (Criteria) this;
        }

        public Criteria andMenuPathLessThan(String value) {
            addCriterion("menu_path <", value, "menuPath");
            return (Criteria) this;
        }

        public Criteria andMenuPathLessThanOrEqualTo(String value) {
            addCriterion("menu_path <=", value, "menuPath");
            return (Criteria) this;
        }

        public Criteria andMenuPathLike(String value) {
            addCriterion("menu_path like", value, "menuPath");
            return (Criteria) this;
        }

        public Criteria andMenuPathNotLike(String value) {
            addCriterion("menu_path not like", value, "menuPath");
            return (Criteria) this;
        }

        public Criteria andMenuPathIn(List<String> values) {
            addCriterion("menu_path in", values, "menuPath");
            return (Criteria) this;
        }

        public Criteria andMenuPathNotIn(List<String> values) {
            addCriterion("menu_path not in", values, "menuPath");
            return (Criteria) this;
        }

        public Criteria andMenuPathBetween(String value1, String value2) {
            addCriterion("menu_path between", value1, value2, "menuPath");
            return (Criteria) this;
        }

        public Criteria andMenuPathNotBetween(String value1, String value2) {
            addCriterion("menu_path not between", value1, value2, "menuPath");
            return (Criteria) this;
        }

        public Criteria andLevelNumIsNull() {
            addCriterion("level_num is null");
            return (Criteria) this;
        }

        public Criteria andLevelNumIsNotNull() {
            addCriterion("level_num is not null");
            return (Criteria) this;
        }

        public Criteria andLevelNumEqualTo(Short value) {
            addCriterion("level_num =", value, "levelNum");
            return (Criteria) this;
        }

        public Criteria andLevelNumNotEqualTo(Short value) {
            addCriterion("level_num <>", value, "levelNum");
            return (Criteria) this;
        }

        public Criteria andLevelNumGreaterThan(Short value) {
            addCriterion("level_num >", value, "levelNum");
            return (Criteria) this;
        }

        public Criteria andLevelNumGreaterThanOrEqualTo(Short value) {
            addCriterion("level_num >=", value, "levelNum");
            return (Criteria) this;
        }

        public Criteria andLevelNumLessThan(Short value) {
            addCriterion("level_num <", value, "levelNum");
            return (Criteria) this;
        }

        public Criteria andLevelNumLessThanOrEqualTo(Short value) {
            addCriterion("level_num <=", value, "levelNum");
            return (Criteria) this;
        }

        public Criteria andLevelNumIn(List<Short> values) {
            addCriterion("level_num in", values, "levelNum");
            return (Criteria) this;
        }

        public Criteria andLevelNumNotIn(List<Short> values) {
            addCriterion("level_num not in", values, "levelNum");
            return (Criteria) this;
        }

        public Criteria andLevelNumBetween(Short value1, Short value2) {
            addCriterion("level_num between", value1, value2, "levelNum");
            return (Criteria) this;
        }

        public Criteria andLevelNumNotBetween(Short value1, Short value2) {
            addCriterion("level_num not between", value1, value2, "levelNum");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(Integer value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(Integer value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(Integer value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(Integer value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(Integer value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<Integer> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<Integer> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(Integer value1, Integer value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(Integer value1, Integer value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andIsFuncMenuIsNull() {
            addCriterion("is_func_menu is null");
            return (Criteria) this;
        }

        public Criteria andIsFuncMenuIsNotNull() {
            addCriterion("is_func_menu is not null");
            return (Criteria) this;
        }

        public Criteria andIsFuncMenuEqualTo(String value) {
            addCriterion("is_func_menu =", value, "isFuncMenu");
            return (Criteria) this;
        }

        public Criteria andIsFuncMenuNotEqualTo(String value) {
            addCriterion("is_func_menu <>", value, "isFuncMenu");
            return (Criteria) this;
        }

        public Criteria andIsFuncMenuGreaterThan(String value) {
            addCriterion("is_func_menu >", value, "isFuncMenu");
            return (Criteria) this;
        }

        public Criteria andIsFuncMenuGreaterThanOrEqualTo(String value) {
            addCriterion("is_func_menu >=", value, "isFuncMenu");
            return (Criteria) this;
        }

        public Criteria andIsFuncMenuLessThan(String value) {
            addCriterion("is_func_menu <", value, "isFuncMenu");
            return (Criteria) this;
        }

        public Criteria andIsFuncMenuLessThanOrEqualTo(String value) {
            addCriterion("is_func_menu <=", value, "isFuncMenu");
            return (Criteria) this;
        }

        public Criteria andIsFuncMenuLike(String value) {
            addCriterion("is_func_menu like", value, "isFuncMenu");
            return (Criteria) this;
        }

        public Criteria andIsFuncMenuNotLike(String value) {
            addCriterion("is_func_menu not like", value, "isFuncMenu");
            return (Criteria) this;
        }

        public Criteria andIsFuncMenuIn(List<String> values) {
            addCriterion("is_func_menu in", values, "isFuncMenu");
            return (Criteria) this;
        }

        public Criteria andIsFuncMenuNotIn(List<String> values) {
            addCriterion("is_func_menu not in", values, "isFuncMenu");
            return (Criteria) this;
        }

        public Criteria andIsFuncMenuBetween(String value1, String value2) {
            addCriterion("is_func_menu between", value1, value2, "isFuncMenu");
            return (Criteria) this;
        }

        public Criteria andIsFuncMenuNotBetween(String value1, String value2) {
            addCriterion("is_func_menu not between", value1, value2, "isFuncMenu");
            return (Criteria) this;
        }

        public Criteria andMenuUriIsNull() {
            addCriterion("menu_uri is null");
            return (Criteria) this;
        }

        public Criteria andMenuUriIsNotNull() {
            addCriterion("menu_uri is not null");
            return (Criteria) this;
        }

        public Criteria andMenuUriEqualTo(String value) {
            addCriterion("menu_uri =", value, "menuUri");
            return (Criteria) this;
        }

        public Criteria andMenuUriNotEqualTo(String value) {
            addCriterion("menu_uri <>", value, "menuUri");
            return (Criteria) this;
        }

        public Criteria andMenuUriGreaterThan(String value) {
            addCriterion("menu_uri >", value, "menuUri");
            return (Criteria) this;
        }

        public Criteria andMenuUriGreaterThanOrEqualTo(String value) {
            addCriterion("menu_uri >=", value, "menuUri");
            return (Criteria) this;
        }

        public Criteria andMenuUriLessThan(String value) {
            addCriterion("menu_uri <", value, "menuUri");
            return (Criteria) this;
        }

        public Criteria andMenuUriLessThanOrEqualTo(String value) {
            addCriterion("menu_uri <=", value, "menuUri");
            return (Criteria) this;
        }

        public Criteria andMenuUriLike(String value) {
            addCriterion("menu_uri like", value, "menuUri");
            return (Criteria) this;
        }

        public Criteria andMenuUriNotLike(String value) {
            addCriterion("menu_uri not like", value, "menuUri");
            return (Criteria) this;
        }

        public Criteria andMenuUriIn(List<String> values) {
            addCriterion("menu_uri in", values, "menuUri");
            return (Criteria) this;
        }

        public Criteria andMenuUriNotIn(List<String> values) {
            addCriterion("menu_uri not in", values, "menuUri");
            return (Criteria) this;
        }

        public Criteria andMenuUriBetween(String value1, String value2) {
            addCriterion("menu_uri between", value1, value2, "menuUri");
            return (Criteria) this;
        }

        public Criteria andMenuUriNotBetween(String value1, String value2) {
            addCriterion("menu_uri not between", value1, value2, "menuUri");
            return (Criteria) this;
        }

        public Criteria andMenuStyleNmIsNull() {
            addCriterion("menu_style_nm is null");
            return (Criteria) this;
        }

        public Criteria andMenuStyleNmIsNotNull() {
            addCriterion("menu_style_nm is not null");
            return (Criteria) this;
        }

        public Criteria andMenuStyleNmEqualTo(String value) {
            addCriterion("menu_style_nm =", value, "menuStyleNm");
            return (Criteria) this;
        }

        public Criteria andMenuStyleNmNotEqualTo(String value) {
            addCriterion("menu_style_nm <>", value, "menuStyleNm");
            return (Criteria) this;
        }

        public Criteria andMenuStyleNmGreaterThan(String value) {
            addCriterion("menu_style_nm >", value, "menuStyleNm");
            return (Criteria) this;
        }

        public Criteria andMenuStyleNmGreaterThanOrEqualTo(String value) {
            addCriterion("menu_style_nm >=", value, "menuStyleNm");
            return (Criteria) this;
        }

        public Criteria andMenuStyleNmLessThan(String value) {
            addCriterion("menu_style_nm <", value, "menuStyleNm");
            return (Criteria) this;
        }

        public Criteria andMenuStyleNmLessThanOrEqualTo(String value) {
            addCriterion("menu_style_nm <=", value, "menuStyleNm");
            return (Criteria) this;
        }

        public Criteria andMenuStyleNmLike(String value) {
            addCriterion("menu_style_nm like", value, "menuStyleNm");
            return (Criteria) this;
        }

        public Criteria andMenuStyleNmNotLike(String value) {
            addCriterion("menu_style_nm not like", value, "menuStyleNm");
            return (Criteria) this;
        }

        public Criteria andMenuStyleNmIn(List<String> values) {
            addCriterion("menu_style_nm in", values, "menuStyleNm");
            return (Criteria) this;
        }

        public Criteria andMenuStyleNmNotIn(List<String> values) {
            addCriterion("menu_style_nm not in", values, "menuStyleNm");
            return (Criteria) this;
        }

        public Criteria andMenuStyleNmBetween(String value1, String value2) {
            addCriterion("menu_style_nm between", value1, value2, "menuStyleNm");
            return (Criteria) this;
        }

        public Criteria andMenuStyleNmNotBetween(String value1, String value2) {
            addCriterion("menu_style_nm not between", value1, value2, "menuStyleNm");
            return (Criteria) this;
        }

        public Criteria andIsValidIsNull() {
            addCriterion("is_valid is null");
            return (Criteria) this;
        }

        public Criteria andIsValidIsNotNull() {
            addCriterion("is_valid is not null");
            return (Criteria) this;
        }

        public Criteria andIsValidEqualTo(String value) {
            addCriterion("is_valid =", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotEqualTo(String value) {
            addCriterion("is_valid <>", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThan(String value) {
            addCriterion("is_valid >", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThanOrEqualTo(String value) {
            addCriterion("is_valid >=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThan(String value) {
            addCriterion("is_valid <", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThanOrEqualTo(String value) {
            addCriterion("is_valid <=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLike(String value) {
            addCriterion("is_valid like", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotLike(String value) {
            addCriterion("is_valid not like", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidIn(List<String> values) {
            addCriterion("is_valid in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotIn(List<String> values) {
            addCriterion("is_valid not in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidBetween(String value1, String value2) {
            addCriterion("is_valid between", value1, value2, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotBetween(String value1, String value2) {
            addCriterion("is_valid not between", value1, value2, "isValid");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andInsertUserIsNull() {
            addCriterion("insert_user is null");
            return (Criteria) this;
        }

        public Criteria andInsertUserIsNotNull() {
            addCriterion("insert_user is not null");
            return (Criteria) this;
        }

        public Criteria andInsertUserEqualTo(String value) {
            addCriterion("insert_user =", value, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserNotEqualTo(String value) {
            addCriterion("insert_user <>", value, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserGreaterThan(String value) {
            addCriterion("insert_user >", value, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserGreaterThanOrEqualTo(String value) {
            addCriterion("insert_user >=", value, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserLessThan(String value) {
            addCriterion("insert_user <", value, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserLessThanOrEqualTo(String value) {
            addCriterion("insert_user <=", value, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserLike(String value) {
            addCriterion("insert_user like", value, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserNotLike(String value) {
            addCriterion("insert_user not like", value, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserIn(List<String> values) {
            addCriterion("insert_user in", values, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserNotIn(List<String> values) {
            addCriterion("insert_user not in", values, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserBetween(String value1, String value2) {
            addCriterion("insert_user between", value1, value2, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserNotBetween(String value1, String value2) {
            addCriterion("insert_user not between", value1, value2, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNull() {
            addCriterion("insert_time is null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNotNull() {
            addCriterion("insert_time is not null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeEqualTo(Date value) {
            addCriterion("insert_time =", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotEqualTo(Date value) {
            addCriterion("insert_time <>", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThan(Date value) {
            addCriterion("insert_time >", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("insert_time >=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThan(Date value) {
            addCriterion("insert_time <", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThanOrEqualTo(Date value) {
            addCriterion("insert_time <=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIn(List<Date> values) {
            addCriterion("insert_time in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotIn(List<Date> values) {
            addCriterion("insert_time not in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeBetween(Date value1, Date value2) {
            addCriterion("insert_time between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotBetween(Date value1, Date value2) {
            addCriterion("insert_time not between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andMenuEncryptLikeInsensitive(String value) {
            addCriterion("upper(menu_encrypt) like", value.toUpperCase(), "menuEncrypt");
            return (Criteria) this;
        }

        public Criteria andMenuNmLikeInsensitive(String value) {
            addCriterion("upper(menu_nm) like", value.toUpperCase(), "menuNm");
            return (Criteria) this;
        }

        public Criteria andSupMenuIdLikeInsensitive(String value) {
            addCriterion("upper(sup_menu_id) like", value.toUpperCase(), "supMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuPathLikeInsensitive(String value) {
            addCriterion("upper(menu_path) like", value.toUpperCase(), "menuPath");
            return (Criteria) this;
        }

        public Criteria andIsFuncMenuLikeInsensitive(String value) {
            addCriterion("upper(is_func_menu) like", value.toUpperCase(), "isFuncMenu");
            return (Criteria) this;
        }

        public Criteria andMenuUriLikeInsensitive(String value) {
            addCriterion("upper(menu_uri) like", value.toUpperCase(), "menuUri");
            return (Criteria) this;
        }

        public Criteria andMenuStyleNmLikeInsensitive(String value) {
            addCriterion("upper(menu_style_nm) like", value.toUpperCase(), "menuStyleNm");
            return (Criteria) this;
        }

        public Criteria andIsValidLikeInsensitive(String value) {
            addCriterion("upper(is_valid) like", value.toUpperCase(), "isValid");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(remark) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }

        public Criteria andInsertUserLikeInsensitive(String value) {
            addCriterion("upper(insert_user) like", value.toUpperCase(), "insertUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLikeInsensitive(String value) {
            addCriterion("upper(update_user) like", value.toUpperCase(), "updateUser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}