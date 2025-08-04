package solutions.divide_two_ints;

public class InputPair {
    private final  int dividend;
    private final int divisor;

    protected InputPair(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }
    protected int getDividend() {
        return dividend;
    }
    protected int getDivisor() {
        return divisor;
    }

}
