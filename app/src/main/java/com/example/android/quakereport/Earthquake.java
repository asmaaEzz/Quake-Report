package com.example.android.quakereport;

/**
 * Created by El.Doc on 01/03/2017.
 */

public class Earthquake {
   private double mag;
    private String place;
    private long date;
    private String url;
    public Earthquake(double mag , String place , long date , String url){
        this.mag=mag;
        this.place=place;
        this.date=date;
        this.url=url;
    }

    public void setMag(double mag) {
        this.mag = mag;
    }

    public double getMag() {
        return mag;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getDate() {
        return date;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
