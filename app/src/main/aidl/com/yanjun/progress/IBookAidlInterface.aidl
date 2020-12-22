// IBookAidlInterface.aidl
package com.yanjun.progress;
import com.yanjun.progress.Book;
// Declare any non-default types here with import statements

interface IBookAidlInterface {
     String getTitle();
     void setTitle(String title);
     Book getBook();
}