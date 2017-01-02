package com.leetcode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by hydra on 2017/1/2.
 */

public class SubstringConcatenationAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        Hashtable<String, Integer> table = new Hashtable<>();

        for(String ss : words) {
            if(table.containsKey(ss)) {
                table.put(ss, table.get(ss)+1);
            } else {
                table.put(ss, 1);
            }
        }

        final int wordLength = words[0].length();

        ArrayList<Integer> returnValue = new ArrayList<>();

        for(int i = 0 ; i < s.length() ; ++i) {
            Hashtable<String, Integer> copyTable = new Hashtable<>(table);
            int index = i ;

            while (!copyTable.isEmpty()) {
                String sub = s.substring(index,wordLength+index > s.length() ? s.length() : wordLength+index);
                index+= wordLength;
                Integer value = copyTable.get(sub);
                if(value != null && value > 0) {
                    if(value == 1) {
                        copyTable.remove(sub);
                    } else {
                        copyTable.put(sub, value - 1);
                    }
                } else {
                    break;
                }
            }

            if(copyTable.isEmpty()) {
                returnValue.add(i);
            }
        }

        return returnValue;
    }
}
