package stuffs;

/*
A sequence of integers is called a zigzag sequence if each of its elements is either strictly less than all its
neighbors or strictly greater than all its neighbors. For example, the sequence 4 2 3 1 5 3 is a zigzag,
but 7 3 5 5 2 and 3 8 6 4 5 aren't. Sequence of length 1 is also a zigzag.
 */

public class LongestZigZag {
    public static void main(String[] args) {
        int[] a = new int[]{9, 8, 8, 5, 3, 5, 3, 2, 8, 6};
        System.out.println(zigzag(a) == 4);
    }

    static int zigzag(int[] a) {
        int max = 1;
        if (a.length == 1) {
            return max;
        } else if (a.length == 2) {
            if (a[0] != a[1]) {
                max = 2;
            }
        } else {
            max = zigzagRecursive(a, 1, 2, 0);
        }
        return max;
    }

    static int zigzagRecursive(int[] a, int i, int currSize, int maxSize) {
        if (i >= a.length - 1) {
            return maxSize;
        }

        if (a[i] > a[i - 1] && a[i] > a[i + 1] ||
                a[i] < a[i - 1] && a[i] < a[i + 1]) {
            currSize++;
        } else {
            currSize = 2;
        }

        if (currSize > maxSize) {
            maxSize = currSize;
        }

        maxSize = zigzagRecursive(a, ++i, currSize, maxSize);

        return maxSize;
    }
}
