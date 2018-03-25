package com.usu.structs.news;

import java.lang.reflect.Array;

@SuppressWarnings("unchecked")
public class Heap<T> {
	public enum HeapType {
		increase,
		decrease
	}
	
	T[] a;
	HeapType heapType;
	int maxLength;
	int nItem = 0;
	
	public Heap(Class<T> c, HeapType type, int max) {
		this.a = (T[]) Array.newInstance(c, max);
		this.heapType = type;
		this.maxLength = max;
	}
	
	public boolean add(T i) {
		// no longer accept new items
		if (nItem == maxLength) return false;
		
		a[nItem++] = i;
		
		if (nItem > 1) {
			// trickle up
			int c = nItem - 1;
			int p = (c - 1) / 2;
			
			while (p >= 0 && compare(i, a[p]) > 0) {
				a[c] = a[p];
				
				// move up
				c = p;
				p = (int) Math.floor(((double) p - 1) / 2);
			}
			
			a[c] = i;
		}
		
		return true;
	}
	
	public T poll() {
		if (nItem == 0) return null;
		
		// move the last item to the root
		T r = a[0];
		
		if (nItem > 1) {
			// trickle down
			a[0] = a[nItem-- - 1];
			T m = a[0];
			
			int c = 0;
			int n = 2 * c + 1;
			
			while (true) {
				// if the right child is available and greater than the left
				if (n + 1 < nItem && compare(a[n], a[n + 1]) < 0) {
					n = n + 1;
				}
	
				if (n + 1 < nItem && compare(m, a[n]) < 0) {
					a[c] = a[n];
					c = n;
					n = 2 * n + 1;
				} else {
					a[c] = m;
					break;
				}
			}
		} else {
			a[0] = null;
			nItem = 0;
		}
		return r;
	}
	
	public T peek() {
		return nItem > 0 ? a[0] : null;
	}
	
	public int size() {
		return this.nItem;
	}
	
	public void display() {
		while (nItem >= 0) {
			System.out.print(poll() + " ");
		}
		System.out.println();
	}
	
	@SuppressWarnings({ "rawtypes" })
	int compare(T a, T b) {
		int d = (this.heapType == HeapType.decrease ? 1 : -1);
		return d * ((Comparable) a).compareTo(b);
	}
}
