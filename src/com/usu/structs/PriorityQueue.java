package com.usu.structs;

/**
 * items are sorted in the queue when added
 * provide functions: add, poll, peek etc. ->
 * same functions as queue
 * 
 * @author minhle
 *
 */
public class PriorityQueue<T> extends Queue<T> {

	public PriorityQueue(Class<T> c, int max) {
		super(c, max);
	}

	/**
	 * 
	 */
	public boolean add(T i) {
		// if queue is full, just return false
		if (isFull()) return false;

		// skip if the first item
		if (isEmpty()) {
			front = (front == maxLength - 1 ? 0 : front + 1);
			array[front] = i;
			return true;
		}

		front = (front == maxLength - 1 ? 0 : front + 1);
		int swap = (front == 0 ? maxLength - 1 : front - 1);	
		int nSwap = front;
		while (compare(array[swap], i) < 0) {
			// move the smaller to right
			array[nSwap] = array[swap];
			
			// update indexes of the comparing items
			swap = (swap == 0 ? maxLength - 1 : swap - 1);
			nSwap = (nSwap == 0 ? maxLength - 1 : nSwap - 1);
			
			// if the evaluating item is at the rear position
			// it should be stop
			if (nSwap == rear) break;			
		}
		
		// find the right position and insert into this position
		array[nSwap] = i;
		return true;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private int compare(T i1, T i2) {
		return ((Comparable) i1).compareTo(i2);
	}
}
