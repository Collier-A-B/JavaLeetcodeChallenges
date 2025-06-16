package reverseint32;

// two plausible approaches to reverse an integer without using string manipulation:
// 1. using division and modulus operations
// 2. using a stack to reverse the digits
public class Solution {
    // This method reverses the digits of a 32-bit signed integer.
    // If the reversed integer overflows, it returns 0.
    // The method handles both positive and negative integers correctly.
    // It does not use any string manipulation or conversion to achieve the reversal.

    // maximum integer value allowed
    private static final int INT_MAX = Integer.MAX_VALUE;

    // minimum integer value allowed
    private static final int INT_MIN = Integer.MIN_VALUE;

    public static int reverse(int x) {
        // integer that is returned
        // at each iteration of the loop, the value is updated
        int result = 0;
        
        // the calculated remainder of "x" at each iteration
        int remainder;

        if (x / 10 == 0)
            return x;

        while (x != 0) {
            remainder = x % 10;
            if (result > 0 &&(result > (INT_MAX - remainder) / 10))
                return 0;
            else if (result < 0 && (result < (INT_MIN - remainder) / 10))
                return 0;
            
            result = (result * 10) + remainder;
            x /= 10;
        }

        return result;
    }
}
