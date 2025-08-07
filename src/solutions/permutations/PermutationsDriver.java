package solutions.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsDriver {
    private static final Set<Integer> FAILED_TESTS = new HashSet<>();
    public static void main(String[] args) {
        List<int[]> inputList = new ArrayList<>();
        List<ExpectedOutputPOJO> expectedOutList = new ArrayList<>();

        // Test Case 1
        inputList.add(new int[]{1, 2, 3});
        ExpectedOutputPOJO expectedPerms1 = new ExpectedOutputPOJO();
        int[][] expected1 = new int[][] {{1,2,3},{1,3,2},{2,1,3},{2,3,1},{3,1,2},{3,2,1}};
        expectedPerms1.addPermutations(expected1);
        expectedOutList.add(expectedPerms1);
        
        // Test Case 2
        inputList.add(new int[]{0,1});
        ExpectedOutputPOJO expectedPerms2 = new ExpectedOutputPOJO();
        int[][] expected2 = new int[][] {{0,1}, {1,0}};
        expectedPerms2.addPermutations(expected2);
        expectedOutList.add(expectedPerms2);

        // Test Case 3
        inputList.add(new int[]{1});
        ExpectedOutputPOJO expectedPerms3 = new ExpectedOutputPOJO();
        int[][] expected3 = new int[][] {{1}};
        expectedPerms3.addPermutations(expected3);
        expectedOutList.add(expectedPerms3);

        // Run All Tests
        for(int i = 0; i < inputList.size(); i++) {
            int[] input = inputList.get(i);
            List<List<Integer>> expected = expectedOutList.get(i).getOutput();

            System.out.println(String.format("""
                    \n************************************************************
                    \n\t\tTest Case %d\n
                    """, i+1).toCharArray());
            runTest(input, expected, i+1);
            System.out.println("\n************************************************************\n");
        }

        if(FAILED_TESTS.isEmpty()) {
            System.out.println("\t\tALL TESTS PASSED");
        } else {
            System.out.println("FAILED TESTS: " + FAILED_TESTS.toString());
        }
    }

    private static void runTest(int[] input, List<List<Integer>> expectedOutput, int testNum) {
        List<List<Integer>> methodResult = Solution.permute(input);

        System.out.println("\t\tInput: " + Arrays.toString(input));
        System.out.println("\t\tExpected Output: ");
        for(List<Integer> permutation : expectedOutput) {
            System.out.println("\t\t" + permutation.toString());
        }
        System.out.println("\t\tMethod Returned: ");
        for(List<Integer> permutation : methodResult) {
            System.out.println("\t\t" + permutation.toString());
        }

        if(expectedOutput.size() != methodResult.size()) {
            System.out.println("\t\tTEST FAILED: Wrong number of permutations");
            FAILED_TESTS.add(testNum);
        } else {
            boolean failedTest = false;
            for(List<Integer> expectedPerm : expectedOutput){
                if (!methodResult.contains(expectedPerm)) {
                    FAILED_TESTS.add(testNum);
                    System.out.println("\t\tTEST FAILED: Missing expected permutation(s)");
                    failedTest = true;
                    break;
                }
            }
            if(!failedTest)
                System.out.println("TEST PASSED");
        }
    }
}
