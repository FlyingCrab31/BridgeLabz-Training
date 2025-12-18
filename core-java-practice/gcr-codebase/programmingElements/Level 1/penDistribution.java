public class PenDistribution{
    public static void main(String[] args) {
        int noOfPEns = 14;
        int students = 3;
        int equallyDistributed = noOfPEns / students;
        int leftPens = noOfPEns % students;

        System.out.println("equallyDistributed" + equallyDistributed);
        System.out.println("leftOver" + leftPens);
    }

}