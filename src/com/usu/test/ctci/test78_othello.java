package com.usu.test.ctci;

import java.util.EnumMap;
import java.util.HashSet;

public class test78_othello {
	
	public class Othello {
		Piece[][] pieces;
		int blackNum = 0, whiteNum = 0;
		EnumMap<PieceColor, HashSet<Piece>> setPieceList; 
		
		public Othello(int size) {
			pieces = new Piece[size][size];
			setPieceList = new EnumMap<>(PieceColor.class); 
		}
		
		public void placePiece(int x, int y, PieceColor c) {
			pieces[x][y] = new Piece(x, y, c);
			if (c == PieceColor.Black) blackNum++;
			if (c == PieceColor.White) whiteNum++;
			
			// check with 4 surrounding pieces
			// (x, y - 1), (x + 1, y), (x, y + 1) and (x - 1, y)  
			if (isPieceSurrounded(x, y - 1)) {
				flipColor(x, y - 1);
			}
			
			if (isPieceSurrounded(x + 1, y)) {
				flipColor(x + 1, y);
			}
			
			if (isPieceSurrounded(x, y + 1)) {
				flipColor(x, y + 1);
			}
			
			if (isPieceSurrounded(x - 1, y)) {
				flipColor(x - 1, y);
			}
		}
		
		public PieceColor winnerIs() {
			return blackNum > whiteNum ? PieceColor.Black : PieceColor.White;
		}
		
		public void flipColor(int x, int y) {
			Piece p = pieces[x][y];
			if (p.color == PieceColor.Black) {
				p.color = PieceColor.White;
				blackNum--;
				whiteNum++;
			} else {
				p.color = PieceColor.Black;
				blackNum++;
				whiteNum--;
			}
		}
		
		public boolean isPieceSurrounded(int x, int y) {
			Piece p = pieces[x][y];
			return p != null;
		}
		
		public boolean isGameEnd() {
			return blackNum + whiteNum >= pieces.length * pieces.length;
		}
	}
	
	public enum PieceColor {
		Black,
		White
	}
	
	public class Piece {
		int x;
		int y;
		public PieceColor color;
		
		public Piece(int _x, int _y, PieceColor c) {
			x = _x;
			y = _y;
			color = c;
		}
	}
}
