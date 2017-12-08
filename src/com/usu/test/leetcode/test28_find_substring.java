package com.usu.test.leetcode;

public class test28_find_substring {
	public int strStr(String haystack, String needle) {
        int ih = 0, in = 0;     // iterating indexes of haystack and needle
        int f = -1;             // first similar char
        
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0) return f;
        
        int i = 0;
        while (i < haystack.length()) {
            ih = i++;
            while(ih < haystack.length() && in < needle.length() && haystack.charAt(ih) == needle.charAt(in)) {
                if (f < 0) f = ih;
                ih++;
                in++;
            }
            
            // if the entire needle is matched
            if (in == needle.length()) return f; 
            
            // if the entire needle is not match but we run to the end of the
            // haystack, then we report we couldn't find the needle
            if (ih == haystack.length()) return -1;
            
            // otherwise, we continue the process
            f = -1;             // reset the offset
            in = 0;             // reset the offset of needle index
        }
        return f;
    }
}
