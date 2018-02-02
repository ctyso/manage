drop table if exists t_sys_menu;

/*==============================================================*/
/* Table: t_sys_menu                                            */
/*==============================================================*/
create table t_sys_menu
(
   id                   VARCHAR(32) not null comment '主键',
   menu_encrypt         VARCHAR(10) comment '菜单编码',
   menu_nm              VARCHAR(60) comment '菜单名称',
   sup_menu_id          VARCHAR(32) comment '上级菜单编号',
   path_inc_val         INT4 comment '路径递增值',
   menu_path            VARCHAR(120) comment '菜单路径',
   level_num            INT2 comment '层级',
   order_no             INT4 comment '同层排序序号',
   is_func_menu         VARCHAR(8) comment '是否功能菜单',
   menu_uri             VARCHAR(120) comment '菜单URI',
   menu_style_nm        VARCHAR(50) comment '菜单样式名称',
   is_valid             VARCHAR(8) comment '是否有效',
   remark               VARCHAR(500) comment '备注',
   insert_user          VARCHAR(32) comment '新增数据人员',
   insert_time          TIMESTAMP comment '新增数据时间',
   update_user          VARCHAR(32) comment '更新数据人员',
   update_time          TIMESTAMP comment '更新数据时间',
   primary key (id)
);

alter table t_sys_menu comment '08-系统管理-菜单表';
