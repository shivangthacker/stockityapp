package com.currencyinformation.currencyinfo;

public class Model {

int currency_img,five,fifteen,hour,day;
String firstcurrency,secondcurrency,sma_5min,sma;
Boolean switch_sma;
    Boolean switch_ef;
    Boolean switch_cd;
    Boolean switch_five;
    Boolean switch_fifteen;
    Boolean switch_hour;

    public Model() {
        this.switch_sma = switch_sma;
        this.switch_ef = switch_ef;
        this.switch_cd = switch_cd;
        this.switch_five = switch_five;
        this.switch_fifteen = switch_fifteen;
        this.switch_hour = switch_hour;
        this.switch_day = switch_day;
    }

    public Boolean getSwitch_sma() {
        return switch_sma;
    }

    public void setSwitch_sma(Boolean switch_sma) {
        this.switch_sma = switch_sma;
    }

    public Boolean getSwitch_ef() {
        return switch_ef;
    }

    public void setSwitch_ef(Boolean switch_ef) {
        this.switch_ef = switch_ef;
    }

    public Boolean getSwitch_cd() {
        return switch_cd;
    }

    public void setSwitch_cd(Boolean switch_cd) {
        this.switch_cd = switch_cd;
    }

    public Boolean getSwitch_five() {
        return switch_five;
    }

    public void setSwitch_five(Boolean switch_five) {
        this.switch_five = switch_five;
    }

    public Boolean getSwitch_fifteen() {
        return switch_fifteen;
    }

    public void setSwitch_fifteen(Boolean switch_fifteen) {
        this.switch_fifteen = switch_fifteen;
    }

    public Boolean getSwitch_hour() {
        return switch_hour;
    }

    public void setSwitch_hour(Boolean switch_hour) {
        this.switch_hour = switch_hour;
    }

    public Boolean getSwitch_day() {
        return switch_day;
    }

    public void setSwitch_day(Boolean switch_day) {
        this.switch_day = switch_day;
    }

    Boolean switch_day;


    public Model(int currency_img, int five, int fifteen, int hour, int day, String firstcurrency, String secondcurrency) {
        this.currency_img = currency_img;
        this.five = five;
        this.fifteen = fifteen;
        this.hour = hour;
        this.day = day;
        this.firstcurrency = firstcurrency;
        this.secondcurrency = secondcurrency;
    }

    public String getFirstcurrency() {
        return firstcurrency;
    }

    public void setFirstcurrency(String firstcurrency) {
        this.firstcurrency = firstcurrency;
    }

    public String getSecondcurrency() {
        return secondcurrency;
    }

    public void setSecondcurrency(String secondcurrency) {
        this.secondcurrency = secondcurrency;
    }

    public int getCurrency_img() {
        return currency_img;
    }

    public void setCurrency_img(int currency_img) {
        this.currency_img = currency_img;
    }

    public int getFive() {
        return five;
    }

    public void setFive(int five) {
        this.five = five;
    }

    public int getFifteen() {
        return fifteen;
    }

    public void setFifteen(int fifteen) {
        this.fifteen = fifteen;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }




}
