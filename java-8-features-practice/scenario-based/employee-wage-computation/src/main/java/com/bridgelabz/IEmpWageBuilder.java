package com.bridgelabz;

public interface IEmpWageBuilder {
    void addCompany(String company, int ratePerHour, int maxDays,int maxHours);
    void computeEmpWage(String company,int workType);
    int getTotalWage(String company);

}
