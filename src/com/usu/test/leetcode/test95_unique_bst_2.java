package com.usu.test.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.usu.structs.news.TreeNode;

public class test95_unique_bst_2 extends Thread {
	public void run() {
		long s = System.currentTimeMillis();
		List<TreeNode> list = generateTrees(3);
		System.out.println("num: " + list.size() + " in " + (System.currentTimeMillis() - s) + "ms");
	}
	
	public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        
        if (n == 0) {
            return list;
        }
        
        if (n == 1) {
            list.add(new TreeNode(1));
            return list;
        }
        
        // n >= 2
        List<TreeNode> subList = generateTrees(n - 1);
        
        TreeNode p, c;
        for (TreeNode r : subList) {
            // travel down the tree
        		p = null;
            c = r;
            while (true) {
            		TreeNode nn = createTree(r);
            		TreeNode ret = travelTree(nn, p, c, n);
            		
            		list.add(ret);
            		
            		if (c != null) {
            			p = c;
	            		c = c.right;
            		} else {
            			break;
            		}
            }
        }
        
        return list;
    }
    
	TreeNode travelTree(TreeNode r, TreeNode p, TreeNode i, int val) {
		if (r == null) return null;
		
		if (p == null) {
			TreeNode n = new TreeNode(val);
			n.left = r;
			return n;
		}
		
		p = r;
		if (i == null) {
			while (p.right != null) {
				p = p.right;
			}
			p.right = new TreeNode(val);
			return r;
		}
		
		travelTree(r, r, i.val, val);
		
		return r;
	}
	
	void travelTree(TreeNode r, TreeNode p, int i, int val) {
		if (r == null) return;
		
		if (r.val == i) {
			p.right = new TreeNode(val);
            p.right.left = r;
		} else {
			travelTree(r.left, r, i, val);
			travelTree(r.right, r, i, val);
		}
	}
	
	TreeNode createTree(TreeNode r) {
		if (r == null) return null;
		
		TreeNode n = new TreeNode(r.val);
		n.left = createTree(r.left);
		n.right = createTree(r.right);
		
		return n;
	}
    
	public static void main(String args[]) {
		new test95_unique_bst_2().start();
	}
}
