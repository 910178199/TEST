package app.test.androidhotfixcrashinformationupload.crashLog

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.PrintWriter
import java.io.StringWriter
import java.text.SimpleDateFormat
import java.util.*

/**
 * @name TEST
 * @class name：app.test.androidhotfixcrashinformationupload.crashLog
 * @class describe :
 * @author think
 * @time 2018-02-02 10:56
 */
class ExceptionCrashHandler : Thread.UncaughtExceptionHandler {

    private object Holder {
        val INSTANCE = ExceptionCrashHandler()
    }

    companion object {
        val instance: ExceptionCrashHandler by lazy { Holder.INSTANCE }
    }

    val TAG: String = ExceptionCrashHandler::class.simpleName!!
    lateinit var mDefaultHandler: Thread.UncaughtExceptionHandler
    lateinit var context: Context

    constructor() {}

    fun init(context: Context) {
        //设置未捕获异常的Handler
        Thread.currentThread().setUncaughtExceptionHandler(this)
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        this.context = context
    }

    override fun uncaughtException(t: Thread?, e: Throwable?) {
        Log.d(TAG, "拦截异常：" + e)
        if (e != null) {
            //写入崩溃信息到文件
            val crashFileName = saveInfoToSD(e)
            if (crashFileName != null) {
                //缓存崩溃日志文件
                cacheCrashFile(crashFileName)
            }
        }
        mDefaultHandler.uncaughtException(t, e)
    }

    /**
     * 获取崩溃文件名称
     *
     * @return
     */
    val crashFile: File
        get() {
            val crashFileName = context!!.getSharedPreferences("crash",
                    Context.MODE_PRIVATE).getString("CRASH_FILE_NAME", "")
            return File(crashFileName!!)
        }

    /**
     * 缓存崩溃日志文件
     *
     * @param fileName
     */
    private fun cacheCrashFile(fileName: String) {
        val sp = context!!.getSharedPreferences("crash", Context.MODE_PRIVATE)
        sp.edit().putString("CRASH_FILE_NAME", fileName).commit()
    }

    /**
     * 保存获取的 软件信息，设备信息和出错信息保存在SDcard中
     *
     * @param ex
     * @return
     */
    private fun saveInfoToSD(ex: Throwable): String? {
        var fileName: String? = null
        val sb = StringBuffer()

        for ((key, value) in obtainSimpleInfo(context)) {
            sb.append(key).append(" = ").append(value).append("\n")
        }

        sb.append(obtainExceptionInfo(ex))

        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            val dir = File(context!!.filesDir.toString() + File.separator + "crash"
                    + File.separator)

            // 先删除之前的异常信息
            if (dir.exists()) {
                deleteFile(dir)
            }

            // 再从新创建文件夹
            if (!dir.exists()) {
                dir.mkdir()
            }
            try {
                fileName = (dir.toString() + File.separator
                        + getAssignTime("yyyy_MM_dd_HH_mm") + ".txt")
                val fos = FileOutputStream(fileName)
                fos.write(sb.toString().toByteArray())
                fos.flush()
                fos.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        return fileName
    }

    /**
     * 返回当前日期根据格式
     */
    private fun getAssignTime(dateFormatStr: String): String {
        val dataFormat = SimpleDateFormat(dateFormatStr)
        val currentTime = System.currentTimeMillis()
        return dataFormat.format(currentTime)
    }


    /**
     * 获取一些简单的信息,软件版本，手机版本，型号等信息存放在HashMap中
     *
     * @return
     */
    private fun obtainSimpleInfo(context: Context?): HashMap<String, String> {
        val map = HashMap<String, String>()
        val mPackageManager = context!!.packageManager
        var mPackageInfo: PackageInfo? = null
        try {
            mPackageInfo = mPackageManager.getPackageInfo(
                    context.packageName, PackageManager.GET_ACTIVITIES)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        map["versionName"] = mPackageInfo!!.versionName
        map["versionCode"] = "" + mPackageInfo.versionCode
        map["MODEL"] = "" + Build.MODEL
        map["SDK_INT"] = "" + Build.VERSION.SDK_INT
        map["PRODUCT"] = "" + Build.PRODUCT
        map["MOBLE_INFO"] = mobileInfo
        return map
    }


    /**
     * 获取系统未捕捉的错误信息
     *
     * @param throwable
     * @return
     */
    private fun obtainExceptionInfo(throwable: Throwable): String {
        val stringWriter = StringWriter()
        val printWriter = PrintWriter(stringWriter)
        throwable.printStackTrace(printWriter)
        printWriter.close()
        return stringWriter.toString()
    }

    private fun deleteFile(file: File) {
        if (file.isDirectory) {
            val files = file.listFiles()
            for (i in files.indices) {
                val f = files[i]
                deleteFile(f)
            }
            file.delete()//如要保留文件夹，只删除文件，请注释这行
        } else if (file.exists()) {
            file.delete()
        }
    }


    /**
     * 获取手机信息
     * @return
     */
    val mobileInfo: String
        get() {
            val sb = StringBuffer()
            try {
                val fields = Build::class.java.declaredFields
                for (field in fields) {
                    field.isAccessible = true
                    val name = field.name
                    val value = field.get(null).toString()
                    sb.append(name + "=" + value)
                    sb.append("\n")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return sb.toString()
        }
}
