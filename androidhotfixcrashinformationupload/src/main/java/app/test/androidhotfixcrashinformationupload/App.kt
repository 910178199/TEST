package app.test.androidhotfixcrashinformationupload

import android.app.Application
import app.test.androidhotfixcrashinformationupload.crashLog.ExceptionCrashHandler

/**
 * @name TEST
 * @class name：app.test.androidhotfixcrashinformationupload
 * @class describe :
 * @author think
 * @time 2018-02-02 13:56
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        //初始化异常
        ExceptionCrashHandler.instance.init(this)
    }

}