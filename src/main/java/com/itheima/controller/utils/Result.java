package com.itheima.controller.utils;

import org.springframework.stereotype.Component;


public class Result {
    private boolean flag;
    private Object data;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public Result(boolean flag, Object data, String msg) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result(String msg) {
        this.msg = msg;
        this.flag = false;
    }

    public Result(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public Result(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public Result(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Result{" +
                "flag=" + flag +
                ", data=" + data +
                '}';
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
