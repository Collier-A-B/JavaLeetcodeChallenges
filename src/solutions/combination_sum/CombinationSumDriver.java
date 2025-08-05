package solutions.combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumDriver {
    private static  Set<Integer> FAILED_TESTS = new HashSet<>();
    public static void main(String[] args) {
        List<int[]> canidatesList = new ArrayList<>();
        List<Integer> targets = new ArrayList<>();
        List<ExpectedResultPOJO> expecResults = new ArrayList<>();

        // Add test cases
        // Test case 1
        canidatesList.add(new int[]{2, 3, 6, 7});
        targets.add(7);
        ExpectedResultPOJO expectedResult1 = new ExpectedResultPOJO(new ArrayList<>());
        expectedResult1.addCombination(Arrays.asList(2, 2, 3));
        expectedResult1.addCombination(Arrays.asList(7));
        expecResults.add(expectedResult1);

        // Test case 2
        canidatesList.add(new int[]{2, 3, 5});
        targets.add(8);
        ExpectedResultPOJO expectedResult2 = new ExpectedResultPOJO(new ArrayList<>());
        expectedResult2.addCombination(Arrays.asList(2, 2, 2, 2));
        expectedResult2.addCombination(Arrays.asList(2, 3, 3));
        expectedResult2.addCombination(Arrays.asList(3, 5));
        expecResults.add(expectedResult2);

        // Test case 3
        canidatesList.add(new int[]{2});
        targets.add(1);
        ExpectedResultPOJO expectedResult3 = new ExpectedResultPOJO(new ArrayList<>());
        expecResults.add(expectedResult3);

        
        // Run each test case
        for (int i = 0; i < canidatesList.size(); i++) {
            int[] canidates = canidatesList.get(i);
            int target = targets.get(i);

            System.out.println(String.format("""
                    *********************************************************************************************\n
                    \t\tRunning Test Case %d\n
                    """, i+1).toCharArray());
            runTest(canidates, target, expecResults.get(i).getExpectedResults(), i + 1);
            System.out.println("\n*********************************************************************************************\n");
        }

        if (FAILED_TESTS.isEmpty()) {
            System.out.println("\t\tAll test cases passed successfully!");
        } else {
            System.out.println("\t\tFailed test cases: " + FAILED_TESTS);
        }
        System.out.println("\t\tEnding Program\n");

    }

    private static void runTest(int[] canidates, int target, List<List<Integer>> expectedCombinations, int testNum) {
        List<List<Integer>> result = Solution.combinationSum(canidates, target);
        System.out.println("\t\tCandidates: " + Arrays.toString(canidates));
        System.out.println("\t\tTarget:     " + target);

        System.out.println("\t\tExpected Combinations: ");
        for(List<Integer> combination : expectedCombinations) {
            System.out.println("\t\t" + combination);
        }
        System.out.println("\t\tActual Combinations: ");
        for(List<Integer> combination : result) {
            System.out.println("\t\t" + combination);
        }

        for(List<Integer> expectedComb : expectedCombinations) {
            if (!result.contains(expectedComb)) {
                System.out.println("\t\tMissing expected combination: " + expectedComb);
                if(!FAILED_TESTS.contains(testNum)) {
                    FAILED_TESTS.add(testNum);
                }
            }
        }
        if (FAILED_TESTS.contains(testNum)) {
            System.out.println("\n\t\tTest Case " + testNum + " FAILED!");
        } else {
            System.out.println("\n\t\tTest Case " + testNum + " PASSED!");
        }
        System.out.println();
    }
}
