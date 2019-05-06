package com.qianfanyun.module_base.base.application;

/**
 * @author ArcherYc
 * @date on 2019/5/6  16:25
 * @mail 247067345@qq.com
 */
public interface IApplication {

    /**
     * 当前Module的Application是否是调试模式
     * @return
     */
    boolean isDebug();

    /**
     * Module单独使用到的初始化在这里进行
     */
    void init();
}
