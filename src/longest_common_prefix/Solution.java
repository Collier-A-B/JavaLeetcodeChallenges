package longest_common_prefix;

public class Solution {
    protected static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];                                             // if only one string passed, return it
        }

        StringBuilder longestPrefix = new StringBuilder("");            // declare string builder for return value

        boolean charNotEqualFlag = false;                               // boolean flag that is only true if two strings
                                                                        // don't share the same character at a given index
        for (int strIndx = 0;; strIndx++) {
            if (strs[0].length() == strIndx)                            // if the entire string has been iterated over, return
                break;
            char currentCharCanidate = strs[0].charAt(strIndx);         // character to be added to return string, if it is
                                                                        // shared
                                                                        // across all strings in strs[] at this indx
            for (String str : strs) {
                if (str.length() == strIndx ||
                        str.charAt(strIndx) != currentCharCanidate) {   // iterate over each str in strs[]
                    charNotEqualFlag = true;
                    break;
                }
            }
            if (charNotEqualFlag) {                                     // exits loop if a string does not share same char as others
                                                                        // at this indx
                break;
            }
            longestPrefix.append(currentCharCanidate);                  // append string to return value
        }
        return longestPrefix.toString();                                // return the generated prefix string
    }
}
