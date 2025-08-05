package solutions.all_subsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateAllSubsetsDriver {
    private static final Set<Integer> FAILED_TESTS = new HashSet<>();
    public static void main(String[] args) {
        List<ExpectedResultsPOJO> expectedResultsList = new ArrayList<>();
        List<int[]> inputList = new ArrayList<>();

        // test case 1
        inputList.add(new int[]{1, 2, 3});
        ExpectedResultsPOJO expectedResults1 = new ExpectedResultsPOJO(new ArrayList<>());
        expectedResults1.addResult(new ArrayList<>()); // empty subset
        expectedResults1.addResult(List.of(1));
        expectedResults1.addResult(List.of(2));
        expectedResults1.addResult(List.of(3));
        expectedResults1.addResult(List.of(1, 2));
        expectedResults1.addResult(List.of(1, 3));
        expectedResults1.addResult(List.of(2, 3));
        expectedResults1.addResult(List.of(1, 2, 3));
        expectedResultsList.add(expectedResults1);

        // test case 2
        inputList.add(new int[]{0});
        ExpectedResultsPOJO expectedResults2 = new ExpectedResultsPOJO(new ArrayList<>());
        expectedResults2.addResult(new ArrayList<>()); // empty subset
        expectedResults2.addResult(List.of(0));
        expectedResultsList.add(expectedResults2);

        // Run All Tests
        for (int i = 0; i < inputList.size(); i++) {
            int[] nums = inputList.get(i);
            List<List<Integer>> expectedResults = expectedResultsList.get(i).getExpectedResults();

            System.out.println(String.format("""
                    *********************************************************************************************\n
                    \t\tTest Case %d:\n
                    """, i+1).toCharArray());
            runTest(nums, expectedResults, i+1);
            System.out.println("\n*********************************************************************************************\n");
        }

        if (FAILED_TESTS.isEmpty()) {
            System.out.println("\t\tAll test cases passed successfully!");
        } else {
            System.out.println("\t\tSome test cases failed: " + FAILED_TESTS);
        }
        System.out.println("\n\t\tExiting the program.");

    }

    private static void runTest(int[] nums, List<List<Integer>> expectedResults, int testNum) {
        List<List<Integer>> actualResults = Solution.subsets(nums);
        
        System.out.println("\t\tInput: " + List.of(nums));
        System.out.print("\t\tExpected Results: ");
        for (List<Integer> result : expectedResults) {
            System.out.print(result + "\t");
        }
        System.out.print("\n\t\tActual Results: ");
        for (List<Integer> result : actualResults) {
            System.out.print(result + "\t");
        }
        boolean failed = false;
        if (actualResults.size() != expectedResults.size()) {
            System.out.println("\n\t\tError: Size mismatch between expected and actual results.");
            failed = true;
        }
        for(List<Integer> expected : expectedResults) {
            if (!actualResults.contains(expected)) {
                System.out.println("\n\t\tError: Expected result " + expected + " not found in actual results.");
                failed = true;
            }
        }
        if (!failed) {
            System.out.println("\n\t\tTest Case " + testNum + " Passed!");
        } else {
            System.out.println("\n\t\tTest Case " + testNum + " Failed.");
            FAILED_TESTS.add(testNum);
        }
    }
}
