package com.qianfanyun.module_base.utils;

/**
 * @author ArcherYc
 * @date on 2019/4/2  8:41 AM
 * @mail 247067345@qq.com
 */
public class ClickUtils {
    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 800) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}
