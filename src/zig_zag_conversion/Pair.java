package zig_zag_conversion;

// POJO for a String, Integer Pair
public class Pair {

    private final String inputString;
    private final Integer numRows;

    protected Pair(String inputString, Integer numRows) {
        this.inputString = inputString;
        this.numRows = numRows;
    }

    protected String getInputString() {
        return this.inputString;
    }

    protected Integer getNumRows() {
        return this.numRows;
    }

}
