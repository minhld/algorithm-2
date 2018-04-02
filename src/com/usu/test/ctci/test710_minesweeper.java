package com.usu.test.ctci;

public class test710_minesweeper {
	public class Board {
		Cell[][] cells;
		
		public Board (int rows, int cols) {
			cells = new Cell[rows][cols];
		}

	
		public boolean uncover(int row, int col) { 
			if (cells[row][col].isBomb) {
				return false;
			} else if (!cells[row][col].isBomb && cells[row][col].val == 0) {
				// empty cells - uncover all adjacent cells
				expose(row, col);
				return true;
			} else if (!cells[row][col].isBomb && cells[row][col].val > 0) {
				// numeric cell
				cells[row][col].isExposed = true;
				return true;
			}
			return true;
		}

		public void expose(int row, int col) {
			cells[row][col].flip();
			cells[row][col].isExposed = true;
			
			if (cells[row][col].val > 0) return;
			
			if (cells[row][col].val == 0) {
				uncover(row - 1, col);
				uncover(row - 1, col + 1);
				uncover(row, col + 1);
				uncover(row + 1, col + 1);
				uncover(row + 1, col);
				uncover(row + 1, col - 1);
				uncover(row, col - 1);
				uncover(row - 1, col - 1);
			} 
		}
		
		public void init() { 
			// shuffle the cells
			
		}
	}
	
	public class Cell {
		int row;
		int col;
		boolean isBomb;
		int val;
		boolean isExposed;
		boolean isGuessed;
		
		public Cell(int r, int c, boolean _isBomb, int _val) {
			row = r;
			col = c;
			isBomb = _isBomb;
			val = _val;
			isExposed = false;
			isGuessed = false;
		}
		
		public void flip() { }
	}
}
