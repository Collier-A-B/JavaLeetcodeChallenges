package solutions.all_subsets;

import java.util.List;

public class ExpectedResultsPOJO {
    private List<List<Integer>> expectedResults;

    protected ExpectedResultsPOJO(List<List<Integer>> expectedResults) {
        this.expectedResults = expectedResults;
    }

    protected List<List<Integer>> getExpectedResults() {
        return expectedResults;
    }

    protected void addResult(List<Integer> result) {
        this.expectedResults.add(result);
    }
}
