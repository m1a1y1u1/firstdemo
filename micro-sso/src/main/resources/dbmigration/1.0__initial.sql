-- apply changes
create table user (
  id                            bigint auto_increment not null,
  name                          varchar(255) comment '用户名',
  nick_name                     varchar(255) comment '昵称',
  password                      varchar(255) comment '密码',
  ages                          integer comment '年龄',
  gender                        integer comment '性别',
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_modified                 datetime(6) not null,
  who_created                   varchar(255) not null,
  who_modified                  varchar(255) not null,
  deleted                       tinyint(1) default 0 not null,
  constraint pk_user primary key (id)
) comment='基础用户表';

