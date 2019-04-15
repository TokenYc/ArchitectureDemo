package com.qianfanyun.module_base.api;

/**
 * @author ArcherYc
 * @date on 2019/4/12  13:59
 * @mail 247067345@qq.com
 */
public class ApiException extends Exception{
    private int status;

    public ApiException(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
