package solutions.divide_two_ints;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DivideIntsDriver {
    private static Set<Integer> FAILED_TESTS = new HashSet<>();

    public static void main(String[] args) {
        List<InputPair> testCases = new ArrayList<>();                       // List to hold test input
        List<Integer> expectedQuotients = new ArrayList<>();                 // List to hold expected output

        // Add Test cases
        // Test Case 1: 10 / 3 = 3
        testCases.add(new InputPair(10, 3));                                       
        expectedQuotients.add(3);

        // Test Case 2: 7 / -3 = -2
        testCases.add(new InputPair(7, -3));
        expectedQuotients.add(-2);

        // Test Case 3: 1 / 2 = 0
        testCases.add(new InputPair(1, 2));
        expectedQuotients.add(0);

        // Test Case 4: -2147483648 / 1 = -2147483648
        testCases.add(new InputPair(Integer.MIN_VALUE, 1));
        expectedQuotients.add(Integer.MIN_VALUE);

        // Run all test cases
        System.out.println("""
                ********************************************************************
                \n\t\tRUNNING TESTS FOR DIVIDE TWO INTEGERS\n
                ********************************************************************\n
                """);
        for (int i = 0; i < testCases.size(); i++) {
            int dividend = testCases.get(i).getDividend();
            int divisor = testCases.get(i).getDivisor();
            int expectedQuotient = expectedQuotients.get(i);

            System.out.println(String.format("""
                    ********************************************************************
                    \n\t\tTEST CASE %d\n
                    """, i + 1).toCharArray());

            runTest(dividend, divisor, expectedQuotient, i + 1);                                // Run test case

            System.out.println("""
                    \n********************************************************************\n
                    """);
        }

        if (FAILED_TESTS.isEmpty()) {
            System.out.println("All TESTS PASSED!");
        } else {
            System.out.println("\nFAILED TESTS: " + FAILED_TESTS);
        }
        System.out.println("Exiting the program...");
        System.exit(0);
    }

    private static void runTest(int dividend, int divisor, int expectedQuotient, int testNum) {
        System.out.println(String.format("""
                \t\tDividend: %d, Divisor: %d
                \t\tExpected Quotient: %d
                """, dividend, divisor, expectedQuotient).toCharArray());   // print dividend, divisor, and expected quotient

        int resultQuotient = Solution.divide(dividend, divisor);            // calculate quotient and print result
        System.out.println(String.format("""
                \t\tResult Quotient: %d
                """, resultQuotient).toCharArray());

        if (resultQuotient != expectedQuotient) {                           // check if result matches expected quotient
            System.out.println(String.format("""                            
                    \n\t\tTEST CASE %d FAILED!
                    """, testNum).toCharArray());
            FAILED_TESTS.add(testNum);
        } else {
            System.out.println(String.format("""
                    \t\tTEST CASE %d PASSED!
                    """, testNum).toCharArray());
        }
    }
}
