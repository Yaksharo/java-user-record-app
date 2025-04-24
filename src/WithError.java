public class WithError {
    public static void main(String[] args) {
        // First try-catch: division by zero
        try {
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        }

        // Second try-catch: accessing invalid array index
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]); // invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index is out of bounds.");
        }
    }
}
