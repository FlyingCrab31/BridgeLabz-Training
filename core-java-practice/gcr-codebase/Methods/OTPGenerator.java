public class OTPGenerator {
    
    // Method to generate a 6-digit OTP
    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000; // Range: 100000 to 999999
    }
    
    // Method to check if all OTPs are unique
    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false; // Found duplicate
                }
            }
        }
        return true; // All unique
    }
    
    public static void main(String[] args) {
        int[] otps = new int[10];
        
        // Generate 10 OTPs
        System.out.println("Generating 10 OTP numbers:");
        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otps[i]);
        }
        
        // Validate uniqueness
        boolean isUnique = areOTPsUnique(otps);
        System.out.println("\nAre all OTPs unique? " + isUnique);
        
        if (!isUnique) {
            System.out.println("Warning: Duplicate OTPs found!");
        }
    }
}
