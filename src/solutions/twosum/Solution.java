package solutions.twosum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] retIndices = new int[2];

        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            if (numsMap.containsKey(target - nums[i])) {
                retIndices[0] = numsMap.get(target - nums[i]);
                retIndices[1] = i;
                break;
            }
            numsMap.putIfAbsent(nums[i], i);
        }

        return retIndices;
    }
}
