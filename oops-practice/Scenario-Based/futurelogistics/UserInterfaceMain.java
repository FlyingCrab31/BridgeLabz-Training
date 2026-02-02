package futurelogistics;

import java.util.*;
public class UserInterfaceMain{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        Utility utility = new Utility();

        System.out.print("Enter the goods transport details: ");
        String input = sc.nextLine();

        String transportId = input.split(":")[0];

        if(!utility.validateTransportId(transportId)){
            System.err.println("Please provide a valid record");
            return;
        }

        GoodsTransport goodsTransport=utility.parseDetails(input);

        String objectType = utility.findObjectType(goodsTransport);

        System.out.println("Transporter id: "+goodsTransport.getTransportId());
        System.out.println("Transportation date: "+goodsTransport.getTransportDate());
        System.out.println("Transporter rating: "+goodsTransport.getTransportRating());

        if(goodsTransport instanceof BrickTransport){
            BrickTransport brickTransport=(BrickTransport)goodsTransport;

            System.out.println("Brick quantity: "+brickTransport.getBrickQuantity());
            System.out.println("Brick price: "+brickTransport.getBrickPrice());

        }
        else {
            TimberTransport timberTransport=(TimberTransport)goodsTransport;
           
            System.out.println("Timber type: "+timberTransport.getTimberType());
            System.out.println("Timber price: "+timberTransport.getTimberPrice());
        }

        System.out.println("Vehicle selected: "+goodsTransport.vehicleSelection());
        System.out.println("Total charge: "+goodsTransport.calculateTotalCharge());
        sc.close();
    
        



    }
}
