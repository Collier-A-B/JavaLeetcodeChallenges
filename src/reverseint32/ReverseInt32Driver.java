package reverseint32;

public class ReverseInt32Driver {
    public static void main(String[] args) {
        // Test cases from the instructions
        int[] testInputs = {123, -123, 120};
        int[] expectedOutputs = {321, -321, 21};
        
        boolean allTestsPassed = true;
        
        for (int i = 0; i < testInputs.length; i++) {
            int result = Solution.reverse(testInputs[i]);
            boolean testPassed = result == expectedOutputs[i];
            
            System.out.printf("Test Case %d:%n", i + 1);
            System.out.printf("Input: %d%n", testInputs[i]);
            System.out.printf("Expected: %d%n", expectedOutputs[i]);
            System.out.printf("Actual: %d%n", result);
            System.out.printf("Status: %s%n%n", testPassed ? "PASSED" : "FAILED");
            
            if (!testPassed) {
                allTestsPassed = false;
            }
        }
        
        // Additional edge case tests
        int[] edgeCases = {0, 1534236469, -2147483648};
        int[] edgeCaseExpected = {0, 0, 0}; // These should return 0 due to overflow
        
        for (int i = 0; i < edgeCases.length; i++) {
            int result = Solution.reverse(edgeCases[i]);
            boolean testPassed = result == edgeCaseExpected[i];
            
            System.out.printf("Edge Case %d:%n", i + 1);
            System.out.printf("Input: %d%n", edgeCases[i]);
            System.out.printf("Expected: %d%n", edgeCaseExpected[i]);
            System.out.printf("Actual: %d%n", result);
            System.out.printf("Status: %s%n%n", testPassed ? "PASSED" : "FAILED");
            
            if (!testPassed) {
                allTestsPassed = false;
            }
        }
        
        System.out.println("Overall Test Status: " + (allTestsPassed ? "ALL TESTS PASSED" : "SOME TESTS FAILED"));
    }
}
