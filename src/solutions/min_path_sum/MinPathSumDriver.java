package solutions.min_path_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinPathSumDriver {
    public static void main(String[] args) {
        List<int[][]> testCases = new ArrayList<>();
        List<Integer> expectedResults = new ArrayList<>();

        // Test Case 1
        testCases.add(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } });
        expectedResults.add(7);

        // Test Case 2
        testCases.add(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } });
        expectedResults.add(12);

        // Test Case 3
        testCases.add(new int[][] { {1, 2}, {5,6}, {1,1}});
        expectedResults.add(8);

        // Run All Test Cases
        System.out.println("""
                    *****************************************************************
                    \n\t\tRunning All Tests\n
                    *****************************************************************\n
                """);
        for (int i = 0; i < testCases.size(); i++) {
            int[][] grid = testCases.get(i);
            int expected = expectedResults.get(i);

            System.out.println("""
                    *****************************************************************
                    \n\t\tTest Case """ + (i + 1) + """
                        \n
                    """);
            runTestCase(grid, expected, i + 1);
            System.out.println("\n*****************************************************************\n");

        }
    }

    private static void runTestCase(int[][] grid, int expected, int testNum) {
        int result = Solution.minPathSum(grid);

        System.out.println("\t\tInput Grid: ");
        for (int[] row : grid) {
            System.out.println("\t\t" + Arrays.toString(row));
        }
        System.out.println("\t\tExpected Result: " + expected);
        System.out.println("\t\tActual Result: " + result);
        if (result == expected) {
            System.out.println("\n\t\tTest Case " + testNum + " passed!");
        } else {
            System.out.println("\n\t\tTest Case " + testNum + " failed.");
        }
    }
}
