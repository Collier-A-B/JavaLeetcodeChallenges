package solutions.romantoint;

public class Solution {
    public int romanToInt(String s) {
        int retInt = 0;
        char curChar;
        for (int i = 0; i < s.length(); ++i) {
            curChar = s.charAt(i);
            switch (curChar) {
                case 'M' -> retInt += 1000;
                case 'D' -> retInt += 500;
                case 'C' -> {
                    if (i + 1 != s.length() && s.charAt(i + 1) == 'M') {
                        retInt += 900;
                        i++;
                    } else if (i + 1 != s.length() && s.charAt(i + 1) == 'D') {
                        retInt += 400;
                        i++;
                    } else {
                        retInt += 100;
                    }
                }
                case 'L' -> retInt += 50;
                case 'X' -> {
                    if (i + 1 != s.length() && s.charAt(i + 1) == 'C') {
                        retInt += 90;
                        i++;
                    } else if (i + 1 != s.length() && s.charAt(i + 1) == 'L') {
                        retInt += 40;
                        i++;
                    } else {
                        retInt += 10;
                    }
                }
                case 'V' -> retInt += 5;
                default -> {
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

        }

        return retInt;
    }
}