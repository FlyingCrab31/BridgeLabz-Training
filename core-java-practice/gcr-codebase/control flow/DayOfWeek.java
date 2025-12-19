class DayOfWeek {
    public static void main(String[] args) {
        // Parse command-line arguments
        int m = Integer.parseInt(args[0]);  // month
        int d = Integer.parseInt(args[1]);  // day
        int y = Integer.parseInt(args[2]);  // year

// we can also use the Scanner class to read input from the user. but here we are using command-line arguments.
// because if run the code in the terminal we can provide the input as command-line arguments.

        // Step 1: Calculate y0
        int y0 = y - (14 - m) / 12;
        
        // Step 2: Calculate x
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        
        // Step 3: Calculate m0
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        
        // Step 4: Calculate d0 (day of week)
        int d0 = (d + x + 31 * m0 / 12) % 7;
        
        // Print result
        System.out.println(d0);
    }
}
