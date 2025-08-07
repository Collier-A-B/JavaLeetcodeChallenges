package solutions.count_and_say;

public class Solution {
    protected static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String previous = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();

        char currentChar = previous.charAt(0);
        int currentCharOccurences = 1;
        for (int i = 1;; i++) {
            if(i == previous.length() || previous.charAt(i) != currentChar) {
                result.append(currentCharOccurences);
                result.append(currentChar);
                if(i == previous.length())
                    break;
                currentChar = previous.charAt(i);
                currentCharOccurences = 1;
            } else {
                currentCharOccurences += 1;
            }
        }
        return result.toString();
    }
}
