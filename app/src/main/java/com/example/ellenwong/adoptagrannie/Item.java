package com.example.ellenwong.adoptagrannie;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by ellenwong on 2/7/15.
 */

@ParseClassName("Request")
public class Item extends ParseObject{
    private String img_url = "";
    private String requestName = "Walk";
    private String grannieName = "grannie 1";
    private String time = "4:00 pm";
    private String distance = "0.3 mil";
    private String status = "active";
    private String message = "Hi, I need help";

    private static final String GRANNIE_NAME = "grannieName";
    private static final String IMG = "img";
    private static final String MESSAGE = "message";
    private static final String REQUEST_NAME = "requestName";
    private static final String START_TIME = "startTime";
    public static final String STATUS = "status";
    private static final String SUBJECT = "subject";
    private static final String DISTANCE = "distance";
    public static final String STATUS_ACTIVE = "Active";
    public static final String STATUS_ACCEPTED = "Accepted";


    public Item(){

    }

    public Item(String img, String rName, String gName, String t, String d , String s){
        this.img_url = img;
        this.requestName = rName;
        this.grannieName = gName;
        this.time = t;
        this.distance = d;
        this.status = s;
    }

    public String getRequestName() {
        return getString(REQUEST_NAME);
        //return this.requestName;
    }

    public void setRequestName(String value) {
        put(REQUEST_NAME, value);
    }

    public String getSubject() {
        return getString(SUBJECT);
        //return this.requestName;
    }

    public void setSubject(String value) {
        put(SUBJECT, value);
    }


    public String getGrannieName() {
        return getString(GRANNIE_NAME);
        //return this.grannieName;
    }

    public void setGrannieName(String value) {
        //this.grannieName = value;
        put(GRANNIE_NAME, value);
    }

    public String getTime() {
        return getString(START_TIME);
        //return this.time;
    }

//    public String getImg_url() {
//        return getString(IMG);
//        //return this.img_url;
//    }

    public String getMessage() {
        return getString(MESSAGE);
        //return this.message;
    }

    public String getDistance() {
        return getString(DISTANCE);
        //return this.distance;
    }

    public String getStatus() {
        return getString(STATUS);
        //return this.status;
    }


    public void setImg_url(String value){
        put(IMG, value);
    }

    public void setTime(String value) {
        put(START_TIME, value);
    }

    public void setDistance(String value) {
        put(DISTANCE, value);
    }

    public void setStatus(String value) {
        put(STATUS, value);
    }

    public static ParseQuery<Item> getQuery() {
        return ParseQuery.getQuery(Item.class);
    }

    @Override
    public String toString() {
        //return super.toString();
        String objectStr = " message = " + getMessage() + " RequestName = " + getRequestName() + " elderly name = " + getGrannieName();
        return objectStr;
    }
}
