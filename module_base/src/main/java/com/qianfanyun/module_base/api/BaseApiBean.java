package com.qianfanyun.module_base.api;

/**
 * @author ArcherYc
 * @date on 2019/4/12  10:53
 * @mail 247067345@qq.com
 */
public class BaseApiBean<T> {
    private int status;
    private T content;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
