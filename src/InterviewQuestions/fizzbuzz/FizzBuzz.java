package InterviewQuestions.fizzbuzz;

import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args) {
        fizzBuzzLessComparisons();
    }

    private static void fizzBuzz() {
        for (int i = 1; i < 101; i++) {
            boolean divisibleBy3 = i % 3 == 0;
            boolean divisibleBy5 = i % 5 == 0;
            if (divisibleBy3) {
                System.out.print("Fizz");
            }
            if (divisibleBy5) {
                System.out.print("Buzz");
            }
            if (!(divisibleBy3 || divisibleBy5)) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    private static void fizzBuzzFunctional() {
        IntStream.range(1, 101).forEach(i -> {
            boolean divisibleBy3 = i % 3 == 0;
            boolean divisibleBy5 = i % 5 == 0;
            if (divisibleBy3) {
                System.out.print("Fizz");
            }
            if (divisibleBy5) {
                System.out.print("Buzz");
            }
            if (!(divisibleBy3 || divisibleBy5)) {
                System.out.print(i);
            }
            System.out.println();
        });
    }

    private static void fizzBuzzLessComparisons() {
        for (int i = 1; i < 101; i++) {
            boolean divisibleBy3 = i % 3 == 0;
            boolean divisibleBy5 = i % 5 == 0;
            if (!(divisibleBy3 || divisibleBy5)) {
                System.out.println(i);
                continue;
            }
            if (divisibleBy3) {
                System.out.print("Fizz");
            }
            if (divisibleBy5) {
                System.out.print("Buzz");
            }
            System.out.println();
        }
    }
}