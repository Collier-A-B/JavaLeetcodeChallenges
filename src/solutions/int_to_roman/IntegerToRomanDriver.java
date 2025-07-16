package solutions.int_to_roman;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntegerToRomanDriver {
    private static Set<Integer> FAILED_TESTS = new HashSet<>();
    public static void main(String[] args) {
        // List that hold integer values to be converted to roman numerals
        List<Integer> inputList = new ArrayList<>();

        // List that holds the expected roman numeral 
        List<String> expectedList = new ArrayList<>();

        // Test Case 1
        inputList.add(3749);
        expectedList.add("MMMDCCXLIX");

        // Test Case 2
        inputList.add(58);
        expectedList.add("LVIII");

        // Test Case 3
        inputList.add(1994);
        expectedList.add("MCMXCIV");

        // Test Case 4
        inputList.add(100);
        expectedList.add("C");

        // Run each test case
        int testNum;
        for(testNum = 0; testNum < inputList.size(); testNum++){
            runTestCase(inputList.get(testNum), expectedList.get(testNum), testNum+1);
        }

        // print results of all tests
        System.out.println("\n****************************************************************");
        System.out.println("\n\t\tALL TESTS RUN. YOUR RESULTS ARE...");
        System.out.println("\n\tTESTS PASSED: " + (testNum - FAILED_TESTS.size()));
        System.out.println("\tTESTS FAILED: " + FAILED_TESTS.size());

        if(FAILED_TESTS.isEmpty()) {
            System.out.println("\n\tALL TESTS PASSED. SOLUTION ACCEPTED");
        } else {
            System.out.println("\n\tAT LEAST ONE TEST FAILED. SOLUTION REJECTED");
        }

        System.out.println("\n****************************************************************");
    }

    private static void runTestCase(int integer, String expectedStr, int testNum){
        System.out.println("\n****************************************************************");
        System.out.println("\n\t\t\tTEST CASE " + testNum);

        System.out.println("\n\tInteger to convert:\t\t" + integer);
        System.out.println("\tExpected conversion result:\t" + expectedStr);

        String methodResult = Solution.intToRoman(integer);
        System.out.println("\tMethod returned:\t\t" + methodResult);

        if(methodResult.equals(expectedStr)){
            System.out.println("\n\t\t\tTEST PASSED");
        } else {
            System.out.println("\n\t\t\tTEST FAILED");
            FAILED_TESTS.add(testNum);
        }

        System.out.println("\n****************************************************************");
    }
}
