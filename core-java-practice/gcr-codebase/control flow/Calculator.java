import java.util.Scanner;

class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double first = sc.nextDouble();
        double second = sc.nextDouble();
        String op = sc.next();

        double result = 0;
        boolean validOp = true;

        switch (op) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                if (second != 0) {
                    result = first / second;
                } else {
                    System.out.println("Error: Division by zero");
                    validOp = false;
                }
                break;
            default:
                System.out.println("Invalid Operator");
                validOp = false;
        }

        if (validOp && !op.equals("/") || (op.equals("/") && second != 0)) {
            System.out.println("Result: " + result);
        }

        sc.close();
    }
}
