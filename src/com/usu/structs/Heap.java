package com.usu.structs;

import java.lang.reflect.Array;

/**
 * Heap is a binary tree
 * - it is complete. This means it is completely filled in, reading from left to right
 * across each row, although the last row need not be full.
 * - it is (usually) implemented as an array rather than using references to
 * connect the nodes.
 * - each node in a heap satisfies the heap condition, which states that every node�s
 * key is larger than (or equal to) the keys of its children
 * 
 * in Java, we can use PriorityQueue instead of Heap 
 * 
 * @author minhld
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class Heap<T> {
	T[] a;
	int maxLength;
	int nItems;
	
	public Heap(Class<T> c, int max) {
		maxLength = max;
		a = (T[]) Array.newInstance(c, maxLength);
	}
	
	
	/**
	 * parent of n will be (n - 1)/2
	 * 
	 * @param i adding item
	 * @return
	 */
	public boolean add(T i) {
		// array is full
		if (nItems == maxLength) return false;
		
		a[nItems++] = i;
		
		if (nItems > 1) {
			int c = nItems - 1;
			int p = (c - 1) / 2;	// its parent node
			
			// compare child with its parent to decide 
			// whether to move up one level up
			while (p >= 0 && compare(i, a[p]) > 0) {
				a[c] = a[p];
				c = p;
				p = (int) Math.floor(((double) p - 1) / 2);
			}
			a[c] = i;
		}
		
		return true;
	}
	
	/**
	 * children of item n will be (2n + 1) and (2n + 2)
	 * 
	 * @return
	 */
	public T poll() {
		if (nItems == 0) return null;
		T v = a[0];
		
		if (nItems > 1) {
			a[0] = a[nItems-- - 1];
			T r = a[0];
			
			int p = 0;
			int c = (2 * p + 1);
			
			while (true) {
				if (c + 1 < nItems && compare(a[c], a[c + 1]) < 0) {
					// if right child is larger
					c = c + 1;
				}
		
				// check the values of parent and child
				if (c + 1 < nItems && compare(r, a[c]) < 0) {
					a[p] = a[c];		// switch one level up
					p = c;
					c = (2 * c + 1);	// move to its child
				} else {
					a[p] = r;
					break;				// stop here
				}
			}
		} else {
			// only one item
			// a[0] = null;
			nItems = 0;
		}
		
		return v;
	}
	
	public T peek() {
		return nItems > 0 ? a[0] : null;
	}
	
	public int size() {
		return nItems;
	}
	
	public void display() {
		while (nItems >= 0) {
			System.out.print(poll() + " ");
			nItems--;
		}
	}
	
	@SuppressWarnings({ "rawtypes" })
	private int compare(T i1, T i2) {
		return ((Comparable) i1).compareTo(i2);
	}
}
