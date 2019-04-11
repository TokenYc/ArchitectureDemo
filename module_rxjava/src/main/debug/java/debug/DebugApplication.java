package debug;

import android.app.Application;

import com.billy.cc.core.component.CC;
import com.qianfanyun.module_rxjava.BuildConfig;

/**
 * @author ArcherYc
 * @date on 2019/3/29  3:36 PM
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
