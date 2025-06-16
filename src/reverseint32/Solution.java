package reverseint32;

// two plausible approaches to reverse an integer without using string manipulation:
// 1. using division and modulus operations
// 2. using a stack to reverse the digits
public class Solution {
    // This method reverses the digits of a 32-bit signed integer.
    // If the reversed integer overflows, it returns 0.
    // The method handles both positive and negative integers correctly.
    // It does not use any string manipulation or conversion to achieve the reversal.

    public static int reverse(int x) {
        // integer that is returned
        // at each iteration of the loop, the value is updated
        int result = 0;
        
        

        while (x != 0) {
            // the calculated remainder of "x" at each iteration
            int remainder = x % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && remainder > 7))
                return 0;
            else if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && remainder < -8))
                return 0;
            
            result = (result * 10) + remainder;
            x /= 10;
        }

        return result;
    }
}
