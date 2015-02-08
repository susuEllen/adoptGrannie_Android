package com.example.ellenwong.adoptagrannie;

/**
 * Created by ellenwong on 2/7/15.
 */

//TODO: turn this into a parse Object class
public class Item {
    private String img_url = "";
    private String requestName = "Walk";
    private String grannieName = "grannie1";
    private String time = "4:00 pm";
    private String distance = "0.3 mil";
    private String status = "active";

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
        //return getString("name");
        return this.requestName;
    }

    public void setRequestName(String value) {
        //put("name", value);
    }

    public String getGrannieName() {
        return this.grannieName;
    }

    public void setGrannieName(String value) {
        //this.grannieName = value;
        //put("grannieName", value);
    }

    public String getTime() {
        //return getString("name");
        return this.time;
    }

    public String getImg_url() {
        //return getString("name");
        return this.img_url;
    }

    public String getDistance() {
        //return getString("name");
        return this.distance;
    }

    public String getStatus() {
        //return getString("name");
        return this.status;
    }


    public void setImg_url(){
        //put("name", value);
    }

    public void setTime() {
        //put("name", value);
    }

    public void setDistance() {
        //put("name", value);
    }

    public void setStatus() {
        //put("name", value);
    }

//    public String getDetails() {
//        return details;
//    }
//
//    public void setDetails(String details) {
//        this.details = details;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }

}
