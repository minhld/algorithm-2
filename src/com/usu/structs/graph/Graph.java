package com.usu.structs.graph;

import com.usu.structs.HashMap;
import com.usu.structs.LinkQueue;
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
	int adjMat[][];
	int nVerts;
	
	LinkStack<Integer> stack;
	LinkQueue<Integer> queue;
	
	public Graph() {
		vIndexMap = new HashMap<>();
		stack = new LinkStack<>();
		queue = new LinkQueue<>();
		
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
			v = stack.peek();
			
			// find the adjunct vertex
			n = -1;
			for (int i = 0; i < nVerts; i++) {
				if (adjMat[v][i] == 1 && !vertexList[i].isVisited) {
					n = i;
					break;
				}
			}
			
			if (n >= 0) {
				vertexList[n].isVisited = true;
				displayVertex(n);
				stack.push(n);
				// System.out.print(n + " ");
			} else {
				stack.pop();
				if (stack.size() == 1) {
					System.out.println();
					displayVertex(0);
				} 
			}
		}
	}
	
	/**
	 * breadth-first search
	 */
	public void bfs() {
		// start with the first item
		vertexList[0].isVisited = true;
		queue.add(0);

		// current and next adjunct vertices
		int v, n = 1;
		while (!queue.isEmpty()) {
			n = queue.size();
			
			while (--n >= 0) {
				v = queue.poll();
				displayVertex(v);
				
				// find all adjunct vertices from the current one
				for (int i = 0; i < nVerts; i++) {
					if (adjMat[v][i] == 1 && !vertexList[i].isVisited) {
						vertexList[i].isVisited = true;
						queue.add(i);
					}
				}
			}
			System.out.println();
		}
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
		System.out.print(vertexList[v].label + " ");
	}
}
