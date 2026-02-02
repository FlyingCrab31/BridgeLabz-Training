package futurelogistics;

public class BrickTransport extends GoodsTransport{

    private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    public BrickTransport(String transportId, String transportDate, int transportRating, float brickSize, int brickQuantity, float brickPrice){
        super(transportId, transportDate, transportRating);

        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;
    

    }

    public float getBrickSize(){
        return brickSize;
    }

    public int getBrickQuantity(){
        return brickQuantity;
    }

    public float getBrickPrice(){
        return brickPrice;
    }


    @Override

    public String vehicleSelection(){
        if(brickQuantity<300){
            return "Truck";
        }

        else if(brickQuantity<=500){
            return "Lorry";
        }
        else return "MonsterLorry";
    }


    @Override 

    public float calculateTotalCharge(){
        float price = brickPrice*brickQuantity;
        float tax = price*0.3f;

        float discount = 0;
        if(transportRating == 5) discount = price*0.20f;
        else if (transportRating == 3 || transportRating == 4) discount = price*0.10f;

        float vehiclePrice = 0;
        String vehicle = vehicleSelection();
        if(vehicle.equalsIgnoreCase("Truck")) vehiclePrice=1000;
        else if(vehicle.equalsIgnoreCase("Lorry")) vehiclePrice=2000;
        else vehiclePrice = 3000;

        return (price+tax+vehiclePrice)-discount;
    }


}
