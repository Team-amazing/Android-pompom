package com.example.outopompomme;

import javax.xml.transform.sax.SAXResult;

public class RecyclerViewWeatherItem {
    private String mImgName;
    private static String mTempText;
    private static String mLocationText;
    private static String mWeekText;
    private static String mTimeText;

    public String getmImgName(){
        return mImgName;
    }

    public void setmImgName(String imgName){
        this.mImgName = imgName;
    }

    public static String getmTempText(){
        return mTempText;
    }

    public void setmTempText(String tempText){
        this.mTempText = tempText;
    }

    public static String getmLocationText(){
        return mLocationText;
    }

    public void setmLocationText(String locationText){
        this.mLocationText = locationText;
    }

    public static String getmWeekText(){
        return mWeekText;
    }

    public void setmWeekText(String weekText){
        this.mWeekText = weekText;
    }

    public static String getmTimeText(){
        return  mTimeText;
    }

    public void setmTimeText(String timeText){
        this.mTimeText = timeText;
    }
}
