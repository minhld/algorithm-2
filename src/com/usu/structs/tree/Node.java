package com.usu.structs.tree;

public class Node<T> {
	public int key;
	public T data;
	public Node<T> left;
	public Node<T> right;
	
	public Node(int key, T data) {
		this.key = key;
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "{key: " + key + ", data: " + data.toString() + "}";
	}
}
