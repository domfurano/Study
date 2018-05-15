package stuffs;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Islands {

    /*
    x..x.x
    xx....
    x..x.x
    .xx..x
    ..xxxx
    xx....
     */

    public static void main(String[] args) {
        char[][] map = new char[][]{
                {'x', '.', '.', 'x', '.', 'x'},
                {'x', 'x', '.', '.', '.', '.'},
                {'x', '.', '.', 'x', '.', 'x'},
                {'.', 'x', 'x', '.', '.', 'x'},
                {'.', '.', 'x', 'x', 'x', 'x'},
                {'x', 'x', '.', '.', '.', '.'}
        };

        int biggest = biggest_island(map);
        System.out.println(biggest);
    }

    /*
     * Complete the biggest_island function below.
     */
    static int largestIslandSize = 0;

    static int biggest_island(char[][] grid) {
        /*
         * Write your code here.
         */
        boolean[][] checkedIslands = new boolean[grid.length][grid[0].length]; // not sure how to check size

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int currentIslandSize = largestIsland(grid, checkedIslands, 0, i, j);
                if (currentIslandSize > largestIslandSize) {
                    largestIslandSize = currentIslandSize;
                }
            }
        }

        return largestIslandSize;

    }

    static int largestIsland(char[][] grid, boolean[][] checkedIslands, int currentIslandSize, int x, int y) {
        // Base case
        if (x >= grid.length || y >= grid[0].length || x < 0 || y < 0 || checkedIslands[x][y]) {
            return currentIslandSize;
        }

        // Check if island
        if (grid[x][y] == 'x') {
            checkedIslands[x][y] = true;
            currentIslandSize++;
        } else {
            return currentIslandSize;
        }

        // Recursive steps
        currentIslandSize = largestIsland(grid, checkedIslands, currentIslandSize, x - 1, y);
        currentIslandSize = largestIsland(grid, checkedIslands, currentIslandSize, x + 1, y);
        currentIslandSize = largestIsland(grid, checkedIslands, currentIslandSize, x, y + 1);
        currentIslandSize = largestIsland(grid, checkedIslands, currentIslandSize, x, y - 1);

        return currentIslandSize;
    }

    private static final Scanner scanner = new Scanner(System.in);

//    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        int gridRows = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//        int gridColumns = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
//        char[][] grid = new char[gridRows][gridColumns];
//
//        for (int gridRowItr = 0; gridRowItr < gridRows; gridRowItr++) {
//            String[] gridRowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
//            for (int gridColumnItr = 0; gridColumnItr < gridColumns; gridColumnItr++) {
//                String gridItemStr = gridRowItems[gridColumnItr];
//
//                char gridItem = gridItemStr.charAt(0);
//                grid[gridRowItr][gridColumnItr] = gridItem;
//            }
//        }
//
//        int res = biggest_island(grid);

//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

//        scanner.close();
//    }
}