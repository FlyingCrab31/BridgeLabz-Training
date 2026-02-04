import java.util.*;

public class ExportingDataMain{

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.println("Choose format(1. CSV/ 2. PDF): ");
        int choice=sc.nextInt();

        Exporter exporter;

        switch(choice){
            case 1:
                exporter=new CSVExporter();
                break;
            case 2:
                exporter=new PDFExporter();
                break;
            default:
                System.out.println("Invalid choice");
                return;        
        }
        exporter.export();
        exporter.exportToJson();
        
    }
}