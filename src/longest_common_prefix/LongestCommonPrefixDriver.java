package longest_common_prefix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestCommonPrefixDriver {
    //private static int TESTS_PASSED = 0;
    //private static int TESTS_FAILED = 0;
    private static Set<Integer> FAILED_TESTS = new HashSet<>();
    public static void main(String[] args) {
        List<String[]> inputList = new ArrayList<>();
        List<String> expectedOutputList = new ArrayList<>();

        // Test Case 1
        String[] input1 = {"flower", "flow", "flight"};
        String expected = "fl";
        inputList.add(input1);
        expectedOutputList.add(expected);

        // Test Case 2
        String[] input2 = {"dog", "racecar", "car"};
        expected = "";
        inputList.add(input2);
        expectedOutputList.add(expected);

        // run the tests
        int i;
        for(i = 0; i < inputList.size(); i++) {
            runTestCase(inputList.get(i), expectedOutputList.get(i), i+1);
        }

        System.out.println("\n**************************************************************************************");
        System.out.println("\n\tALL TESTS HAVE BEEN RUN, YOUR RESULTS ARE...");
        System.out.println("\n\ttests passed: " + (i-FAILED_TESTS.size()));
        System.out.println("\ttests failed: " + FAILED_TESTS.size());
        if(FAILED_TESTS.isEmpty()) {
            System.out.println("\n\tALL TESTS PASSED. SOLUTION ACCEPTED.");
        } else {
            System.out.print("\n\tYOUR SOLUTION FAILED THE FOLLOWING TESTS: ");
            for(int test : FAILED_TESTS) {
                System.out.print(test + ", ");
            }
            System.out.println("\n\tSOLUTION REJECTED");
        }
    }

    private static void runTestCase(String[] inputStrings, String expectedOutput, int testNum){
        System.out.println("\n**************************************************************************************");
        System.out.println("\n\t\t\t\tTest Case " + testNum);

        System.out.println("\n\tInput Strings: " + Arrays.toString(inputStrings));
        System.out.println("\tExpected output: " + expectedOutput);
        
        String result = Solution.longestCommonPrefix(inputStrings);
        System.out.println("\n\tMethod returned: " + result);

        if (result.equals(expectedOutput)){
            System.out.println("\n\tTEST PASSED");
            //TESTS_PASSED++;
        }
        else {
            System.out.println("\n\n\tTEST FAILED");
            //TESTS_FAILED++;
            FAILED_TESTS.add(testNum);
        }

        System.out.println("\n**************************************************************************************\n");
    }
}
