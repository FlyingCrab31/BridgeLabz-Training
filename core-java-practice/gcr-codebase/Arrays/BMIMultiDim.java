import java.util.Scanner;

class BMIMultiDim {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Take input for number of persons
        System.out.print("Enter number of persons: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.err.println("Invalid number of persons.");
            input.close();
            return;
        }

        // 2. Create multi-dimensional array and status array
        double[][] personData = new double[number][3]; // 0: weight, 1: height, 2: BMI
        String[] weightStatus = new String[number];

        // 3. Take input for weight and height with validation
        for (int i = 0; i < number; i++) {
            double weight;
            double height;

            // weight
            while (true) {
                System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
                weight = input.nextDouble();
                if (weight > 0) break;
                System.err.println("Invalid weight. Please enter a positive value.");
            }

            // height
            while (true) {
                System.out.print("Enter height (meters) of person " + (i + 1) + ": ");
                height = input.nextDouble();
                if (height > 0) break;
                System.err.println("Invalid height. Please enter a positive value.");
            }

            personData[i][0] = weight;
            personData[i][1] = height;
        }

        // 4. Calculate BMI and weight status
        for (int i = 0; i < number; i++) {
            double weight = personData[i][0];
            double height = personData[i][1];

            double bmi = weight / (height * height);
            personData[i][2] = bmi;

            String status;
            if (bmi < 18.5) {
                status = "Underweight";
            } else if (bmi < 25) {
                status = "Normal";
            } else if (bmi < 30) {
                status = "Overweight";
            } else {
                status = "Obese";
            }

            weightStatus[i] = status;
        }

        // 5. Display height, weight, BMI and status of each person
        System.out.println("\nPerson\tWeight(kg)\tHeight(m)\tBMI\t\tStatus");
        for (int i = 0; i < number; i++) {
            System.out.printf(
                "%d\t%.2f\t\t%.2f\t\t%.2f\t%s%n",
                (i + 1),
                personData[i][0],
                personData[i][1],
                personData[i][2],
                weightStatus[i]
            );
        }

        input.close();
    }
}
