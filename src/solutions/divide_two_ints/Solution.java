package solutions.divide_two_ints;

public class Solution {
    protected static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Handle overflow case
        }

        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1; // Determine the sign of the result

        dividend = Math.abs(dividend);      // DOES NOT WORK WHEN DIVIDEND IS MIN_VALUE TODO
        divisor = Math.abs(divisor);

        int quotient = 0;

        for(int i = 31; i >= 0; i--) {
            int leftShiftedDivisor = divisor << i; // Left shift divisor by i bits
            if (leftShiftedDivisor <= 0) {
                continue; // Skip if the left shifted divisor is negative
            }
            if ((divisor << i) <= dividend) {
                dividend -= (divisor << i); // Subtract the divisor shifted by i from the dividend
                quotient |= (1 << i); // Add the corresponding power of two to the quotient
            }
        }

        if (sign == -1) {
            quotient = 0-quotient; // Apply the sign to the quotient
        }
        return quotient; 
        
    }
}
