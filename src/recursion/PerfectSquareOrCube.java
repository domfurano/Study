//package recursion;
//
//public class PerfectSquareOrCube {
//
//    public static void main(String[] args) {
//        System.out.println(perfectSquareOrCube(414) == 2);
//    }
//
//    private static int perfectSquareOrCube(int number) {
//        char[] c = Integer.toString(number).toCharArray();
//        char[][] results = new char[factorial(c.length)][3];
//        perfectRec(c, 0, results, 0, new char[3], 0);
//        return 1;
//    }
//
//    private static void perfectRec(char[] chars, int curr, char[][] results, int resultsIndex, char[] result, int resultIndex) {
//        if (curr > chars.length) {
//            return;
//        }
//        for (int i = curr; i < chars.length; i++) {
//            results[i][resultIndex] = chars[i + resultIndex];
//            perfectRec(chars, i, results, (resultIndex + 1) % chars.length);
//        }
//    }
//
//    private static int factorial(int n) {
//        if (n < 2) {
//            return 1;
//        }
//        return factorial(n - 1) * n;
//    }
//
//    private static void perfectR()
//}
