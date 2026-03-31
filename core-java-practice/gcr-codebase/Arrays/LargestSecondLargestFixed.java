class LargestSecondLargestFixed {
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.print("Enter number: ");
        int num = in.nextInt();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        int temp = Math.abs(num);
        while (temp != 0 && index < maxDigit) {
            digits[index++] = temp % 10;
            temp /= 10;
        }

        int largest = 0, secondLargest = 0;
        for (int i = 0; i < index; i++) {
            int d = digits[i];
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }

        System.out.println("Largest: " + largest);
        System.out.println("Second largest: " + secondLargest);
        in.close();
    }
}
