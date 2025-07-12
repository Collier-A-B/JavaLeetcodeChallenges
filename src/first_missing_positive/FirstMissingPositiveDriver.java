package first_missing_positive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstMissingPositiveDriver {
    private static int TESTS_PASSED = 0;
    private static int TESTS_FAILED = 0;
    public static void main(String[] args) {
        List<int[]> input_list = new ArrayList<>();
        List<Integer> expected_output_list = new ArrayList<>();
        
        // Test Case 1
        /* */
        int[] input1 = {1, 2, 0};
        input_list.add(input1);
        expected_output_list.add(3);

        // Test Case 2
        /* */
        int[] input2 = {3, 4, -1, 1};
        input_list.add(input2);
        expected_output_list.add(2);

        // Test Case 3
        /* */
        int[] input3 = {7, 8, 9, 11, 12};
        input_list.add(input3);
        expected_output_list.add(1);

        // Run Test Cases
        for(int i = 0; i < input_list.size(); i++) {
            runTestCase(input_list.get(i), expected_output_list.get(i), i+1);
        }

        System.out.println("All TESTS HAVE BEEN RUN. YOUR RESULTS ARE...\n");

        if (TESTS_FAILED == 0) {
            System.out.println("ALL TESTS PASSED");
        } else {
            System.out.println("Number of failed tests: " + TESTS_FAILED);
            System.out.println("Number of passed tests: " + TESTS_PASSED);
        }
    }

    private static void runTestCase(int[] input_arr, Integer expected_output, int test_num){
        System.out.println(String.format("""
                \n*********************************************
                \t\tTest Case %d\n
                """, test_num).toCharArray());

                int output = Solution.firstMissingPositive(input_arr);

                System.out.println("\tInput array: " + Arrays.toString(input_arr));
                System.out.println("\tExpected output: " + expected_output);
                System.out.println("\tMethod output: " + output);

                if (expected_output.equals(output)){
                    TESTS_PASSED++;
                    System.out.println("\n\tTEST PASSED\n");
                } else {
                    TESTS_FAILED++;
                    System.out.println("\n\tTEST FAILED\n");
                }

                System.out.println(String.format("""
                \n*********************************************\n
                """, test_num).toCharArray());
    }
}
