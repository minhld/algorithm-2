package com.usu.test.leetcode;

import java.util.ArrayList;
import java.util.List;

public class test60_permutation_sequence extends Thread {
	public void run() {
		String res = getPermutation(4, 15);
		System.out.println(res);
	}
	
	public String getPermutation(int n, int k) {
        // hold a list that gives number to the permutations
        List<Integer> sub = new ArrayList<>();
        
        int[] facts = new int[n + 1];
        facts[0] = 1;
        for (int i = 1; i <= n; i++) {
            sub.add(i);
            facts[i] = facts[i - 1] * i;
        }
        
        // to start with index 0
        k--;
        String res = "";
        int i = n;
        
        while (i >= 1) {
            // find the next item to put at front
            res += sub.remove(k / facts[i - 1]);
            k = k % facts[i-- - 1];
        }
        
        return res;
    }

	/**
	 * the below solution use DFS
	 */
	
	int kth = 1;
    
    public String getPermutation2(int n, int k) {
        String[] nums = new String[n];
        
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.toString(i + 1);
        }
        
        return permute(nums, "", 0, k);
    }
    
    private String permute(String[] nums, String cur, int idx, int k) {
        if (idx == nums.length - 1) {
            if (kth < k) {
                kth++;
                return null;
            } else {
                for (int i = 0; i < nums.length; i++) {
                    if (cur.indexOf(nums[i]) < 0) {
                        cur += nums[i];
                        break;
                    }
                }
                return cur;
            }
        }
        
        String locCur, finalStr = "";
        
        // search for item that did not exist in the array
        for (int i = 0; i < nums.length; i++) {
            if (cur.indexOf(nums[i]) < 0) {
                locCur = new String(cur);
                locCur += nums[i];
                finalStr = permute(nums, locCur, idx + 1, k);
                
                if (finalStr != null) break;
            }
            
        }
        
        return finalStr;
    }
	
	public static void main(String args[]) {
		new test60_permutation_sequence().start();
	}
}
