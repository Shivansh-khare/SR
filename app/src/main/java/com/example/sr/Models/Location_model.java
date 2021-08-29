package com.example.sr.Models;

public class Location_model {
    double lang,longi;

    Location_model(){}

    public Location_model(double lang, double latti) {
        this.longi = lang;
        this.lang = latti;
    }

    public double getLang() {
        return lang;
    }

    public void setLang(double lang) {
        this.lang = lang;
    }

    public double getLatti() {
        return longi;
    }

    public void setLatti(double latti) {
        this.longi = latti;
    }
}
