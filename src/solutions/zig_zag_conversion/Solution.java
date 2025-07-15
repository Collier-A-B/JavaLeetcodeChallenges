package solutions.zig_zag_conversion;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    protected static String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length())
            return s;

        StringBuilder result = new StringBuilder(s.length());

        List<StringBuilder> array2D = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            array2D.add(new StringBuilder(s.length()));
        }

        int currentRow = 0;
        int direction = 1; // 1 is down, -1 is up

        for (int i = 0; i < s.length(); i++) {
            array2D.get(currentRow).append(s.charAt(i));

            if (currentRow == 0) {

                direction = 1;

            } else if (currentRow == numRows - 1) {

                direction = -1;

            }
            currentRow += direction;
        }
        for (StringBuilder row : array2D){
            result.append(row);
        }
        return result.toString();
    }
}
