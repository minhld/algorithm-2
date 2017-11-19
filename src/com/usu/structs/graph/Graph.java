package com.usu.structs.graph;

/**
 * store edges in a square matrix
 * 
 * @author lee
 *
 */
public class Graph {
	final int MAX_VERTS = 20;
	Vertex[] vertexList;
	int adjMat[][];
	int nVerts;
	
	public Graph() {
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
	
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}
}
