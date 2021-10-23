package com.zdh.home.algorithm.week02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SubdomainVisits {

    public static void main(String[] args) {
        String[] a = new String[]{"9001 discuss.leetcode.com"};
        List<String> list = subdomainVisits(a);
        System.out.println(list.toString());
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split("\\s+");
            Integer count = Integer.valueOf(split[0]);
            String[] split1 = split[1].split("\\.");
            String name = "";
            for (int i = split1.length - 1; i >= 0; i--) {
                if (name == "") {
                    name = split1[i];
                } else {
                    name = split1[i] + "." + name;
                }
                stringIntegerHashMap.put(name, stringIntegerHashMap.getOrDefault(name, 0) + count);
            }
        }
        List<String> ans = new ArrayList();
        for (String s : stringIntegerHashMap.keySet()) {
            ans.add(stringIntegerHashMap.get(s) + " " + s);
        }


        return ans;


    }
}