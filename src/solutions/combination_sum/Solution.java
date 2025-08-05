package solutions.combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    protected static List<List<Integer>> combinationSum(int[] candidates, int target) {
        class BackTrackClass{
            List<List<Integer>> resultCombinations = new ArrayList<>();
            List<List<Integer>> getResultCombinations() {
                return resultCombinations;
            }
            boolean backTrackApproach(int remaining, int startIndx, List<Integer> path) {
                if (remaining <= 0) {
                    if (remaining == 0) {
                        List<Integer> newPath = new ArrayList<>();
                        newPath.addAll(path);
                        resultCombinations.add(newPath);// base case: found viable combination, else overshot target
                    }                                              
                        
                    return true;
                }                                              // recursive case
                for (int i = startIndx; i < candidates.length; i++) {
                    path.add(candidates[i]);
                    boolean overTarget = backTrackApproach(remaining - candidates[i], i, path);
                    path.remove(path.size() - 1); 
                    if(overTarget)
                        break;
                }
                
                return false;
            };
        }

        Arrays.sort(candidates);

        BackTrackClass bt = new BackTrackClass();
        bt.backTrackApproach(target, 0, new ArrayList<>());

        return bt.getResultCombinations();
    }

    
    
}
