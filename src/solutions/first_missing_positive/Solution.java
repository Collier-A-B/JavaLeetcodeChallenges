package solutions.first_missing_positive;

public class Solution {
    protected static int firstMissingPositive(int[] nums) {
        
        // re-arrange the array
        for(int i = 0; i < nums.length; ) {
            if (nums[i] <= nums.length && nums[i] >= 1 && nums[i] != i+1 && nums[nums[i]-1] != nums[i]) {
                int temp = nums[i];
                int targetIndx = nums[i] - 1;
                nums[i] = nums[targetIndx];
                nums[targetIndx] = temp;
            }
            else {
                i++;
            }
        }

        // scan the array for first index that dosn't equal i+1
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1) {
                return i+1;
            }
        }

        return nums.length+1;
    }
}
