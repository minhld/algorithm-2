package com.usu.structs.news;

import java.util.Arrays;

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
		vertexList[nVerts] = new Vertex(label);
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
		
	}
	
	/**
	 * perform Breath-First Search
	 */
	public void bfs() {
		
	}
}
