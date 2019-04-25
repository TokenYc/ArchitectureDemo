package com.qianfanyun.module_base.base;

/**
 * @author ArcherYc
 * @date on 2019/4/24  16:17
 * @mail 247067345@qq.com
 */
public interface IModel {

    /**
     * 用于清除引用，防止内存泄漏
     */
    void onClear();
}
