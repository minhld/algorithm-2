package com.usu.structs.graph;

import com.usu.structs.HashMap;
import com.usu.structs.LinkStack;

/**
 * store edges in a square matrix
 * 
 * @author lee
 *
 */
public class Graph {
	final int MAX_VERTS = 20;
	Vertex[] vertexList;
	HashMap<String, Integer> vIndexMap;
	LinkStack<Integer> stack;
	int adjMat[][];
	int nVerts;
	
	public Graph() {
		vIndexMap = new HashMap<>();
		stack = new LinkStack<>();
		 
		// setup everything to zero
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		vertexList = new Vertex[MAX_VERTS];
		nVerts = 0;
		
		for(int i = 0; i < MAX_VERTS; i++) {
			for(int j = 0; j < MAX_VERTS; j++) {
				adjMat[i][j] = 0;
			}
		}
	}
	
	/**
	 * depth-first search algorithm
	 */
	public void dfs() {
		// start with the first item
		vertexList[0].isVisited = true;
		displayVertex(0);
		stack.push(0);
		
		// current and next adjunct vertices
		int v, n;
		while (!stack.isEmpty()) {
			v = stack.pop();
			n = getUnvisitedVertex(v);
			if (n >= 0) {
				vertexList[n].isVisited = true;
				displayVertex(n);
				stack.push(n);
				System.out.print(n);
			} 
		}
	}
	
	public int getUnvisitedVertex(int v) {
		for (int i = 0; i < nVerts; i++) {
			if (adjMat[v][i] == 1 && !vertexList[i].isVisited) {
				return i;
			}
		}
		// not found
		return -1;
	}
	
	public void addVertex(String label) {
		vertexList[nVerts] = new Vertex(label);
		vIndexMap.put(label, nVerts++);
	}
	
	public void addEdge(String v1, String v2) {
		int start = vIndexMap.get(v1);
		int end = vIndexMap.get(v2);
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}
}
