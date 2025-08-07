package solutions.permutations;

import java.util.ArrayList;
import java.util.List;

public class ExpectedOutputPOJO {
    private List<List<Integer>> output;

    protected ExpectedOutputPOJO() {
        output = new ArrayList<>();
    }

    protected void addPermutations(int[][] newPermutations) {
        for(int[] perm : newPermutations) {
            List<Integer> listPerm = new ArrayList<>();
            for(int i : perm) {
                listPerm.add(i);
            }
            output.add(listPerm);
        }
    }

    protected List<List<Integer>> getOutput() {
        return output;
    }
}
