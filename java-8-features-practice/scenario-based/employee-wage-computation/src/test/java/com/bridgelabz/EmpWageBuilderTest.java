package com.bridgelabz;

import static org.junit.Assert.*;
import org.junit.Test;

public class EmpWageBuilderTest {

    @Test

    public void testTotalWageForFullTime(){
        EmpWageBuilder builder=new EmpWageBuilder();
        builder.addCompany("TCS",20,20,100);
        builder.computeEmpWage("TCS",1);
        assertTrue(builder.getTotalWage("TCS")>0);


    }

    @Test

    public void testCompanyNotFound(){
        EmpWageBuilder builder=new EmpWageBuilder();

        assertEquals(0,builder.getTotalWage("TCS"));
    }

    @Test
    public void testDailyWageStored(){
        EmpWageBuilder builder=new EmpWageBuilder();
        builder.addCompany("Infosys",20,20,100);
        builder.computeEmpWage("Infosys",2);
        assertFalse(builder.getTotalWage("Infosys")==0);
    }

}
