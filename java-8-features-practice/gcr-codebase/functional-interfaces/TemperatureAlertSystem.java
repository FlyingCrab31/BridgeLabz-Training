import java.util.*;

import java.util.function.Predicate;

public class TemperatureAlertSystem{
public static void main(String args[]){
    Scanner sc=new Scanner(System.in);

    System.out.print("Enter the temperature: ");
    double currentTemp=sc.nextDouble();

    System.out.print("Enter the threshold temperature: ");
    double thresholdTemp=sc.nextDouble();

    Predicate<Double> isAboveThreshold=temp->temp>thresholdTemp;

    if(isAboveThreshold.test(currentTemp)){
        System.out.println("Temperature is above threshold");
    }else{
        System.out.println("Temperature is below threshold");
    
    }
}
}