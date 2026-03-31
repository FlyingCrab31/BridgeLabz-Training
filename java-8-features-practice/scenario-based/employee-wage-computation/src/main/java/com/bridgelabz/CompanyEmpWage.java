package com.bridgelabz;

import java.util.*;


public class CompanyEmpWage {

    public String company;
    public int ratePerHour;
    public int maxDays;
    public int maxHours;
    public int totalWage;

    //uc-12

    public ArrayList<Integer> dailyWages=new ArrayList<>();

    public CompanyEmpWage(String company,int ratePerHour,int maxDays,int maxHours){
        this.company=company;
        this.ratePerHour=ratePerHour;
        this.maxDays=maxDays;
        this.maxHours=maxHours;
    }

}
