package com.usu.structs.test;

import com.usu.structs.graph.Graph;

public class testGraph extends Thread {
	public void run() {
		Graph g = new Graph();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");
		g.addVertex("H");
		g.addVertex("I");
		g.addEdge("A", "B");
		g.addEdge("B", "F");
		g.addEdge("F", "H");
		g.addEdge("A", "C");
		g.addEdge("A", "D");
		g.addEdge("D", "G");
		g.addEdge("G", "I");
		g.addEdge("A", "E");
		
		//g.dfs();
		
		g.bfs();
	}
	
	public static void main(String args[]) {
		new testGraph().start();
	}
}
