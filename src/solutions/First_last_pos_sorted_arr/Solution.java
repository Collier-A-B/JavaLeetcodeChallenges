package solutions.First_last_pos_sorted_arr;

public class Solution {
    protected static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        if (nums.length == 0 || (nums.length == 1 && nums[0] != target))
            return result;
        if (nums.length == 1 && nums[0] == target){
            result[0] = 0;
            result[1] = 0;
            return result;
        }

        result[0] = binarySearch(nums, target, true);
        if (result[0] == -1)
            return result;
        result[1] = binarySearch(nums, target, false);
        return result;
    }

    private static int binarySearch(int[] nums, int target, boolean leftMostIndx){
        int returnIndx = -1;

        // search boundary indices
        int leftBound = 0;
        int rightBound = nums.length-1;

        while(leftBound <= rightBound) {
            int middleIndx = (rightBound + leftBound) / 2;

            if (nums[middleIndx] == target){
                returnIndx = middleIndx;
                if (leftMostIndx){
                    rightBound = middleIndx-1;
                } else {
                    leftBound = middleIndx + 1;
                }
            } else {
                if (target < nums[middleIndx]){
                    rightBound = middleIndx - 1;
                } else {
                    leftBound = middleIndx + 1;
                }
            }
        }

        return returnIndx;
    }
}
