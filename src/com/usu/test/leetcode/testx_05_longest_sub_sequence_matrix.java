package com.usu.test.leetcode;

import java.util.Stack;

public class testx_05_longest_sub_sequence_matrix extends Thread {
	public void run() {
		int[][] a = new int[][] { 
				{3, 1, 2, 6}, 
				{2, 2, 3, 1},
				{3, 3, 7, 9}
		};
		
		int res = logestSequence(a);
		
		System.out.println(res);
		
		int[][] a2 = new int[][] { 
			{1, 6, 2}, 
			{8, 3, 7},
			{4, 9, 5}
		};
	
		res = logestSequence(a);
		
		System.out.println(res);
	}
	
	class Item {
		int i;
		int j;
		int val;
		int visit;
		
		public Item(int i, int j, int val) {
			this.i = i;
			this.j = j;
			this.val = val;
			this.visit = -1;
		}
		
		public Item(int i, int j, int val, int visit) {
			this.i = i;
			this.j = j;
			this.val = val;
			this.visit = visit;
		}
	}
	
	Item[][] items;
	int rows = -1; 
	int cols = -1;
	
	
	public int logestSequence(int[][] a) {
		
		int result = -1;
		
		rows = a.length; 
		cols = a[0].length;
		items = new Item[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				items[i][j] = new Item(i, j, a[i][j], -1);
			}
		}
		
		// compute the longest path starting from all items 
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int max = longestFromItem(i, j);
				result = Math.max(max, result);
			}
		}
		
		return result;
	}
	
	private int longestFromItem(int i, int j) {
		Stack<Item> s = new Stack<>();
		
		s.push(items[i][j]);

		int max = -1; 
		
		while (!s.isEmpty()) {
			Item item = s.peek();

			// 1. i - 1, j
	        if (item.i > 0 && Math.abs(item.val - items[item.i - 1][item.j].val) > 3 && items[item.i - 1][item.j].visit == -1) {
				items[item.i - 1][item.j].visit = 1;
				s.push(items[item.i - 1][item.j]);
				continue;
	        }

	        // 2. i - 1, j + 1
	        if (item.i > 0 && item.j < cols - 1 && Math.abs(item.val - items[item.i - 1][item.j + 1].val) > 3 && items[item.i - 1][item.j + 1].visit == -1) {
				items[item.i - 1][item.j + 1].visit = 1;
				s.push(items[item.i - 1][item.j + 1]);
				continue;
			}

	        // 3. i, j + 1
	        if (item.j < cols - 1 && Math.abs(item.val - items[item.i][item.j + 1].val) > 3 && items[item.i][item.j + 1].visit == -1) {
				items[item.i][item.j + 1].visit = 1;
				s.push(items[item.i][item.j + 1]);
				continue;
			}
	        
	        // 4. i + 1, j + 1
	        if (item.i < rows - 1 && item.j < cols - 1 && Math.abs(item.val - items[item.i + 1][item.j + 1].val) > 3 && items[item.i + 1][item.j + 1].visit == -1) {
				items[item.i + 1][item.j + 1].visit = 1;
				s.push(items[item.i + 1][item.j + 1]);
				continue;
			}
	        
	        // 5. i + 1, j
	        if (item.i < rows - 1 && Math.abs(item.val - items[item.i + 1][item.j].val) > 3 && items[item.i + 1][item.j].visit == -1) {
				items[item.i + 1][item.j].visit = 1;
				s.push(items[item.i + 1][item.j]);
				continue;
			}

	        // 6. i + 1, j - 1
	        if (item.i < rows - 1 && item.j > 0 && Math.abs(item.val - items[item.i + 1][item.j - 1].val) > 3 && items[item.i + 1][item.j - 1].visit == -1) {
				items[item.i + 1][item.j - 1].visit = 1;
				s.push(items[item.i + 1][item.j - 1]);
				continue;
			}

	        // 7. i, j - 1
	        if (item.j > 0 && Math.abs(item.val - items[item.i][item.j - 1].val) > 3 && items[item.i][item.j - 1].visit == -1) {
				items[item.i][item.j - 1].visit = 1;
				s.push(items[item.i][item.j - 1]);
				continue;
			}

	        // 8. i - 1, j - 1
	        if (item.i > 0 && item.j > 0 && Math.abs(item.val - items[item.i - 1][item.j - 1].val) > 3 && items[item.i - 1][item.j - 1].visit == -1) {
				items[item.i - 1][item.j - 1].visit = 1;
				s.push(items[item.i - 1][item.j - 1]);
				continue;
			}
	        
	        max = Math.max(max, s.size());
			s.pop();
		}
		
		return max;
	}
	
	public static void main(String args[]) {
		new testx_05_longest_sub_sequence_matrix().start();
	}
}
