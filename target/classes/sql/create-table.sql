create table IF NOT EXISTS homebroadcast
(
    broadCastId   int auto_increment comment '广播Id'
    primary key,
    broadCastText varchar(50) null comment '广播文本',
    constraint homeBroadCast_broadCastId_uindex
    unique (broadCastId)
    );

create table IF NOT EXISTS logincheck
(
    attribute varchar(30) not null comment '属性名'
    primary key,
    value     varchar(50) null comment '属性名对应的值',
    constraint logincheck_attribute_uindex
    unique (attribute)
    );

create table IF NOT EXISTS operate_log
(
    id            int unsigned auto_increment comment 'ID'
    primary key,
    operate_user  int unsigned  null comment '操作人ID',
    operate_time  datetime      null comment '操作时间',
    class_name    varchar(100)  null comment '操作的类名',
    method_name   varchar(100)  null comment '操作的方法名',
    method_params varchar(1000) null comment '方法参数',
    return_value  varchar(2000) null comment '返回值',
    cost_time     bigint        null comment '方法执行耗时, 单位:ms'
    )
    comment '操作日志表';

create table IF NOT EXISTS usertable
(
    nameId       int auto_increment comment 'name 的 id'
    primary key,
    name         varchar(20)                                    not null comment '唯一',
    password     varchar(20) default '123456'                   null comment '用户密码',
    userText     text                                           null comment '用户的介绍',
    userImage    text                                           null,
    credit       int         default 0                          not null comment '积分',
    updateTime   datetime                                       null comment '更新时间',
    remindText   text                                           null comment '用户提醒文案',
    remindSwitch tinyint     default 0                          null comment '提醒开关',
    remindTime   varchar(20) default '0 30 11 * * ?'            null comment '提醒时间',
    registerTime datetime                                       null comment '注册时间',
    displayItem  varchar(10) default '♥在一起'                     null comment '展示事件',
    displayDay   varchar(20) default '2022-10-06'               not null comment '展示事件时间',
    displayLogo  varchar(20) default '?捏捏的魔仙堡'                  not null comment '展示logo',
    displayUrl   varchar(50) default 'http://121.37.243.173/#/' not null comment '展示二维码内容',
    constraint usertable_nameId_uindex
    unique (nameId),
    constraint usertable_name_uindex
    unique (name)
    );

create table IF NOT EXISTS detailusertable
(
    userId          int auto_increment comment '用户ID'
    primary key,
    useName         varchar(10)   not null comment '用户名',
    allCredit       int default 0 null comment '用户获得积分总数',
    dayCredit       int default 0 null comment '用户今日获得积分',
    allCompleteTask int default 0 null comment '用户完成任务总数',
    dayCompleteTask int default 0 null comment '用户每日完成任务数',
    allAddTask      int default 0 null comment '添加任务总数',
    dayAddTask      int default 0 null comment '用户每日新增任务数',
    allAddProduce   int default 0 null comment '增加商品总数',
    dayAddProduce   int default 0 null comment '用户每日新增商品数',
    allBuyProduce   int default 0 null comment '购买商品总数',
    dayBuyProduce   int default 0 null comment '用户每日新增购买商品数',
    dayReduceRoom   int default 0 null comment '用户每日新增兑换商品数',
    allReduceRoom   int default 0 null comment '兑换商品总数',
    constraint detailUserTable_userId_uindex
    unique (userId),
    constraint detailusertable_useName_uindex
    unique (useName),
    constraint detailusertable_usertable_name_fk
    foreign key (useName) references usertable (name)
    on update cascade on delete cascade
    );

create table IF NOT EXISTS producetable
(
    produceId     int auto_increment comment '商品ID',
    produceName   varchar(50)          not null comment '商品名字',
    founderId     int                  not null comment '商品创始人',
    produceText   varchar(100)         null comment '商品简介',
    produceImage  text                 null comment '商品图片地址',
    produceCredit int                  null comment '单个任务积分',
    produceNum    tinyint    default 1 null comment '商品数量,默认为1',
    customer      varchar(20)          not null comment '出售商品人名字',
    updateTime    datetime             null comment '更新商品时间',
    registerTime  datetime             null comment '注册商品时间',
    checkLove     tinyint(1) default 0 null comment '商品是否收藏',
    constraint producetable_produceId_uindex
    unique (produceId),
    constraint producetable_usertable_name_fk
    foreign key (customer) references usertable (name)
    on update cascade on delete cascade
    );

create table IF NOT EXISTS roomtable
(
    produceId    int auto_increment comment '商品代号',
    founderId    int                  not null comment '商品拥有者',
    produceName  varchar(20)          not null comment '商品名称',
    produceText  varchar(100)         null comment '商品详情',
    produceImage text                 null comment '商品图片',
    produceNum   int        default 0 not null comment '商品数量',
    checkProduce tinyint(1) default 0 not null comment '判断任务是否核对',
    useName      varchar(20)          not null comment '商品所有人',
    updateTime   datetime             null comment '商品更新时间',
    registerTime datetime             not null comment '商品注册时间'
    primary key,
    checkLove    tinyint(1) default 0 null comment '商品是否收藏',
    constraint roomtable_produceId_uindex
    unique (produceId),
    constraint roomtable_registerTime_uindex
    unique (registerTime),
    constraint roomtable_usertable_name_fk
    foreign key (useName) references usertable (name)
    on update cascade on delete cascade
    );

create table IF NOT EXISTS tasktable
(
    taskId       int auto_increment comment '任务编号'
    primary key,
    founderId    int                  not null comment '任务创建者ID',
    useName      varchar(20)          not null comment '发起任务的人',
    taskName     varchar(100)         not null comment '任务名称',
    taskText     varchar(200)         null comment '任务备注',
    taskCredit   int        default 0 null comment '任务积分',
    updateTime   datetime             null comment '任务更新时间',
    registerTime datetime             null comment '任务创建时间',
    checkTask    tinyint(1) default 0 null comment '任务是否完成',
    checkLove    tinyint    default 0 null comment '是否收藏',
    constraint tasktable_usertable_name_fk
    foreign key (useName) references usertable (name)
    on update cascade on delete cascade
    );

create table IF NOT EXISTS temtasktable
(
    taskId       int auto_increment comment '任务编号'
    primary key,
    founderId    int                  not null comment '任务创建者ID',
    useName      varchar(20)          not null comment '发起任务的人',
    taskName     varchar(100)         not null comment '任务名称',
    taskText     varchar(200)         null comment '任务备注',
    taskCredit   int        default 0 null comment '任务积分',
    updateTime   datetime             null comment '任务更新时间',
    registerTime datetime             null comment '任务创建时间',
    checkTask    tinyint(1) default 0 null comment '任务是否完成',
    checkLove    tinyint    default 0 null comment '是否收藏',
    constraint temTasktable_usertable_name_fk
    foreign key (useName) references usertable (name)
    on update cascade on delete cascade
    );

INSERT IGNORE INTO webserver.logincheck (attribute, value) VALUES ('loginCheck', '小羊是帅哥');
INSERT IGNORE INTO webserver.logincheck (attribute, value) VALUES ('wechatNoticeKey', 'ff0a6573-0b5e-432c-b22a-0kjhk399a1275');