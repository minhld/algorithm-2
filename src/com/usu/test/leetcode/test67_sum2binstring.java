package com.usu.test.leetcode;

public class test67_sum2binstring {
    public String addBinary(String a, String b) {
        StringBuilder bufStr = new StringBuilder();
        
        int minLen = (int) Math.min(a.length(), b.length());
        
        int alen = a.length() - 1, blen = b.length() - 1;
        int sim = 0, buff = 0, rem;
        int a1, b1;
        
        while (sim < minLen) {
            a1 = Character.getNumericValue(a.charAt(alen - sim));
            b1 = Character.getNumericValue(b.charAt(blen - sim));
            rem = (a1 + b1 + buff) % 2;
            buff = (a1 + b1 + buff) / 2;
            bufStr.insert(0, rem);
            sim++;
        }
        
        while (a.length() > sim) {
            a1 = Character.getNumericValue(a.charAt(alen - sim));
            rem = (a1 + buff) % 2;
            buff = (a1 + buff) / 2;
            bufStr.insert(0, rem);
            sim++;
        }
        
        while (b.length() > sim) {
            b1 = Character.getNumericValue(b.charAt(blen - sim));
            rem = (b1 + buff) % 2;
            buff = (b1 + buff) / 2;
            bufStr.insert(0, rem);
            sim++;
        }
        
        if (buff > 0) {
            bufStr.insert(0, buff);
        }
        
        return bufStr.toString();
    }
}
