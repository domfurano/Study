package unsorted;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        if (fibonacci.fibonacciRecursive(0) != 0) throw new AssertionError();
        if (fibonacci.fibonacciRecursive(1) != 1) throw new AssertionError();
        if (fibonacci.fibonacciRecursive(2) != 1) throw new AssertionError();
        if (fibonacci.fibonacciRecursive(3) != 2) throw new AssertionError();
        if (fibonacci.fibonacciRecursive(4) != 3) throw new AssertionError();
        if (fibonacci.fibonacciRecursive(5) != 5) throw new AssertionError();
        if (fibonacci.fibonacciRecursive(6) != 8) throw new AssertionError();
        if (fibonacci.fibonacciRecursive(7) != 13) throw new AssertionError();
        if (fibonacci.fibonacciRecursive(8) != 21) throw new AssertionError();

        if (fibonacci.fibonacciIterative(0) != 0) throw new AssertionError();
        if (fibonacci.fibonacciIterative(1) != 1) throw new AssertionError();
        if (fibonacci.fibonacciIterative(2) != 1) throw new AssertionError();
        if (fibonacci.fibonacciIterative(3) != 2) throw new AssertionError();
        if (fibonacci.fibonacciIterative(4) != 3) throw new AssertionError();
        if (fibonacci.fibonacciIterative(5) != 5) throw new AssertionError();
        if (fibonacci.fibonacciIterative(6) != 8) throw new AssertionError();
        if (fibonacci.fibonacciIterative(7) != 13) throw new AssertionError();
        if (fibonacci.fibonacciIterative(8) != 21) throw new AssertionError();

        if (fibonacci.fibonacciIterativeFancy(0) != 0) throw new AssertionError();
        if (fibonacci.fibonacciIterativeFancy(1) != 1) throw new AssertionError();
        if (fibonacci.fibonacciIterativeFancy(2) != 1) throw new AssertionError();
        if (fibonacci.fibonacciIterativeFancy(3) != 2) throw new AssertionError();
        if (fibonacci.fibonacciIterativeFancy(4) != 3) throw new AssertionError();
        if (fibonacci.fibonacciIterativeFancy(5) != 5) throw new AssertionError();
        if (fibonacci.fibonacciIterativeFancy(6) != 8) throw new AssertionError();
        if (fibonacci.fibonacciIterativeFancy(7) != 13) throw new AssertionError();
        if (fibonacci.fibonacciIterativeFancy(8) != 21) throw new AssertionError();

        if (fibonacci.fibonacciIterativeDynamic(0) != 0) throw new AssertionError();
        if (fibonacci.fibonacciIterativeDynamic(1) != 1) throw new AssertionError();
        if (fibonacci.fibonacciIterativeDynamic(2) != 1) throw new AssertionError();
        if (fibonacci.fibonacciIterativeDynamic(3) != 2) throw new AssertionError();
        if (fibonacci.fibonacciIterativeDynamic(4) != 3) throw new AssertionError();
        if (fibonacci.fibonacciIterativeDynamic(5) != 5) throw new AssertionError();
        if (fibonacci.fibonacciIterativeDynamic(6) != 8) throw new AssertionError();
        if (fibonacci.fibonacciIterativeDynamic(7) != 13) throw new AssertionError();
        if (fibonacci.fibonacciIterativeDynamic(8) != 21) throw new AssertionError();

        System.out.println("All tests passed!");
    }

    /*
     * O(branches ^ depth) = O(2 ^ N)
     * There are 2 branches per call the depth is N.
     */
    int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    int fibonacciIterative(int n) {
        int a = 0, b = 1, c = 1;

        if (n == 0) {
            return a;
        }
        if (n == 1) {
            return b;
        }
        if (n == 2) {
            return c;
        }

        for (int i = 3; i <= n; i++) {
            a = b;
            b = c;
            c = a + b;
        }

        return c;
    }

    int fibonacciIterativeKindaFancy(int n) {
        int a = 0, b = 1, c;

        if (n == 0) {
            return a;
        }

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    int fibonacciIterativeFancy(int n) {
        int a = 0, b = 1;

        // For n <= 1, a becomes the current n value and b becomes n - 1
        for (int i = 1; i <= n; i++) {
            // Upon entering this loop with i == 1, a == n - 1, and b == n

            // Upon entering this loop with i > 1, a = n - 1 and b = n - 2

            // a becomes n if n == i
            a = a + b;

            // b becomes n - 1 if n == i
            // subtracting b from a gives us the previous value of a, it is undoing the addition above
            b = a - b;
        }

        return a;
    }

    /*
     * Time Complexity: O(n)
     * Extra Space: O(n)
     */
    int fibonacciIterativeDynamic(int n) {
        int numbers[] = new int[n + 2]; // Needs to be +2 to handle case where n == 0
        numbers[0] = 0;
        numbers[1] = 1;

        for (int i = 2; i <= n; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }

        return numbers[n];
    }


}
