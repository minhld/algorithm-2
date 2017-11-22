package com.usu.test.leetcode;

public class test8_atoi {
    public int myAtoi(String str) {
        str = str.trim();
        
        boolean isNegative = false;
        StringBuffer fStr = new StringBuffer();
        int intVal = 0;
        for (int i = 0; i < str.length(); i++) {
            intVal = (int) str.charAt(i);
            if (((intVal == 43 || intVal == 45) && i == 0) || (intVal >= 48 && intVal <= 57)) {
                fStr.append(str.charAt(i));
                if (intVal == 45) {
                    isNegative = true;
                }
            } else {
                break;
            }
        }

        str = fStr.toString();
        if (str.length() == 0) return 0;
        
        if (str.equals("+") || str.equals("-")) {
            return 0;
        }
        
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            if (!isNegative) {
                return 2147483647;
            } else {
                return -2147483648;
            }
        }
    }

}
