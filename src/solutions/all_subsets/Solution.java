package solutions.all_subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    protected static List<List<Integer>> subsets(int[] nums) {
        class BackTracker {
            private List<List<Integer>> result;

            BackTracker() {
                result = new ArrayList<>((int)Math.pow(2, nums.length));
                result.add(new ArrayList<>());
            }

            void generateSubsets(int startIndx, List<Integer> subset) {
                for (int i = startIndx; i < nums.length; i++) {
                    subset.add(nums[i]);
                    generateSubsets(i+1, subset);
                    List<Integer> newSubset= new ArrayList<>(subset.size());
                    newSubset.addAll(subset);
                    result.add(newSubset);
                    subset.remove(subset.size()-1);
                }
            }

            List<List<Integer>> getResult() {
                return this.result;
            }
        }

        BackTracker bt = new BackTracker();

        bt.generateSubsets(0, new ArrayList<>());

        return bt.getResult();
    }
}
