public class CollinearPoints {
    
    // Method to check collinearity using slope formula
    public static boolean areCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        // Calculate slopes: slope AB and slope BC
        // To avoid division, we use cross multiplication

        
        int slopeAB_num = y2 - y1;
        int slopeAB_den = x2 - x1;
        
        int slopeBC_num = y3 - y2;
        int slopeBC_den = x3 - x2;
        
        // Cross multiply to avoid division
        return (slopeAB_num * slopeBC_den) == (slopeBC_num * slopeAB_den);
    }
    
    // Method to check collinearity using area of triangle
    public static boolean areCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        // Area of triangle
        // For collinearity, area should be 0
        
        int area = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        return area == 0;
    }
    
    public static void main(String[] args) {
        // Test with points A(2,4), B(4,6), C(6,8)
        int x1 = 2, y1 = 4;
        int x2 = 4, y2 = 6;
        int x3 = 6, y3 = 8;
        
        System.out.println("Points: A(" + x1 + "," + y1 + "), B(" + x2 + "," + y2 + "), C(" + x3 + "," + y3 + ")");
        
        boolean collinearBySlope = areCollinearBySlope(x1, y1, x2, y2, x3, y3);
        System.out.println("Collinear by Slope method: " + collinearBySlope);
        
        boolean collinearByArea = areCollinearByArea(x1, y1, x2, y2, x3, y3);
        System.out.println("Collinear by Area method: " + collinearByArea);
        
        // Test with non-collinear points
        System.out.println("\nTest with non-collinear points:");
        x1 = 1; y1 = 1;
        x2 = 2; y2 = 3;
        x3 = 4; y3 = 5;
        
        System.out.println("Points: A(" + x1 + "," + y1 + "), B(" + x2 + "," + y2 + "), C(" + x3 + "," + y3 + ")");
        System.out.println("Collinear by Slope method: " + areCollinearBySlope(x1, y1, x2, y2, x3, y3));
        System.out.println("Collinear by Area method: " + areCollinearByArea(x1, y1, x2, y2, x3, y3));
    }
}
