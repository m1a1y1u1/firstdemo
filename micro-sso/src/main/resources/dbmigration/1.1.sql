-- apply changes
create table swagger_client (
  id                            bigint auto_increment not null,
  register_manage_api           varchar(255) comment '将当前服务注册到swagger管理平台的接口',
  title                         varchar(255) comment '工程标题',
  description                   varchar(255) comment '工程描述',
  api_version                   varchar(255) comment 'api doc 版本',
  profile                       varchar(255) comment 'api doc 版本',
  call_back_host                varchar(255) comment 'api doc json 拉取地址',
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_modified                 datetime(6) not null,
  who_created                   varchar(255) not null,
  who_modified                  varchar(255) not null,
  deleted                       tinyint(1) default 0 not null,
  constraint pk_swagger_client primary key (id)
) comment='Swagger2 client 注册信息实体类';

