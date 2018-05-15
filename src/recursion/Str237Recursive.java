package recursion;

import java.util.Arrays;

public class Str237Recursive {

    public static void main(String[] args) {
//        System.out.println(str237("What is 237?"));
//        System.out.println(str237("Hello world!!"));
        System.out.println(str237(new int[] {5, 6, 5}));
    }

//    static int str237(String str) {
//        char[] chars = str.toCharArray();
////        Arrays.sort(chars);
//        return check(chars, 0, 0);
//    }
    static int str237(int[] ints) {
//        Arrays.sort(ints);
        return check(ints, 0, 0, 10);
    }

    // recursive method considers paths with and without each letter
    // @parm chars is sorted char array of original str
    // @parm index is current index
    // @parm sum is sum of letters in current path
//    static int check(char[] chars, int index, int sum) {
//        if (index >= chars.length) {
//            return 0;
//        }
//
//        char character = chars[index];
//
//        int currentSum = character + sum;
//
//        if (currentSum == 237) {
//            return 1 + check(chars, index + 1, sum);
//        } else if (currentSum < 237) {
//            return check(chars, index + 1, currentSum) +
//                    check(chars, index + 1, sum);
//        } else {
//            return 0;
//        }
//    }
    static int check(int[] ints, int index, int sum, int target) {
        if (index >= ints.length) {
            return 0;
        }

        int currInt = ints[index];

        int currentSum = currInt + sum;

        if (currentSum == target) {
            return 1 + check(ints, index + 1, sum, target);
        } else if (currentSum < target) {
            return check(ints, index + 1, currentSum, target) +
                    check(ints, index + 1, sum, target);
        } else {
            return 0;
        }
    }
}
