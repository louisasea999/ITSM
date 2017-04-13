package com.yum.itsm.ddtalk.busi.dto;

/**
 * Created by liangjuzheng on 16/10/19.
 */
public class MsgDTO {
    public final static String STATUS_OK = "ok";
    public final static String STATUS_FAIL = "fail";

    private String status = STATUS_OK;// fail
    private String message = "";
    private Object data = null;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
