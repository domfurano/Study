package stuffs;

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
}
