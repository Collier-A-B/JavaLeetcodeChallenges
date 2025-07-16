package solutions.int_to_roman;

public class Solution {
    
    protected static String intToRoman(int num) {
        StringBuilder retStr = new StringBuilder();

        while(num > 0) {
            int remainder;
            if (num >= 1000) {                  
                remainder = num % 1000;
                num /= 1000;
                for(; num > 0; num--) {
                    retStr.append('M');
                }
            } else if (num >= 100) { 
                remainder = num % 100;
                num /= 100;
                if(num >= 5) {
                    if(num == 9){
                        retStr.append("CM");        //num == 900
                    } else {
                        retStr.append('D');         // num >= 500
                        for(; num > 5; num--) {
                            retStr.append('C');     // num > 500
                        }
                    }
                } else {
                    if(num == 4) {
                        retStr.append("CD");        // num == 400
                    } else {
                        for(; num > 0; num--) {
                            retStr.append('c');     // num >= 100
                        }
                    }
                }
            } else if (num >= 10) {
                remainder = num % 10;
                num /= 10;
                
                if(num >= 5) {
                    if(num == 9) {
                        retStr.append("XC");        // num == 90
                    } else {
                        retStr.append('L');         // num >= 50
                        for(; num > 5; num--) {
                            retStr.append('X');     // num > 50
                        }
                    }
                } else {
                    if(num == 4) {
                        retStr.append("XL");        // num == 40
                    } else {
                        for(; num > 0; num--) {
                            retStr.append('X');     // num >= 10
                        }
                    }
                }
            } else {
                remainder = 0;
                
                if(num >= 5) {
                    if(num == 9) {
                        retStr.append("IX");        // num = 9
                    } else {
                        retStr.append('V');         // num >= 5
                        for(; num > 5; num--) {
                            retStr.append('I');     // num > 5
                        }
                    }
                } else {
                    if(num == 4) {
                        retStr.append("IV");        // num = 4
                    } else {
                        for(; num > 0; num--) {
                            retStr.append('I');     // num >= 1
                        }
                    }
                }
                break;
            } 
            num = remainder;
        }

        return retStr.toString();
    }
}
