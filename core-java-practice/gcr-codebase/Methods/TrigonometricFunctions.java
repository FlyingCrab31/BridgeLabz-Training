import java.util.Scanner;
public class TrigonometricFunctions{
// Method to calculate sine, cosine and tangent of an angle in degrees

public double[] calculateTrigonometricFunctions(double angle){
    double radians = Math.toRadians(angle);
    double sine = Math.sin(radians);
    double cosine = Math.cos(radians);
    double tangent = Math.tan(radians);
    return new double[]{sine, cosine, tangent};
}
// Main method
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double angle = sc.nextDouble();
    TrigonometricFunctions tf = new TrigonometricFunctions();
    double[] results = tf.calculateTrigonometricFunctions(angle);
    System.out.printf("Sine: %.4f\n", results[0]);
    System.out.printf("Cosine: %.4f\n", results[1]);
    System.out.printf("Tangent: %.4f\n", results[2]);

}