package com.yanjun.progress;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author yanjun.zhao
 * @time 2020/12/22 9:10 PM
 * @desc
 */
public class Book implements Parcelable {

    public String title;

    Book() {

    }

    protected Book(Parcel in) {
        title = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
