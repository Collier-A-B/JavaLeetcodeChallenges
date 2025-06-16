package reverseint32;

// two plausible approaches to reverse an integer without using string manipulation:
// 1. using division and modulus operations
// 2. using a stack to reverse the digits
public class Solution {

    // Cache these values to avoid repeated division operations
    private static final int MAX_DIV_10 = Integer.MAX_VALUE / 10;
    private static final int MIN_DIV_10 = Integer.MIN_VALUE / 10;

    // This method reverses the digits of a 32-bit signed integer.
    // If the reversed integer overflows, it returns 0.
    // The method handles both positive and negative integers correctly.
    // It does not use any string manipulation or conversion to achieve the reversal.
    public static int reverse(int x) {
        // integer that is returned
        // at each iteration of the loop, the value is updated
        int result = 0;

        while (x != 0) {
            // Extract the last digit in x
            int digit = x % 10;

            // Check for overflow before performing the reversal
            if ((result > MAX_DIV_10) || (result == MAX_DIV_10 && digit > 7) 
                    ||(result < MIN_DIV_10) || (result == MIN_DIV_10 && digit < -8)) {
                return 0;
            }
            
            result = (result * 10) + digit;
            x /= 10;
        }

        return result;
    }
}
