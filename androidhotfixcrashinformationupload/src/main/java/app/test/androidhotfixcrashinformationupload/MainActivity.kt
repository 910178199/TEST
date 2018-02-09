package app.test.androidhotfixcrashinformationupload

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import app.test.androidhotfixcrashinformationupload.crashLog.ExceptionCrashHandler

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //获取到崩溃日志
        val crashFile = ExceptionCrashHandler.instance.crashFile
    }

    fun onClick(view: View) {
        val findViewById = findViewById<TextView>(null!!)
    }


}
