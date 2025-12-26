public class EuclideanDistance {
    
    // Method to find Euclidean distance between two points
    public static double findDistance(int x1, int y1, int x2, int y2) {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance;
    }
    
    // Method to find equation of line (y = mx + b)
    public static double[] findLineEquation(int x1, int y1, int x2, int y2) {
        // Calculate slope (m) = (y2 - y1) / (x2 - x1)
        double m = (double) (y2 - y1) / (x2 - x1);
        
        // Calculate y-intercept (b) = y1 - m * x1
        double b = y1 - m * x1;
        
        // Return array with slope and y-intercept
        double[] equation = {m, b};
        return equation;
    }
    
    public static void main(String[] args) {
        // Take inputs for 2 points
        int x1 = 2, y1 = 3;
        int x2 = 5, y2 = 7;
        
        System.out.println("Point 1: (" + x1 + ", " + y1 + ")");
        System.out.println("Point 2: (" + x2 + ", " + y2 + ")");
        
        // Calculate Euclidean distance
        double distance = findDistance(x1, y1, x2, y2);
        System.out.printf("\nEuclidean Distance: %.2f\n", distance);
        
        // Calculate line equation
        double[] equation = findLineEquation(x1, y1, x2, y2);
        double m = equation[0];
        double b = equation[1];
        
        System.out.println("\nEquation of the line:");
        System.out.printf("y = %.2fx + %.2f\n", m, b);
        System.out.printf("Slope (m): %.2f\n", m);
        System.out.printf("Y-intercept (b): %.2f\n", b);
    }
}
