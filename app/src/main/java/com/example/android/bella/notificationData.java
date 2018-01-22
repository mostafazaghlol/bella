package com.example.android.bella;

/**
 * Created by mostafa on 1/22/18.
 */

public class notificationData {
    private String mMessage, mTime;
    private int mId;

    public notificationData(String Message, String Time, int id) {
        this.mMessage = Message;
        this.mTime = Time;
        this.mId = id;
    }

    public int getmId() {
        return mId;
    }

    public String getmMessage() {
        return mMessage;
    }

    public String getmTime() {
        return mTime;
    }

}
