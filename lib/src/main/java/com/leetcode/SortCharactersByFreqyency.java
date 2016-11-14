package com.leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by hydra on 2016/11/13.
 */

public class SortCharactersByFreqyency {
    public String frequencySort(String s) {
        LinkedHashMap<Character, Integer> scbfMap = new LinkedHashMap<>();
        for(Character c : s.toCharArray()) {
            insertHashMapSafely(scbfMap, c);
        }

        Map<Character, Integer> sortMap = sortByComparator(scbfMap);

        StringBuilder builder = new StringBuilder();
        for(Character c : sortMap.keySet()) {
            for(int i = 0 ; i < sortMap.get(c) ; ++i) {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    private void insertHashMapSafely(LinkedHashMap<Character, Integer> map, Character c) {
        if(map.containsKey(c)) {
            map.put(c, map.get(c)+1);
        } else {
            map.put(c, 1);
        }
    }

    public Map<Character, Integer> sortByComparator(Map<Character, Integer> unsortMap){
        List<Map.Entry<Character, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>(){
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2){
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<Character, Integer> entry : list)
            sortedMap.put(entry.getKey(), entry.getValue());

        return sortedMap;
    }
}
