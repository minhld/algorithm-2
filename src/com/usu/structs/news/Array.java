package com.usu.structs.news;

public class Array {
	static int[] buff = null;
	
	public static int[] rand(int cap, int max) {
		buff = new int[cap];
		
		for (int i = 0; i < cap; i++) {
			buff[i] = (int) (Math.random() * max);
		}
		
		return buff;
	}
	
	public static void print(int[] b) {
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + (i < b.length - 1 ? " " : ""));
		}
		System.out.println();
	}
	

}
