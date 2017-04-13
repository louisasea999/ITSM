package com.yum.itsm.ddtalk.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Constants {
    public static final String USER_NAME = "userName";
    public static final String WEBSOCKET_USERNAME = "webSocketUserName";
    public static final String CONNECTION_TYPE = "connectionType";
    public static final String WEBSOCKET_CONNECTION_TYPE = "webSocketConnectionType";
    public static final String CONNECTION_TYPE_MONITOR = "monitor";
    public static final String SUCCESS = "success";
    public static final Integer MONITOR_STATUS_ACTIVED = 1;
    public static final Integer MONITOR_STATUS_COMPLETED = 10;
    public static final Integer COMPLETE_TYPE_NORMAL = 0;
    public static final Integer COMPLETE_TYPE_AUTO = 1;
    public static final String SUB_TYPE_ALARM_CENTER = "AlarmCenter";
    public static final Long RECEIVER_TYPE_ORG = 1L;
    public static final Long RECEIVER_TYPE_ROLE = 2L;
    public static final Long RECEIVER_TYPE_USER = 3L;

    private static final GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static final Gson GSON = GSON_BUILDER.create();

    public static final String URL_GET_USERS_FROM_ROLE = "http://15.114.116.188/g1/service/common/orgman/usermgmt/getRole";
    public static final String URL_GET_USERS_FROM_POSITION = "http://15.114.116.188/g1/service/common/orgman/conf/getResourceListFromOrg";
    public static final String URL_SEND_MAIL = "http://15.114.116.188/g1/service/af/salesmgmt/rest/sendmail/common";
    public static final String URL_GET_USER = "http://15.114.116.188/g1/service/common/orgman/usermgmt/getEntireUsers";

    /**
     * 猫头鹰
     */
    public static final Integer NOTIFICATION_TYPE_0 = 0;
    /**
     * 猫头鹰+邮件通知
     */
    public static final Integer NOTIFICATION_TYPE_1 = 1;
    /**
     * 频率:年
     */
    public static final Integer FREQUENCY_EACH_YEAR = 1;
    /**
     * 频率:月
     */
    public static final Integer FREQUENCY_EACH_MONTH = 2;
    /**
     * 频率:周
     */
    public static final Integer FREQUENCY_EACH_WEEK = 3;
    /**
     * 频率:天
     */
    public static final Integer FREQUENCY_EACH_DAY = 4;
    /**
     * 频率:季
     */
    public static final Integer FREQUENCY_EACH_QUARTER = 5;
    public static final Integer QUARTER_MONTH_MAR = 3;
    public static final Integer QUARTER_DATE_MAR = 31;
    public static final Integer QUARTER_MONTH_JUN = 6;
    public static final Integer QUARTER_DATE_JUN = 30;
    public static final Integer QUARTER_MONTH_SEP = 9;
    public static final Integer QUARTER_DATE_SEP = 30;
    public static final Integer QUARTER_MONTH_DEC = 12;
    public static final Integer QUARTER_DATE_DEC = 31;

    /**
     * 规则:删除
     */
    public static final Integer RULE_STATUS_DELETE = -1;
    /** 
     * 规则:停用
     */
    public static final Integer RULE_STATUS_DISABLE = 0;
    /**
     * 规则:草稿
     */
    public static final Integer RULE_STATUS_DRAFT = 1;
    /**
     * 规则:生效
     */
    public static final Integer RULE_STATUS_ACTIVE = 2;
    /**
     * ETL:失败
     */
    public static final Integer ETL_STATUS_FAILURE = -1;
    /**
     * ETL:执行中
     */
    public static final Integer ETL_STATUS_RUNNING = 0;
    /**
     * ETL:完成
     */
    public static final Integer ETL_STATUS_SUCCESS = 1;
    /**
     * MAIL:失败
     */
    public static final Integer MAIL_STATUS_FAILURE = -1;
    /**
     * MAIL:执行中
     */
    public static final Integer MAIL_STATUS_RUNNING = 0;
    /**
     * MAIL:完成
     */
    public static final Integer MAIL_STATUS_SUCCESS = 1;

    /**
     * MAIL任务失败
     */
    public static final int ORDER_SWITCH_MAIL_FAIL = -2;
    /**
     * ETL任务失败
     */
    public static final int ORDER_SWITCH_ETL_FAIL = -1;
    /**
     * ETL任务执行中
     */
    public static final int ORDER_SWITCH_ETL_ING = 1;
    /**
     * ETL任务执行完成
     */
    public static final int ORDER_SWITCH_ETL_OK = 2;
    /**
     * MAIL任务执行中
     */
    public static final int ORDER_SWITCH_MAIL_ING = 3;
    /**
     * MAIL任务执行完成
     */
    public static final int ORDER_SWITCH_MAIL_OK = 4;
    
    /**
     * 猫头鹰通知
     */
    public static final Integer NOTIFICATION_TYPE_NORMAL = 0;
    /**
     * 邮件通知
     */
    public static final Integer NOTIFICATION_TYPE_EMAIL = 1;

    /**
     * 邮件通知标题
     */
    public static final String MAIL_SUBJECT = 
    		"(CIIC G1) 您有一份告警信息,请进入系统查看";
    /**
     * 邮件通知内容
     */
    public static final String MAIL_CONTEXT = 
    		"(CIIC G1) 您有一份告警信息,请进入系统查看";
    
    /**
     * 条件选项值:当天
     */
    public static final String COND_OPT_DAY = "D";
    /**
     * 条件选项值:当月
     */
    public static final String COND_OPT_MONTH = "M";
    /**
     * 条件选项值:其他
     */
    public static final String COND_OPT_OTHER = "O";
}
