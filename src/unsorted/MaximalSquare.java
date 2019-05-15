package unsorted;


/**
 * Here is the coding challenge for this sprint:
 * <p>
 * Have the function MaximalSquare(strArr) take the strArr parameter being passed which will be a 2D matrix of 0 and
 * 1's, and determine the area of the largest square submatrix that contains all 1's. A square submatrix is one of equal
 * width and height, and your program should return the area of the largest submatrix that contains only 1's. For
 * example: if strArr is ["10100", "10111", "11111", "10010"] then this looks like the following matrix:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * For the input above, you can see the bolded 1's create the largest square submatrix of size 2x2, so your program
 * should return the area which is 4. You can assume the input will not be empty.
 * <p>
 * Sample Test Cases
 * Input:new String[] {"0111", "1111", "1111", "1111"}
 * Output:9
 * <p>
 * Input:new String[] {"0111", "1101", "0111"}
 * Output:1
 */
public class MaximalSquare {

    private static int maximalSquare(int[][] grid) {
        int largestMaximalSize = 0;
        boolean[][] checked = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int currentMaximalSize = maximalSquare(grid, checked, 0, i, j);
                if (currentMaximalSize > largestMaximalSize) {
                    largestMaximalSize = currentMaximalSize;
                }
            }
        }

        return largestMaximalSize;
    }

    private static int maximalSquare(int[][] grid, boolean[][] checked, int currentMaximalSize, int x, int y) {
        // Base case
        if (x >= grid.length || y >= grid[0].length || x < 0 || y < 0 || checked[x][y]) {
            return currentMaximalSize;
        }

        int curr = grid[x][y];

        // If zero, return.
        if (curr == 0) {
            return currentMaximalSize;
        }

        if (curr == 1) {
            int size = (int) Math.sqrt((double) currentMaximalSize) + 1;
            boolean isSquare = true;
            if (x - 1 >= 0 && y - 1 >= 0) {
                for (int i = 1; i < size && isSquare; i++) {
                    isSquare = isSquare && grid[x - i][y] == 1;
                    isSquare = isSquare && grid[x][y - i] == 1;

                }
            }
            if (isSquare) {
                for (int i = x; i < x + size; i++) {
                    for (int j = y; j < size; j++) {
                        checked[i][j] = true;
                    }
                }
                currentMaximalSize = size * size;
                return maximalSquare(grid, checked, currentMaximalSize, x + 1, y + 1);
            }
        }

        return currentMaximalSize;
    }

    private static int[][] test0 = new int[][]{
            {1, 0, 1, 0, 0},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0}
    };

    private static int[][] test1 = new int[][]{{1}};

    private static int[][] test2 = new int[][]{{}};

    private static int[][] test3 = new int[][]{
            {1, 1},
            {1, 1}
    };

    private static int[][] test4 = new int[][]{
            {1, 1, 1},
            {1, 1, 1}
    };

    private static int[][] test5 = new int[][]{
            {1, 1},
            {1, 1},
            {1, 1}
    };

    private static int[][] test6 = new int[][]{
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
    };

    private static int[][] test7 = new int[][]{
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 0}
    };

    private static int[][] test8 = new int[][]{
            {0, 1, 1},
            {0, 1, 1},
            {0, 0, 0}
    };

    private static int[][] test9 = new int[][]{
            {0, 0, 0},
            {0, 1, 1},
            {0, 1, 1}
    };

    private static int[][] test10 = new int[][]{
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0}
    };

    private static int[][] test11 = new int[][]{
            {1, 0, 1},
            {0, 1, 1},
            {1, 1, 1}
    };

    private static int[][] test12 = new int[][]{
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
    };

    public static void main(String[] args) {
        int result;

//        result = maximalSquare(test0);
//        if (result != 4) throw new AssertionError(result);
//
//        result = maximalSquare(test1);
//        if (result != 1) throw new AssertionError(result);
//
//        result = maximalSquare(test2);
//        if (result != 0) throw new AssertionError(result);
//
//        result = maximalSquare(test3);
//        if (result != 4) throw new AssertionError(result);
//
//        result = maximalSquare(test4);
//        if (result != 4) throw new AssertionError(result);
//
//        result = maximalSquare(test5);
//        if (result != 4) throw new AssertionError(result);
//
//        result = maximalSquare(test6);
//        if (result != 9) throw new AssertionError(result);
//
//        result = maximalSquare(test7);
//        if (result != 4) throw new AssertionError(result);
//
//        result = maximalSquare(test8);
//        if (result != 4) throw new AssertionError(result);
//
//        result = maximalSquare(test9);
//        if (result != 4) throw new AssertionError(result);
//
//        result = maximalSquare(test10);
//        if (result != 4) throw new AssertionError(result);
//
//        result = maximalSquare(test11);
//        if (result != 4) throw new AssertionError(result);

        result = maximalSquare(test12);
        if (result != 4) throw new AssertionError(result);
    }
}
