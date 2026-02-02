package futurelogistics;

public class Utility{

    public boolean validateTransportId(String transportId){
        if(!transportId.matches("RTS\\d{3}[A-Z]")){
            System.out.println("Transport id: "+transportId+" is invalid");
            return false;
        
        }
        return true;
    
    }

    public GoodsTransport parseDetails(String input){
        String[] details = input.split(":");

        String transportId = details[0];
        String transportDate = details[1];
        int transportRating = Integer.parseInt(details[2]);
        String type = details[3];


         




      


        if(type.equalsIgnoreCase("BrickTransport")){
            return new BrickTransport(
                transportId,
                 transportDate,
                  transportRating,
                 Float.parseFloat(details[4]), 
                 Integer.parseInt(details[5]), 
                 Float.parseFloat(details[6]));

        }

        else{
            return new TimberTransport(
                transportId,
                 transportDate,
                  transportRating,
                 Float.parseFloat(details[4]), 
                 Float.parseFloat(details[5]),
                 details[6], 
                 Float.parseFloat(details[7]));
        }
        

    }


    public String findObjectType(GoodsTransport goodsTransport){
        if(goodsTransport instanceof BrickTransport){
            return "BrickTransport";
        }
        else{
            return "TimberTransport";
        }
    }
}