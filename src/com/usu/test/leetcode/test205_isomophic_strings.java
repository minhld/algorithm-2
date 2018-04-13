package com.usu.test.leetcode;

import com.usu.structs.HashMap;

public class test205_isomophic_strings {
	public boolean isIsomorphic(String s, String t) {
        return isIsomorphic1Direction(s, t) && isIsomorphic1Direction(t, s);
    }
    
    boolean isIsomorphic1Direction(String s, String t) {
        HashMap<Character, Character> hash = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            Character c = Character.valueOf(s.charAt(i));
            if (!hash.containsKey(c)) {
                hash.put(c, Character.valueOf(t.charAt(i)));
            } else {
                if (hash.get(c) != t.charAt(i)) return false; 
            }
        }
        
        return true;
    }
}
