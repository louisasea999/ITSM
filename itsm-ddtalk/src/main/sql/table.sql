set search_path to "itsm2";

drop table Dining_Desk_Map;

drop table Dining_Room;

drop table District_Group_Map;

drop table District_Info;

drop table Emplee_Info;

drop table Event_Type;

drop table Order_Event_Flow;

drop table Order_Event_Info;

drop table Order_Event_Reject;

drop table Service_Desk;

drop table Sup_Project_Group;

/*==============================================================*/
/* Table: Dining_Desk_Map                                       */
/*==============================================================*/
create table Dining_Desk_Map (
   Dining_Desk_ID       BIGSERIAL            not null,
   Dining_Room_ID       INT8                 null,
   Service_Desk_ID      INT8                 null,
   Remark               VARCHAR(512)         null,
   constraint PK_DINING_DESK_MAP primary key (Dining_Desk_ID)
);

comment on table Dining_Desk_Map is
'门店与服务站关联表';

comment on column Dining_Desk_Map.Dining_Desk_ID is
'主健ID';

comment on column Dining_Desk_Map.Dining_Room_ID is
'门店ID';

comment on column Dining_Desk_Map.Service_Desk_ID is
'服务站ID';

comment on column Dining_Desk_Map.Remark is
'备注';

/*==============================================================*/
/* Table: Dining_Room                                           */
/*==============================================================*/
create table Dining_Room (
   Dining_Room_ID       INT8                 not null,
   Dining_Room_Name     VARCHAR(200)         null,
   District_ID          INT8                 null,
   constraint PK_DINING_ROOM primary key (Dining_Room_ID)
);

comment on table Dining_Room is
'餐厅表';

comment on column Dining_Room.Dining_Room_ID is
'餐厅ID';

comment on column Dining_Room.Dining_Room_Name is
'餐厅名称';

comment on column Dining_Room.District_ID is
'区域ID';

/*==============================================================*/
/* Table: District_Group_Map                                    */
/*==============================================================*/
create table District_Group_Map (
   District_Group_ID    BIGSERIAL            not null,
   District_ID          INT8                 null,
   Sup_Project_Group_ID INT8                 null,
   Remark               VARCHAR(200)         null,
   constraint PK_DISTRICT_GROUP_MAP primary key (District_Group_ID)
);

comment on table District_Group_Map is
'区域与服务商关联表';

comment on column District_Group_Map.District_Group_ID is
'主健ID';

comment on column District_Group_Map.District_ID is
'区域ID';

comment on column District_Group_Map.Sup_Project_Group_ID is
'服务商项目组ID';

comment on column District_Group_Map.Remark is
'备注';

/*==============================================================*/
/* Table: District_Info                                         */
/*==============================================================*/
create table District_Info (
   District_ID          INT8                 not null,
   District_Name        VARCHAR(100)         null,
   constraint PK_DISTRICT_INFO primary key (District_ID)
);

comment on table District_Info is
'区域表';

comment on column District_Info.District_ID is
'区域ID';

comment on column District_Info.District_Name is
'区域名称';

/*==============================================================*/
/* Table: Emplee_Info                                           */
/*==============================================================*/
create table Emplee_Info (
   Emplee_ID            VARCHAR(64)          not null,
   Emplee_Name          VARCHAR(100)         null,
   Service_Desk_ID      INT8                 null,
   Remark               VARCHAR(512)         null,
   constraint PK_EMPLEE_INFO primary key (Emplee_ID)
);

comment on table Emplee_Info is
'工程师表';

comment on column Emplee_Info.Emplee_ID is
'工程师ID';

comment on column Emplee_Info.Emplee_Name is
'工程师名称';

comment on column Emplee_Info.Service_Desk_ID is
'服务站ID';

comment on column Emplee_Info.Remark is
'备注';

/*==============================================================*/
/* Table: Event_Type                                            */
/*==============================================================*/
create table Event_Type (
   Event_Type_ID        INT4                 null,
   Event_Type_Name      VARCHAR(100)         null,
   Remark               VARCHAR(200)         null
);

comment on table Event_Type is
'案件类别表';

comment on column Event_Type.Event_Type_ID is
'案件类别ID';

comment on column Event_Type.Event_Type_Name is
'案件类别名称';

comment on column Event_Type.Remark is
'备注';

/*==============================================================*/
/* Table: Order_Event_Flow                                      */
/*==============================================================*/
create table Order_Event_Flow (
   Event_Flow_ID        INT4                 null,
   Order_Event_ID       INT4                 null,
   Answer_Number        INT2                 null,
   Emplee_ID            INT4                 null,
   SLA_Start_Time       TIMESTAMP            null,
   Stop_Com_Time_Status CHAR(2)              null,
   Stop_Com_Time_Reason VARCHAR(200)         null,
   Stop_Com_Time        TIMESTAMP            null,
   Re_Start_Time        TIMESTAMP            null,
   IT_Agree_Stop_Status CHAR                 null,
   SLA_End_Time         TIMESTAMP            null
);

comment on table Order_Event_Flow is
'事件处理流程表';

comment on column Order_Event_Flow.Event_Flow_ID is
'主键ID';

comment on column Order_Event_Flow.Order_Event_ID is
'派单事件ID(或者单号）';

comment on column Order_Event_Flow.Answer_Number is
'处理序号,默认值为0，即正常流程。
一个人可能因为不结案而处理多次，即多条记录。
1：第一次不同意结案
2：第二次不同意结案';

comment on column Order_Event_Flow.Emplee_ID is
'处理人,即工程师';

comment on column Order_Event_Flow.SLA_Start_Time is
'开始处理时间';

comment on column Order_Event_Flow.Stop_Com_Time_Status is
'是否停表';

comment on column Order_Event_Flow.Stop_Com_Time_Reason is
'停表原因';

comment on column Order_Event_Flow.Stop_Com_Time is
'停表时间';

comment on column Order_Event_Flow.Re_Start_Time is
'重新开表时间';

comment on column Order_Event_Flow.IT_Agree_Stop_Status is
'IT是否同意停表';

comment on column Order_Event_Flow.SLA_End_Time is
'提交结案申请时间';

/*==============================================================*/
/* Table: Order_Event_Info                                      */
/*==============================================================*/
create table Order_Event_Info (
   Order_Event_ID       INT4                 null,
   Order_Event_Time     TIMESTAMP            null,
   Operator             VARCHAR(50)          null,
   Dining_Room_ID       INT4                 null,
   Event_Type_ID        INT4                 null,
   Din_Dining_Room_ID   INT8                 null,
   Level_Status         INT2                 null,
   Sup_Project_Group_ID INT4                 null,
   Order_Event_Respond_Time TIMESTAMP            null,
   Status               INT2                 null
);

comment on table Order_Event_Info is
'派单事件表';

comment on column Order_Event_Info.Order_Event_ID is
'派单事件ID(或者单号）';

comment on column Order_Event_Info.Order_Event_Time is
'派单时间';

comment on column Order_Event_Info.Operator is
'派单人, 甲方人员';

comment on column Order_Event_Info.Dining_Room_ID is
'餐厅ID';

comment on column Order_Event_Info.Event_Type_ID is
'案件类别ID';

comment on column Order_Event_Info.Din_Dining_Room_ID is
'餐厅ID';

comment on column Order_Event_Info.Level_Status is
'该单优先级
1.一般级别
2. 加急级别
3.特急级别';

comment on column Order_Event_Info.Sup_Project_Group_ID is
'派给哪个服务商ID';

comment on column Order_Event_Info.Order_Event_Respond_Time is
'响应时间：回单或者处理时间';

comment on column Order_Event_Info.Status is
'派单状态
1. 未接单
2. 已回单
3. 已回单转派
4. 已回单取消
5. 处理中
6.已完成（结案）';

/*==============================================================*/
/* Table: Order_Event_Reject                                    */
/*==============================================================*/
create table Order_Event_Reject (
   Order_Event_ID       INT4                 null,
   Emplee_ID            INT4                 null,
   Answer_Time          TIMESTAMP            null,
   Answer_Content       VARCHAR(200)         null
);

comment on table Order_Event_Reject is
'派单事件回单表';

comment on column Order_Event_Reject.Order_Event_ID is
'派单事件ID(或者单号）';

comment on column Order_Event_Reject.Emplee_ID is
'回单人,即工程师';

comment on column Order_Event_Reject.Answer_Time is
'回单时间';

comment on column Order_Event_Reject.Answer_Content is
'回单内容';

/*==============================================================*/
/* Table: Service_Desk                                          */
/*==============================================================*/
create table Service_Desk (
   Service_Desk_ID      INT8                 not null,
   Service_Desk_Name    VARCHAR(100)         null,
   Sup_Project_Group_ID INT8                 null,
   Remark               VARCHAR(512)         null,
   constraint PK_SERVICE_DESK primary key (Service_Desk_ID)
);

comment on table Service_Desk is
'服务站(群组)表';

comment on column Service_Desk.Service_Desk_ID is
'服务站ID';

comment on column Service_Desk.Service_Desk_Name is
'服务站名称';

comment on column Service_Desk.Sup_Project_Group_ID is
'服务商项目组ID';

comment on column Service_Desk.Remark is
'备注';

/*==============================================================*/
/* Table: Sup_Project_Group                                     */
/*==============================================================*/
create table Sup_Project_Group (
   Sup_Project_Group_ID INT8                 not null,
   Sup_Project_Group_Name VARCHAR(100)         null,
   Remark               VARCHAR(512)         null,
   constraint PK_SUP_PROJECT_GROUP primary key (Sup_Project_Group_ID)
);

comment on table Sup_Project_Group is
'服务商项目组表';

comment on column Sup_Project_Group.Sup_Project_Group_ID is
'服务商项目组ID';

comment on column Sup_Project_Group.Sup_Project_Group_Name is
'服务商项目组名称';

comment on column Sup_Project_Group.Remark is
'备注';
