package com.usu.test.ctci;

import java.util.ArrayList;
import java.util.List;

public class test76_jigsaw {
	
	public class Jigsaw {
		Piece[][] pieces;
		List<Piece> unsolvedList = new ArrayList<>();
		
		public Jigsaw(int rows, int cols) {
			pieces = new Piece[rows][cols];
		}
		
		public void solvePuzzle() {
			
		}
		
		public void addPiece(Piece p) {
			
		}
		
		public boolean fitsWith(Piece p1, Piece p2) {
			Edge[] ep1 = p1.getEdges();
			Edge[] ep2 = p2.getEdges();
			
			for (Edge e1 : ep1) {
				for (Edge e2 : ep2) {
					if (e1.type != EdgeType.Flat && 
							e2.type != EdgeType.Flat &&  
							fitsWith(e1, e2)) {
						return true;
					}
				}
			}
			return false;
		}
		
		public boolean fitsWith(Edge e1, Edge e2) {
			return false;
		}
	}
	
	/**
	 * - North: e0
	 * - East: e1
 	 * - South: e2
 	 * - West: e3
	 * 
	 * @author minhle
	 *
	 */
	public class Piece {
		Edge[] edges = new Edge[4];
		
		public Edge[] getEdges() {
			return edges;
		}
		
		public Edge[] getEdges(EdgeType type) {
			List<Edge> typedEdges = new ArrayList<>();
			for (Edge e : edges) {
				if (e.type == type) {
					typedEdges.add(e);
				}
			}
			return typedEdges.toArray(new Edge[] { });
		}
	}
	
	public enum EdgeType {
		Flat, 
		Inner,
		Outer
	}
	
	public class Edge {
		public EdgeType type;
	}
	
	
}
