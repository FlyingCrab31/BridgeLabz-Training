interface Vehicle{

    void displaySpeed(int speed);

    default void displayBatteryPercentage(){
        System.out.println("Battery information not available..");
    }


}