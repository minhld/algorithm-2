package com.usu.structs.graph;

public class Vertex {
	public String label;
	public boolean isVisited;
	
	public Vertex(String l) {
		label = l;
		isVisited = false;
	}
}
