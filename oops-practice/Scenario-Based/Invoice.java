class InvoiceUtils {

    // Parse the input into an array of "clean" task strings
    // e.g. ["Logo Design - 3000 INR", "Web Page - 4500 INR"]
    public static String[] parseInvoice(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new String[0];
        }
        // split by comma into tasks
        String[] parts = input.split(",");   // split by comma
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();      // remove spaces around each task
        }
        return parts;
    }

    // Extract total amount from tasks array
    // Each element looks like: "Logo Design - 3000 INR"
    public static int getTotalAmount(String[] tasks) {
        int total = 0;

        for (String task : tasks) {
            if (task == null || task.isEmpty()) continue;

            // Split by '-' to separate name and amount section
            String[] pieces = task.split("-");    // split by hyphen
            if (pieces.length < 2) {
                continue; // skip invalid format
            }

            String amountPart = pieces[1].trim(); // "3000 INR" or "4500 INR"

            // Keep only digits to get the numeric amount
            String digitsOnly = amountPart.replaceAll("\\D", ""); // remove non-digits

            if (!digitsOnly.isEmpty()) {
                int amount = Integer.parseInt(digitsOnly);
                total += amount;
            }
        }

        return total;
    }
    public class Main {
    public static void main(String[] args) {
        String input = "Logo Design - 3000 INR, Web Page - 4500 INR";

        String[] tasks = InvoiceUtils.parseInvoice(input);
        int total = InvoiceUtils.getTotalAmount(tasks);

        System.out.println("Tasks:");
        for (String t : tasks) {
            System.out.println(" - " + t);
        }
        System.out.println("Total invoice amount: " + total + " INR");
    }
}

}
