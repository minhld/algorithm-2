package com.usu.test.leetcode;

import java.util.HashSet;

public class test575_distributecandies {
	public int distributeCandies(int[] candies) {
        int maxCount = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < candies.length; i++) {
            if (!set.contains(candies[i])) {
                maxCount++;
                set.add(candies[i]);
            } 
        }
        
        return maxCount < candies.length / 2 ? maxCount : candies.length / 2;
    }
}
