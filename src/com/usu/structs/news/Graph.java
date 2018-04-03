package com.usu.structs.news;

import java.util.Arrays;

import com.usu.structs.Stack;
import com.usu.structs.HashMap;

/**
 * new implementation of Graph
 * 
 * @author Minh Le
 *
 */
public class Graph {
	// adjacent matrix
	int[][] adjMax;
	Vertex[] vertexList;
	// store the vertex's label & index 
	HashMap<String, Integer> vIndexMap;
	int nVerts;

	public Graph(int size) {
		adjMax = new int[size][size];
		vertexList = new Vertex[size];
		vIndexMap = new HashMap<>();
		nVerts = 0;
		
		// fill the matrix with 0
		for (int i = 0; i < adjMax.length; i++) {
			Arrays.fill(adjMax[i], 0);
		}
		
	}
	
	public void addVertex(String label) {
		vertexList[nVerts++] = new Vertex(label);
		vIndexMap.put(label, nVerts);
	}
	
	public void addEdge(String vLabel1, String vLabel2) {
		int vIndex1 = vIndexMap.get(vLabel1);
		int vIndex2 = vIndexMap.get(vLabel2);
		adjMax[vIndex1][vIndex2] = 1;
		adjMax[vIndex2][vIndex1] = 1;
	}
	
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label + " ");
	}
	
	/**
	 * perform Depth-First Search
	 */
	public void dfs() {
		// start with the first item
		vertexList[0].isVisited = true;
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		
		while (!stack.isEmpty()) {
			int c = stack.peek();

			int adjIndex = -1;
			for (int i = 0; i < vertexList.length; i++) {
				if (adjMax[c][i] == 1 && !vertexList[i].isVisited) {
					adjIndex = i;
					break;
				}
			}
			
			if (adjIndex >= 0) {
				vertexList[adjIndex].isVisited = true;
				displayVertex(adjIndex);
				stack.push(adjIndex);
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
	 * perform Breath-First Search
	 */
	public void bfs() {
		
	}
}
