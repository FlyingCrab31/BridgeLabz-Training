import java.util.*;

public class SmartDeviceControlInterface{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        SmartDevice smartDevice;

        System.out.print("Select device (ligt/ac/tv): ");
        String device = sc.nextLine().toLowerCase();

        switch(device) {
            case "light":
                smartDevice=new Light();
                 break;
                 case "ac":
                smartDevice=new AC();
                 break;
            case "tv":
                smartDevice=new TV();
                 break;
        
            default:
                System.out.println("Invalid device");
                return;
                
        }
        System.out.print("Enter action (on/off): ");
        String action = sc.nextLine().toLowerCase();


        if(action.toLowerCase().equals("on")){
            smartDevice.turnOn();
        }
        else if(action.toLowerCase().equals("off")){
            smartDevice.turnOff();
        }
        else{
            System.out.println("Invalid action");
        }




    }
}