package com.revature;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MostRepeatedWord {
	
	public static void main(String[] args) {
		
		
		mostRepeatedWord("Hello world i love you Hello Hello world hello");
	}

	
	public static void mostRepeatedWord(String str) {
		
		Map<String, Integer> m = new HashMap<>();
		
		
		String[] arrStr = str.split(" ");
		
		//Arrays.sort(arrStr);
		
		System.out.println(Arrays.toString(arrStr));
		
		
		
		for(String a : arrStr) {
			int i;
			
			
			
			if(!m.containsKey(a.toLowerCase())) {
				
				m.put(a.toLowerCase(), 1);
			}
			else {
				i = m.get(a);
				m.put(a, ++i);
			}
		}
		
		System.out.println(m);
		
		Set<String> keySet = m.keySet();
		
		int max = 0;
		String wordMax = "";
		
		for (String key : keySet) {
			
			Integer value = m.get(key);
			
			System.out.println(key + " : " + value);
			
			if(value > max) {
				max = value;
				wordMax = key;
			}
		}
		
		System.out.println(wordMax + " is the most words: " + max);
		
	}
}
