package com.example.ipl;

public class IPLApplication {
    public static void main(String[] args) throws Exception {
        IplJsonProcessor.processJson();
        IplCsvProcessor.processCsv();
        System.out.println("IPL JSON & CSV Censored Successfully");
    }
}
