package solutions.combination_sum;

import java.util.List;

public class ExpectedResultPOJO {
    private List<List<Integer>> expectedResults;

    protected ExpectedResultPOJO(List<List<Integer>> expectedResults) {
        this.expectedResults = expectedResults;
    }

    protected List<List<Integer>> getExpectedResults() {
        return expectedResults;
    }

    protected void addCombination(List<Integer> combination) {
        expectedResults.add(combination);
    }
}
