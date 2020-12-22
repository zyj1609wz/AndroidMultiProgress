package com.yanjun.progress

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    private var binder: Binder = object : IBookAidlInterface.Stub() {

        override fun getTitle(): String {
            return "aidl->title"
        }

        override fun setTitle(title: String?) {
            Log.d("aidl", "service-setTitle:$title")
        }

        override fun getBook(): Book {
            var book = Book()
            book.title = "书的名字"
            return book
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onCreate() {
        super.onCreate()
    }
}