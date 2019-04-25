package com.qianfanyun.module_login;

/**
 * @author ArcherYc
 * @date on 2019/4/24  16:34
 * @mail 247067345@qq.com
 */
public interface LocalDataSource {

    /**
     * 获取用户名字
     * @return
     */
    String getName();

    /**
     * 将用户名保存到本地
     * @return
     */
    String setName(String name);
}
