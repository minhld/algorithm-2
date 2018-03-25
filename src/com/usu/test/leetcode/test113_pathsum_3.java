package com.usu.test.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.usu.structs.news.TreeNode;

public class test113_pathsum_3 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        List<String> strList = getSums(root, "", 0);
        
        for (String s : strList) {
            String[] subs = s.split(",");
            int subSum = 0;
            for (String num : subs) {
                if (num.equals("")) continue;
                subSum += Integer.parseInt(num);
            }
            
            System.out.println(subSum);
            
            if (subSum == sum) {
                List<Integer> subList = new ArrayList<>();
                for (String num : subs) {
                    if (num.equals("")) continue;
                    subList.add(Integer.parseInt(num));
                }
                list.add(subList);
            }
        }
       
        return list;
    }
    
    List<String> getSums(TreeNode n, String subList, int sum) {
        List<String> list = new ArrayList<>();
            
        if (n == null) {
            // empty node - return empty list
            return list;
        }
        
        if (n != null && n.left == null && n.right == null) {
            // leaf node
            sum += n.val;
            subList += "," + n.val;
            
            System.out.println(sum + ": " + subList);
            
            list.add(subList);
            return list;
        }
        
        // else
        List<String> subLeftList = new ArrayList<>();
        List<String> subRightList = new ArrayList<>();
        
        subList += "," + n.val;
        
        if (n.left != null) {
            subLeftList = getSums(n.left, subList, sum + n.val);
        }
        
        if (n.right != null) {
            subRightList = getSums(n.right, subList, sum + n.val);
        }
        
        list.addAll(subLeftList);
        list.addAll(subRightList);
        
        return list;
    }
}
