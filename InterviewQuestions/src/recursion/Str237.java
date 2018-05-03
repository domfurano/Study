package recursion;

/*
Provided a string, your mission is to find and count all set (of indices) of characters of that the sum of their ASCII is equal to 237.

Examples

For str = "Hello world!", the output should be
str237(str) = 1.
Here is the ascii values or the above string:
72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33.
From the above list, we can only obtain one set of character which has the ascii sum is 237: H d! (237 = 72 + 32 + 100 + 33).
So the final answer is: 1

For str = "Hello world!!", the output should be
str237(str) = 2.
You have 2 sets H d!. So, the answer is 2.

Input/Ouput

[execution time limit] 3 seconds (java)

[input] string str

Guaranteed constraints:
0 ≤ str.length ≤ 237.

[output] integer
 */

class Str237 {

    public static void main(String[] args) {
//        System.out.println(str237("Hello world!!"));
        System.out.println(str237(new int[]{1, 2, 3}));
    }

//    private static int str237(String str) {
//        char[] chars = str.toCharArray();
//        int sumCount = 0;
//        for (int i = 0; i < chars.length; i++) {
//            boolean[] visited = new boolean[chars.length]; // initialized to false
//            sumCount += sumCount(chars, i, visited, 0, 237, 0);
//        }
//        return sumCount;
//    }

    private static int str237(int[] chars) {
//        char[] chars = str.toCharArray();
        int sumCount = 0;
        for (int i = 0; i < chars.length; i++) {
            boolean[] visited = new boolean[chars.length]; // initialized to false
            sumCount += sumCount(chars, i, visited, 0, 5, 0);
        }
        return sumCount;
    }

    private static int sumCount(int[] chars, int currIndex, boolean[] visited, int currSum, int targetSum, int sumCount) {
        visited[currIndex] = true;

        int charValue = chars[currIndex];

        int tempSum = charValue + currSum;

        if (tempSum < targetSum) {
            currSum = tempSum;
        } else if (tempSum == targetSum) {
            return ++sumCount;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                sumCount += sumCount(chars, i, visited, currSum, targetSum, sumCount);
                visited[i] = false;
//                currSum -= charValue;
            }
        }

        return sumCount;
    }

//    private static int sumCount(char[] chars, int currIndex, boolean[] visited, int currSum, int targetSum, int sumCount) {
//        if (currSum >= targetSum || allTrue(visited)) {
//            return sumCount;
//        }
//
//        visited[currIndex] = true;
//
//        int charValue = chars[currIndex];
//
//        int tempSum = charValue + currSum;
//
//        if (tempSum < targetSum) {
//            currSum = tempSum;
//        } else if (tempSum == targetSum) {
//            return ++sumCount;
//        }
//
//        for (int i = 0; i < visited.length; i++) {
//            if (!visited[i]) {
//                sumCount += sumCount(chars, i, visited, currSum, targetSum, sumCount);
//            }
//        }
//
//        return sumCount;
//    }

    private static boolean allTrue(boolean[] booleans) {
        boolean allTrue = true;
        for (int i = 0; i < booleans.length; i++) {
            allTrue &= booleans[i];
        }
        return allTrue;
    }
}
