package debug;

import android.app.Application;

import com.billy.cc.core.component.CC;
import com.qianfanyun.module_recyclerview.BuildConfig;

/**
 * @author ArcherYc
 * @date on 2019/4/1  9:21 AM
 * @mail 247067345@qq.com
 */
public class DebugApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CC.enableDebug(BuildConfig.DEBUG);
        CC.enableVerboseLog(BuildConfig.DEBUG);
        CC.enableRemoteCC(BuildConfig.DEBUG);
    }
}
