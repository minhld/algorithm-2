package com.usu.test.chapter1;

import com.usu.structs.Array;

public class test0 {
	static long[] uSack;
	
	private static boolean select(long[] sacks, int start, int val) {
		if (val == 0) return true;
		if (val < sacks[sacks.length - 1]) {
			return false;
		} else {
			int retVal = (int) Math.floor(val / sacks[start]);
			for (int i = retVal; i >= 0; i--) {
				uSack[start] = i;
				int remVal = val - retVal * (int) sacks[start]; 
				if (select(sacks, start + 1, remVal)) {
					Array.print(uSack);
				}
			}
		}
		return false;
	}
	
	public static void main(String args[]) {
		// 11, 8, 7, 6, and 5
		long[] sacks = new long[] { 11, 8, 7, 6, 5 };
		uSack = new long[sacks.length];
		
		select(sacks, 0, 20);
		
		// Array.print(uSack);
	}
}
