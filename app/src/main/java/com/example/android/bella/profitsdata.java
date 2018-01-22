package com.example.android.bella;

/**
 * Created by mostafa on 1/22/18.
 */

public class profitsdata {
    private String mPercentageOfAppOwner, mTotalProfit, mNumberOfTimes, mFacilityName;

    public profitsdata(String PercentageOfAppOwner, String TotalProfit, String NumberOfTimes, String FacilityName) {
        this.mPercentageOfAppOwner = PercentageOfAppOwner;
        this.mTotalProfit = TotalProfit;
        this.mNumberOfTimes = NumberOfTimes;
        this.mFacilityName = FacilityName;
    }

    public String getmFacilityName() {
        return mFacilityName;
    }

    public String getmNumberOfTimes() {
        return mNumberOfTimes;
    }

    public String getmPercentageOfAppOwner() {
        return mPercentageOfAppOwner;
    }

    public String getmTotalProfit() {
        return mTotalProfit;
    }
}
