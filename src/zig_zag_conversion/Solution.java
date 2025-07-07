package zig_zag_conversion;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    protected static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        String result = "";

        List<StringBuilder> array2D = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            array2D.add(new StringBuilder());
        }

        int currentRow = 0;
        int direction = 1; // 1 is down, -1 is up

        for (int i = 0; i < s.length(); i++) {
            array2D.get(currentRow).append(s.charAt(i));

            System.out.println("Row Num: " + currentRow);
            System.out.println("cuurent char: " + s.charAt(i));

            if (direction == -1 && currentRow == 0) {

                direction = 1;

            } else if (direction == 1 && currentRow == numRows - 1) {

                direction = -1;

            }
            currentRow += direction;
        }
        for (StringBuilder row : array2D){
            String stringRow = row.toString();
            result += stringRow;
        }
        return result;
    }
}
