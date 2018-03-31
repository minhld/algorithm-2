package com.usu.test.leetcode;

public class test371_sum_2_ints extends Thread {
	public void run() {
		int a = 3, b = 13;
		System.out.println(getSum(a, b));
	}
	
	/**
	 * on-going
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int getSum(int a, int b) {
        String aS = Integer.toBinaryString(a);
        String bS = Integer.toBinaryString(b);
        
        int idx = 0;
        while (true) {
        	int aIdx = aS.length() - idx - 1;
        	int bIdx = bS.length() - idx - 1;
        	
        	if (idx == 2) break; 
        	
        	idx++;
        }
        
        
        System.out.println("a bin: " + aS + ", b bin: " + bS);
        
        System.out.println("a: " + Integer.parseInt(aS, 2) + ", b: " + Integer.parseInt(bS, 2));
        
        return 0;
    }
	
	public static void main(String args[]) {
		new test371_sum_2_ints().start();
	}
}
