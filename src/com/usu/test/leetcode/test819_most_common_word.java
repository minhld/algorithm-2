package com.usu.test.leetcode;

import java.util.HashSet;

import com.usu.structs.HashMap;

public class test819_most_common_word {
	public String mostCommonWord(String paragraph, String[] banned) {
        // add banned to the set
        HashSet<String> bannedSet = new HashSet<>();
        for (int i = 0; i < banned.length; i++) bannedSet.add(banned[i]);
        
        String[] words = paragraph.replaceAll("[^\\w\\s]","").
                                   toLowerCase().
                                   split(" ");
                
        int maxWord = 0;
        String maxWordStr = "";
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (bannedSet.contains(words[i])) continue;
            
            if (wordMap.containsKey(words[i])) {
                int count = wordMap.get(words[i]);
                wordMap.put(words[i], count + 1);
                
                if (maxWord < count + 1) {
                    maxWord = count + 1;
                    maxWordStr = words[i];
                }
            } else {
                wordMap.put(words[i], 1);
                if (maxWord < 1) {
                    maxWord = 1;
                    maxWordStr = words[i];
                }
            }
        }
        
        return maxWordStr;
    }
}
