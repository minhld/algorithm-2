package com.usu.test.interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class testa_01 extends Thread {
	public void run() {
		
	}
	
	List<String> retrieve(String literatureText, List<String> wordsToExclude) {
		List<String> mfList = new ArrayList<>();
        
        // store the word and its number of apperance
        HashMap<String, Integer> mfWords = new HashMap<>();
        
        // save the excluded words to the set
        HashSet<String> excludeWords = new HashSet<>();
        for (String w : wordsToExclude) {
            excludeWords.add(w);
        }
        
        int max = 0;
        
        String[] words = literatureText.split(" ");
        for (String word : words) {
            if (!excludeWords.contains(word)) {
                int count = 0;
                if (mfWords.containsKey(word)) {
                    count = mfWords.get(word);
                }
                
                mfWords.put(word, count + 1);
                
                // find the max frequency
                max = Math.max(max, count + 1);
            }
        }
        
        // collect the words that used the most
        for (String key : mfWords.keySet()) {
            if (mfWords.get(key) == max) {
                mfList.add(key);
            }
        }
        
        return mfList;
	}
	
	public static void main(String args[]) {
		new testa_01().start();
	}
}
