package com.bridgelabz;


import java.util.*;
import java.util.regex.*;


public class EmployeeWageMain {

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation");

        Scanner sc=new Scanner(System.in);
        EmpWageBuilder builder = new EmpWageBuilder();

        System.out.print("Enter number of companies: ");
        int companyCount = sc.nextInt();
        sc.nextLine();


        for(int i = 1; i <= companyCount; i++) {

            System.out.println("\nEnter details for Company " + i);



            System.out.print("Enter company name: ");
            String company = sc.nextLine();

            //regex
            if (!Pattern.matches("[A-Za-z]{2,}", company)) {
                System.out.println("Invalid company name");
                return;
            }

            System.out.print("Is Employee Present? (1=Yes, 0=No): ");
            int isPresent = sc.nextInt();
            sc.nextLine();

            if (isPresent == 0) {
                System.out.println("Employee is not present");
                sc.nextLine();
                continue;
            }

            System.out.print("Enter work type(1=Full time, 2=Part time): ");
            int workType = sc.nextInt();
            sc.nextLine();

            System.out.print("Wage Per Hour: ");
            int rate = sc.nextInt();
            sc.nextLine();

            System.out.print("Max Working Days(Per Month): ");
            int maxDays = sc.nextInt();
            sc.nextLine();

            System.out.print("Max Working Hours: ");
            int maxHours = sc.nextInt();
            sc.nextLine();

            maxHours=maxHours*30;
            builder.addCompany(company, rate, maxDays, maxHours);//uc 8

            builder.computeEmpWage(company,workType);
        }
        //uc2+uc3
        //EmpWageBuilder builder=new EmpWageBuilder();


        System.out.print("\nEnter company name to get total wage: ");
        String searchCompany = sc.nextLine();

        System.out.println("Total Wage = " +
                builder.getTotalWage(searchCompany));

        System.out.println("\nThank You");


    }
}

