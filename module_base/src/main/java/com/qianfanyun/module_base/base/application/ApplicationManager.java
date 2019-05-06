package com.qianfanyun.module_base.base.application;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArcherYc
 * @date on 2019/5/6  16:27
 * @mail 247067345@qq.com
 */
public class ApplicationManager {

    private static List<IApplication> applicationList = new ArrayList<>();

    private static void register(IApplication iApplication) {
        if (iApplication != null) {
            applicationList.add(iApplication);
        }
    }

    public static void init() {
        for (IApplication application : applicationList) {
            application.init();
        }
    }

}
