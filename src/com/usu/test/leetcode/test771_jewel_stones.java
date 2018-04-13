package com.usu.test.leetcode;

import java.util.HashSet;

public class test771_jewel_stones {
	public int numJewelsInStones(String J, String S) {
        HashSet<Character> jSet = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            jSet.add(new Character(J.charAt(i)));
        }
        
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            Character c = new Character(S.charAt(i));
            if (jSet.contains(c)) count++;
        }
        return count;
    }
}
