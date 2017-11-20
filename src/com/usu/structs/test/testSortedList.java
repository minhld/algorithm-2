package com.usu.structs.test;

import com.usu.structs.Array;
import com.usu.structs.Link;
import com.usu.structs.SortedList;
import com.usu.test.utils.Utils;

public class testSortedList extends Thread {
	public void run() {
		testSortedList1();
	}
	
	public void testSortedList1() {
		long[] a = Utils.createArray(10, 100);
		Array.print(a);
		
		SortedList<Long> slist = new SortedList<Long>();
		for (int i = 0; i < a.length; i++) {
			slist.add(a[i]);
		}
		slist.display();
		
		
//		for (int i = 0; i < a.length + 5; i++) {
//			llist.removeFirst();
//		}
		
		
		long key = Utils.openInput();
		Link<Long> f = slist.find(key);
		Link<Long> d = slist.delete(key);
		
		System.out.println(f != null ? "find value: " + f.data : "not found");
		System.out.println(d != null ? "deleted: " + d.data : "not found");
		
		slist.display();
	}
	
	public static void main(String args[]) {
		new testSortedList().start();
	}
}
