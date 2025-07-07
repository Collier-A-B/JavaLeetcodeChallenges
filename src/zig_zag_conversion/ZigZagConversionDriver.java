package zig_zag_conversion;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversionDriver {
    private static int TESTS_PASSED = 0;
    private static int TESTS_FAILED = 0;

    public static void main(String[] args) {

        List<Pair> input = new ArrayList<>();
        List<String> expected = new ArrayList<>();

        // test case 1
        input.add(new Pair("PAYPALISHIRING", 3));
        expected.add("PAHNAPLSIIGYIR");

        // test case 2
        input.add(new Pair("PAYPALISHIRING", 4));
        expected.add("PINALSIGYAHRPI");

        // test case 3
        input.add(new Pair("A", 1));
        expected.add("A");

        try {
            if(input.size() != expected.size())
            {
                throw new Exception("Number of inputs does not equal number of expected outputs");
            }
            for(int i = 0; i < input.size(); i++)
            {
                runTestCase(input.get(i), expected.get(i), i+1);
            }
            if (TESTS_FAILED > 0)
                System.out.println(String.format(
                """
                TESTS PASSED = %d
                TESTS FAILED = %d
                """, TESTS_PASSED, TESTS_FAILED).toCharArray());
            else
                System.out.println(String.format(
                """
                ALL TESTS PASSED
                """).toCharArray());
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private static void runTestCase(Pair input, String expected, int testNum) {
        // extract the input from pair
        String inputString = input.getInputString();
        int numRows = input.getNumRows();


        System.out.println(String.format("""
                            \n\n************************************
                            \tTest Case %d

                            Input string:    %s
                            Num of rows:     %d

                            Expected Result: %s\n
                            """, testNum, inputString, 
                                numRows, expected).toCharArray());
        
        String result = Solution.convert(inputString, numRows);
        System.out.println(String.format("""
                Method returned: %s\n
                """, result).toCharArray());
        if (result.equals(expected)) {
            System.out.println(String.format(
                """
                Test Passed

                ************************************
                """).toCharArray());
            TESTS_PASSED++;
        }
            
        else {
            System.out.println(String.format(
                """
                Test Failed

                ************************************
                """).toCharArray());
            TESTS_FAILED++;
        }
            
    }
}
