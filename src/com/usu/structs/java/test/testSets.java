package com.usu.structs.java.test;

/**
 * test Set Interface: HashSet, TreeSet and LinkedHashSet
 *  - HashSet: 
 *  	- add, remove, contains, get: constant
 *  	- no order
 *  	- iteration depends on initial capacity and load factor
 *  
 *  - TreeSet
 *  	- add, remove, contains: O(logn)
 *  	- warranty order
 *  	- iteration performance is not tuned 
 *  
 * @author Minh Le
 *
 */
public class testSets extends Thread {
	public void run() {
		testHashSet();
	}
	
	private void testHashSet() {
		
	}
	
	public static void main(String args[]) {
		new testSets().start();
	}
}
