package futurelogistics;

public class TimberTransport extends GoodsTransport{

    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;

    public TimberTransport(String transportId, String transportDate, int transportRating, float timberLength, float timberRadius, String timberType, float timberPrice){
        super(transportId, transportDate, transportRating);
        this.timberLength = timberLength;
        this.timberRadius = timberRadius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;
    }

    public String getTimberType(){
        return this.timberType;
    }

    
    public float getTimberPrice(){
        return this.timberPrice;
    }

    @Override 

    public String vehicleSelection(){
        double area = 2*3.147f*timberRadius*timberLength;

        if(area<250){
            return "Truck";
        }

        else if(area <= 500){
            return "Lorry";

        }
        else return "MonsterLorry";


        
    }

    @Override

    public float calculateTotalCharge(){
       double volume = 3.147f*timberRadius*timberRadius*timberLength;
       float rate = timberType.equalsIgnoreCase("Premium")?0.25f:0.15f;
       float price = (float)(volume*timberPrice*rate);

       float tax = price*0.3f;
       float discount = 0;
       if(transportRating == 5) discount=price*0.20f;
       else if (transportRating == 3 || transportRating == 4) discount =price*0.10f;

       float vehiclePrice = 0;
       String vehicle = vehicleSelection();
       if(vehicle.equalsIgnoreCase("Truck")) vehiclePrice = 1000;
       else if(vehicle.equalsIgnoreCase("Lorry")) vehiclePrice = 2000;
       else vehiclePrice = 3000;

       return (float)(price+tax+vehiclePrice)-discount;
    }
}










    