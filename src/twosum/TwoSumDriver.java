package twosum;

import java.util.Arrays;

public class TwoSumDriver {
    public static void main(String[] args) {
        final Solution s = new Solution();
        test1(s);
        //test2();
        //test3();
    }
    public static void test1(Solution s){
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] expected = {0, 1};

        int[] output = s.twoSum(nums, target);

        if (Arrays.equals(output, expected))
            System.out.println("Test Passed");
        else
            System.err.println("test failed");
    }
}
