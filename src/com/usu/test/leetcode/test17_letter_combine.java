package com.usu.test.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.usu.structs.HashMap;

public class test17_letter_combine extends Thread {
	public void run() {
		String digits = "23";
		List<String> output = letterCombinations(digits);
	}
	
	public static void main(String args[]) {
		new test17_letter_combine().start();
	}
	
	HashMap<Character, char[]> map = new HashMap<>();
    
    public List<String> letterCombinations(String digits) {
        map.put('0', new char[] { ' ' });
        map.put('1', new char[] { ' ' });
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v' });
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });
        
        List<String> output = subCombination(digits);
        
        return output;
        
    }
    
    public List<String> subCombination(String digits) {
        List<String> output = new ArrayList<>();
        char[] cList;
        
        if (digits.length() == 0) {
            return output;
        } else if (digits.length() == 1) {
            cList = map.get(digits.charAt(0));
            for (int i = 0; i < cList.length; i++) {
                output.add(String.valueOf(cList[i]));
            }
            return output;
        }
        
        String subDigits = digits.substring(1);
        List<String> sub1List = subCombination(digits.substring(0, 1));
        List<String> subList = subCombination(subDigits);
        
        for (String str1 : sub1List) {
            for (String str : subList) {
                output.add(str1 + str);
            }
        }
        return output;
    }
}
