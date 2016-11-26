package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hydra on 2016/11/26.
 */

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<HashMap<Integer, String>> mapList = new ArrayList<>();

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; ++i) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if(map.containsKey(sortedString)) {
                map.get(sortedString).add(strs[i]);
            } else {
                ArrayList<String> tempList = new ArrayList<>();
                tempList.add(strs[i]);
                map.put(sortedString, tempList);
            }

        }

        List<List<String>> returnValue = new ArrayList<>();
        returnValue.addAll(map.values());


        return returnValue;
    }
}
