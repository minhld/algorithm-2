package com.usu.test.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class testa_02 extends Thread {
	public void run() {
		List<String> logfile = new ArrayList<>();
		logfile.add("a2 abc def");
		logfile.add("a8 abc       eef");
		logfile.add("f6 abc def a1");
		logfile.add("b1 12 3 5 7");
		logfile.add("b1 3 5 3 5 7");
		logfile.add("e1 sfi sfe");
		logfile.add("d1 ayi eru fhs fs fs");
		
		List<String> res = reorderLines(logfile.size(), logfile);
		
		for (String s : res) {
			System.out.println(s);
		}
		
	}
	
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> reorderLines(int logFileSize, List<String> logfile) 
	{
		List<String> orderList = new ArrayList<>();
		TreeMap<String, TreeMap<String, String>> orderMap = new TreeMap<>();
		
		List<String> numList = new ArrayList<>();
		
		String[] parts;
		String key;
		for (String line : logfile) {
		    // parts[0]: id, parts[1]: word for checking
		    parts = line.split(" ");
		    
		    if (isNum(parts[1])) {
		        // if the line contains only numbers 
		        numList.add(line);
		    } else {
		        // if the line contains only words
    		    // get the key for comparing
		        key = concat(parts); 
		        // key = line.substring(parts[0].length()).trim();
		        
		        TreeMap<String, String> subMap;
		        if (orderMap.containsKey(key)) {
		        	subMap = orderMap.get(key);
		        	subMap.put(parts[0], line);
		        } else {
		        	subMap = new TreeMap<>();
		        	subMap.put(parts[0], line);
		        	orderMap.put(key, subMap);
		        }
		    	
		    }
		}

        // flush the order map to the word list
        String line;
        TreeMap<String, String> subMap;
        for (String id : orderMap.keySet()) {
        	subMap = orderMap.get(id);
        	
        	for (String subId : subMap.keySet()) {
        		line = subMap.get(subId);
        		orderList.add(line);
        	}
        }
		
		// add the number lines
		orderList.addAll(numList);
		
		return orderList;
	}
	
    private String concat(String[] words) {
    	String s = "";
    	for (int i = 1; i < words.length; i++) {
    		s += words[i];
    	}
    	// s += " " + words[0];
    	return s.trim();
    }
    
	private boolean isNum(String word) {
	    try {
	        int num = Integer.parseInt(word);
	        return true;
	    } catch (Exception e) { 
	        return false;
	    }
	}
	
	public static void main(String args[]) {
		new testa_02().start();
	}
}
