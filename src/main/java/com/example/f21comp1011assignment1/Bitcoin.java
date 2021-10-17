package com.example.f21comp1011assignment1;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class Bitcoin {
    //declare instance variables
    private int id; //primary key
    private Date dateBTC;
    private double openPrice;
    private double highPrice;
    private double lowPrice;
    private double closePrice;
    private double adjClosePrice;
    private double volume;
    //The table view has Year and Month column
    private int year;
    private int month;


    //Declare a constructor
    public Bitcoin(double openPrice, double highPrice, double lowPrice, double closePrice, double adjClosePrice, double volume) {
        setOpenPrice(openPrice);
        setHighPrice(highPrice);
        setLowPrice(lowPrice);
        setClosePrice(closePrice);
        setAdjClosePrice(adjClosePrice);
        setVolume(volume);
        id = 0;
        year = 0;
        month = 0;
    }

    //Constructor overloading
    public Bitcoin(Date dateBTC, double openPrice, double highPrice, double lowPrice, double closePrice, double adjClosePrice, double volume) {
        this(openPrice, highPrice, lowPrice, closePrice, adjClosePrice, volume);
        setDateBTC(dateBTC);
        id = 0;
        year = 0;
        month = 0;
    }

    //Setters and Getters
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 2014){
            this.year = year;
        }
        else {
            throw new IllegalArgumentException("The year should >= 2014");
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (1 <= month && month <= 12){
            this.month = month;
        }
        else {
            throw new IllegalArgumentException("The month must between 1 and 12");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0){
            this.id = id;
        }
        else{
            throw new IllegalArgumentException("Id must be greater than 0");
        }
    }

    public Date getDateBTC() {
        return dateBTC;
    }

    public void setDateBTC(Date dateBTC) {
        if (dateBTC != null){
            this.dateBTC = dateBTC;
        }
        else{
            throw new IllegalArgumentException("The date can't be empty");
        }
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        if (openPrice >= 0){
            this.openPrice = openPrice;
        }
        else {
            throw new IllegalArgumentException("openPrice must be greater than or equal to 0");
        }
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        if (highPrice >= 0){
            this.highPrice = highPrice;
        }
        else {
            throw new IllegalArgumentException("highPrice must be greater than or equal to 0");
        }
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        if (lowPrice >= 0){
            this.lowPrice = lowPrice;
        }
        else {
            throw new IllegalArgumentException("lowPrice must be greater than or equal to 0");
        }

    }

    public double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(double closePrice) {
        if (closePrice >= 0){
            this.closePrice = closePrice;
        }
        else {
            throw new IllegalArgumentException("closePrice must be greater than or equal to 0");
        }
    }

    public double getAdjClosePrice() {
        return adjClosePrice;
    }

    public void setAdjClosePrice(double adjClosePrice) {
        if (adjClosePrice >= 0){
            this.adjClosePrice = adjClosePrice;
        }
        else {
            throw new IllegalArgumentException("adjClosePrice must be greater than or equal to 0");
        }
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        if (volume >= 0){
            this.volume = volume;
        }
        else {
            throw new IllegalArgumentException("volume must be greater than or equal to 0");
        }
    }


}

