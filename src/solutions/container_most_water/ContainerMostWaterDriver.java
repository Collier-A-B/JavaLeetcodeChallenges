package solutions.container_most_water;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContainerMostWaterDriver {
    private static Set<Integer> FAILED_TESTS = new HashSet<>();

    public static void main(String[] args) {
        List<int[]> inputList = new ArrayList<>();
        List<Integer> expectedList = new ArrayList<>();

        // Test 1
        int[] input1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        inputList.add(input1);
        expectedList.add(49);

        // Test 2
        int[] input2 = { 1, 1 };
        inputList.add(input2);
        expectedList.add(1);

        // run each test
        System.out.println("""
                \n*************************************************************
                \t\t    Running All Tests
                *************************************************************\n
                """);
        for (int i = 0; i < inputList.size(); i++) {
            runTest(inputList.get(i), expectedList.get(i), i + 1);
        }
    }

    private static void runTest(int[] input, int expectedArea, int testNum) {
        System.out.println(String.format("""
                *************************************************************
                \t\t\tTest Case %d\n
                """, testNum).toCharArray());
        int methodResult = Solution.maxArea(input);

        System.out.println("Input:           " + Arrays.toString(input));
        System.out.println("Expected:        " + expectedArea);
        System.out.println("Method returned: " + methodResult);

        if (expectedArea != methodResult) {
            FAILED_TESTS.add(testNum);
            System.err.println("""
                    \t\t\tTEST FAILED
                    """);
        } else {
            System.out.println("""
                    \t\t\tTEST PASSED
                    """);
        }
        System.out.println("""
                *************************************************************\n\n
                """);
    }
}
