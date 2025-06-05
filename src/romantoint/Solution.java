package romantoint;

public class Solution {
    public int romanToInt(String s) {
        int retInt = 0;
        char curChar;
        for (int i = 0; i < s.length(); ++i) {
            curChar = s.charAt(i);
            if (curChar == 'M') {
                retInt += 1000;
            } else if (curChar == 'D') {
                retInt += 500;
            } else if (curChar == 'C') {
                if (i + 1 != s.length() && s.charAt(i + 1) == 'M') {
                    retInt += 900;
                    i++;
                } else if (i + 1 != s.length() && s.charAt(i + 1) == 'D') {
                    retInt += 400;
                    i++;
                } else {
                    retInt += 100;
                }
            } else if (curChar == 'L') {
                retInt += 50;
            } else if (curChar == 'X') {
                if (i + 1 != s.length() && s.charAt(i + 1) == 'C') {
                    retInt += 90;
                    i++;
                } else if (i + 1 != s.length() && s.charAt(i + 1) == 'L') {
                    retInt += 40;
                    i++;
                } else {
                    retInt += 10;
                }
            } else if (curChar == 'V') {
                retInt += 5;
            } else {
                if (i + 1 != s.length() && s.charAt(i + 1) == 'X') {
                    retInt += 9;
                    i++;
                } else if (i + 1 != s.length() && s.charAt(i + 1) == 'V') {
                    retInt += 4;
                    i++;
                } else {
                    retInt += 1;
                }
            }

        }

        return retInt;
    }
}
