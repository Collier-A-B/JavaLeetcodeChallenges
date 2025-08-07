package solutions.count_and_say;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountAndSayDriver {

    private static Set<Integer> FAILED_TESTS = new HashSet<>();
    public static void main(String[] args) {
        List<Integer> inputList = new ArrayList<>();
        List<String> expectedOutputList = new ArrayList<>();

        inputList.add(1);
        expectedOutputList.add("1");

        inputList.add(4);
        expectedOutputList.add("1211");

        // Run All Tests
        for (int i = 0; i < inputList.size(); i++) {
            int input = inputList.get(i);
            String expectedOutput = expectedOutputList.get(i);

            System.out.println(String.format("""
                    \n**********************************************************
                    \n\t\tTest Case %d\n
                    """, i+1).toCharArray());
            runTest(input, expectedOutput, i + 1);
            System.out.println("\n**********************************************************\n");
        }

        if (FAILED_TESTS.isEmpty()) {
            System.out.println("\n\t\tAll Tests Passed!");
        } else {
            System.out.println("\n\t\tFailed Tests: " + FAILED_TESTS);
        }

    }

    private static void runTest(int input, String expectedOutput, int testNum) {
        String methodOutput = Solution.countAndSay(input);

        System.out.println(String.format("""
                \t\tInput: %d
                \t\tExpected Output: %s
                \t\tMethod Output: %s
                """, input, expectedOutput, methodOutput).toCharArray());

        if (methodOutput.equals(expectedOutput)) {
            System.out.println("\n\t\tTest Passed!");
        } else {
            System.out.println("\n\t\tTest Failed!");
            FAILED_TESTS.add(testNum);
        }
    }
}
