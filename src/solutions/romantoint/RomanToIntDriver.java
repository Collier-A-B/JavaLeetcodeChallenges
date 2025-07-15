package solutions.romantoint;

public class RomanToIntDriver {
    public static void main(String[] args) {
        Solution s = new Solution();
        test(s, "III", 3);
        test(s,"LVIII",58);
        test(s,"MCMXCIV",1994);
    }

    public static void test(Solution s, String input, int expected) {
        System.out.println("---------------Starting Test---------------");

        int output = s.romanToInt(input);

        System.out.println("Input   : " + input);
        System.out.println("Output  : " + output);
        System.out.println("Expected: " + expected);

        if (output != expected)
            System.err.println("Test Failed");
        else
            System.out.println("Test Passed");
        System.out.println("\n\n\n");
    }
}
