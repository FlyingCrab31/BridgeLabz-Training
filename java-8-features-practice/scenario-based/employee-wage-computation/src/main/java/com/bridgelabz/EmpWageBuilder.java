package com.bridgelabz;

import java.util.*;

public class EmpWageBuilder implements IEmpWageBuilder {

    public static final int FULL_TIME=1;
    public static final int PART_TIME=2;

    private ArrayList<CompanyEmpWage> companies=new ArrayList<>();

    //uc 8
    @Override
    public void addCompany(String company,int ratePerHour,int maxDays,int maxHours){
        companies.add(new CompanyEmpWage(company,ratePerHour,maxDays,maxHours));
    }

    //uc 7, uc 6, uc5, uc 4, uc3
    @Override
    public void computeEmpWage(String companyName,int workType){

        CompanyEmpWage company=getCompany(companyName);
        if(company==null) return;

        int totalHours=0;
        int totalDays=0;


        company.dailyWages.clear();
        company.totalWage=0;

        while(totalDays<company.maxDays && totalHours<company.maxHours){
            int hoursWorked=0;
            switch(workType){
                case FULL_TIME: hoursWorked=8; break;
                case PART_TIME: hoursWorked=4; break;
                default: hoursWorked=0;
            }

            if(totalHours+hoursWorked>company.maxHours) {
                hoursWorked = company.maxHours - totalHours;
            }

            int dailyWage=hoursWorked*company.ratePerHour;

            company.dailyWages.add(dailyWage);
            company.totalWage+=dailyWage;

            totalHours+=hoursWorked;
            totalDays++;
        }
    }

    //uc13

    @Override
    public int getTotalWage(String companyName) {
        CompanyEmpWage company = getCompany(companyName);
        return (company == null) ? 0 : company.totalWage;
    }

    private CompanyEmpWage getCompany(String companyName) {
        for (CompanyEmpWage c : companies) {
            if (c.company.equals(companyName)) {
                return c;
            }
        }
        return null;
    }



}
