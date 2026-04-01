import java.util.*;

public class ProgramMain{

    public void registerCreator(CreatorStatistics record){
        CreatorStatistics.engagementBoard.add(record);
        System.out.println("Creator registered successfully");
    
    }

    public Map<String, Integer> getTopPosts(List<CreatorStatistics> records, double likeThreshold){
        Map<String, Integer> topPosts = new HashMap<>();

        for(CreatorStatistics record : records){
            int count=0;

            for(double likes:record.weeklyLikes){
                if(likes>=likeThreshold){
                    count++;
                }
            }
            
            if(count>0){
                topPosts.put(record.creatorName, count);
            
            }

    }

    return topPosts;
}


public double calculatingAverageLikes(){
    double sum=0;
    int total=0;

    for(CreatorStatistics record : CreatorStatistics.engagementBoard){
        for(double likes:record.weeklyLikes){
            sum+=likes;
            total++;
        }
    }

    if(total==0) return 0;

    return sum/total;

}


public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    ProgramMain program=new ProgramMain();

    int choice;

    do{

        System.out.println("1. Register Creator");
        System.out.println("2. Get Top Posts");
        System.out.println("3. Calculate Average Likes");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        choice=sc.nextInt();

        sc.nextLine();

        switch(choice){
            case 1:
                System.out.print("Enter creator name: ");
                String creatorName=sc.nextLine();
                double[] weeklyLikes=new double[7];

                System.out.println("Enter weekly likes for the creator: ");
                for(int i=0;i<7;i++){
                    System.out.print("Week Day "+(i+1)+": ");
                    weeklyLikes[i]=sc.nextDouble();
                    sc.nextLine();
                }

                CreatorStatistics record=new CreatorStatistics(creatorName, weeklyLikes);
                program.registerCreator(record);
                break;

                case 2:

                if(CreatorStatistics.engagementBoard.isEmpty()){
                    System.out.println("No creators registered yet");
                    break;
                }
                else{
                    System.out.print("Enter like threshold: ");
                    double likeThreshold=sc.nextDouble();
                    sc.nextLine();

                    Map<String, Integer> topPosts=program.getTopPosts(CreatorStatistics.engagementBoard, likeThreshold);

                    if(topPosts.isEmpty()){
                        System.out.println("No creators met the like threshold");}
                        else{
                            System.out.println("Top Posts:");
                            for(Map.Entry<String, Integer> entry:topPosts.entrySet()){
                                System.out.println(entry.getKey()+": "+entry.getValue()+" posts");
                            }
                        }
                    }
                    break;
                    case 3:
                    double averageLikes=program.calculatingAverageLikes();
                    System.out.println("Average Likes: "+averageLikes);
                    break;
                    case 4:
                    System.out.println("Exiting the program");
                    break;
                    default:
                    System.out.println("Invalid choice");
                    break;




        }
    }
    while(choice!=4);


}
}