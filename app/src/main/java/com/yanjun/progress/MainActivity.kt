package com.yanjun.progress

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log

class MainActivity : AppCompatActivity() {

    private var iBookAidlInterface: IBookAidlInterface? = null

    private var serviceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {

        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            iBookAidlInterface = IBookAidlInterface.Stub.asInterface(service)
            var name = iBookAidlInterface?.title
            Log.d("aidl", "getTitle: $name")
            iBookAidlInterface?.title = "我是一个title"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindService()
    }

    /**
     * 绑定服务
     */
    private fun bindService() {
        var intent = Intent(this, MyService::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(serviceConnection)
    }
}