package com.usu.structs;

import java.lang.reflect.Array;

@SuppressWarnings("unchecked")
public class Queue<T> {
	T[] array;
	int maxLength = 0;
	int front = -1;
	int rear = 0;
	
	public Queue(Class<T> c, int max) {
		maxLength = max + 2;
		array = (T[]) Array.newInstance(c, maxLength);
	}
	
	public boolean add(T val) {
		// if the queue is full
		if (isFull()) return false;
		
		// front will wrap around if it reaches
		// the max index of the array
		front = (front == maxLength - 1 ? 0 : front + 1);
		array[front] = val;
		return true;
	}
	
	public T poll() {
		// if the queue is empty
		if (isEmpty()) return null;
		
		// wrap around if the rear cursor reaches the max index
		T ret = array[rear];
		rear = (rear == maxLength - 1 ? 0 : rear + 1);
		return ret;
	}
	
	public T peek() {
		return array[rear];
	}
	
	/**
	 * since the positions of front & rear at full state
	 * and empty state are the same, we make the array 2 
	 * items more than the capacity of the queue
	 * 
	 * @return
	 */
	public boolean isFull() {
		return (front + 2 == rear) ||
			   (front + rear == maxLength - 2);		// wrap around
	}
	
	public boolean isEmpty() {
		return (front + 1 == rear) || 
			   (front - rear == maxLength - 1);		// wrap around
	}
	
	public int size() {
		if (rear <= front) return front - rear + 1;
		else return maxLength - (rear - front - 1);	// wrap around
	}
	
	/**
	 * this will flush out the entire stack
	 */
	public static <T> void print(Queue<T> s) {
		while (!s.isEmpty()) {
			T e = s.poll();
			System.out.print(e + " ");
		}
	}
}
