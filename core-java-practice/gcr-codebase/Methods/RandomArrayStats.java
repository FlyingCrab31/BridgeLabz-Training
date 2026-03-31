public class RandomArrayStats {

    // generate array of 4-digit random numbers
    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            // 1000 to 9999
            numbers[i] = (int) (Math.random() * 9000) + 1000;
        }
        return numbers;
    }

    // returns [average, min, max]
    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0];
        int max = numbers[0];
        int sum = 0;

        for (int value : numbers) {
            sum += value;
            min = Math.min(min, value);
            max = Math.max(max, value);
        }

        double average = (double) sum / numbers.length;
        return new double[]{average, min, max};
    }

    public static void main(String[] args) {
        int[] numbers = generate4DigitRandomArray(5);

        System.out.println("Random 4-digit numbers:");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();

        double[] stats = findAverageMinMax(numbers);
        System.out.println("Average = " + stats[0]);
        System.out.println("Min     = " + stats[1]);
        System.out.println("Max     = " + stats[2]);
    }
}
