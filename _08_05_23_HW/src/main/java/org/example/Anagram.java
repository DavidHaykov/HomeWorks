package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.BiFunction;

public class Anagram
{
public static boolean isAnagram(String word, String string) {
	if (word == null || string == null) {
		return false;
	}

	word = word.toLowerCase();
	string = string.toLowerCase();

	Map<Character, Integer> map = new HashMap<>();
	for(char c : word.toCharArray()){
		map.merge(c, 1, Integer::sum);
	}
	for(char c : string.toCharArray()){
		if(!map.containsKey(c)){
			return false;
		}
		int count = map.get(c);
		if(count == 1){
			map.remove(c);
		} else{
			map.put(c, count-1);
		}
	}


	return true;
}


}
