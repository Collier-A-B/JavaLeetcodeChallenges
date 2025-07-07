package First_last_pos_sorted_arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstLastPositionDriver {
    public static void main(String[] args) {
        try {
            List<int[]> inputs = new ArrayList<>();
            List<Integer> targets = new ArrayList<>();
            List<int[]> expectedResult = new ArrayList<>();

            // Test Case 1
            final int[] input1 = {5, 7, 7, 8, 8, 10};
            final int[] expected1 = {3,4};
            inputs.add(input1);
            targets.add(8);
            expectedResult.add(expected1);

            // Test Case 2
            final int[] input2 = input1;
            final int[] expected2 = {-1, -1};
            inputs.add(input2);
            targets.add(6);
            expectedResult.add(expected2);

            // Test Case 3
            final int[] input3 = {};
            final int[] expected3 = {-1, -1};
            inputs.add(input3);
            targets.add(0);
            expectedResult.add(expected3);

            if (expectedResult.size() != inputs.size())
                throw new Exception("expectedResults.size() != inputs.size()");

            if (expectedResult.size() != targets.size())
                throw new Exception("expectedResults.size() != targets.size()");
            
            if (inputs.size() != targets.size())
                throw new Exception("inputs.size() != targets.size()");
            for(int i = 0; i < inputs.size(); i++) {
                int[] expected = expectedResult.get(i);
                int[] input = inputs.get(i);
                int target = targets.get(i);

                int[] methodResult = Solution.searchRange(input, target);

                System.out.println(String.format(
                        """
                        \n****************************************
                        \tTest Case %d
                        """, i+1).toCharArray());
                System.out.println("\tInput: " + Arrays.toString(input));
                System.out.println("\tTarget num: " + target);
                System.out.println("\tExpected result: " + Arrays.toString(expected));
                System.out.println("\tMethod Result: " + Arrays.toString(methodResult));
                System.out.println("****************************************\n");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
