package com.company.leetcode.problems;

import java.util.*;

public class CountSubDomains {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        for (String str : cpdomains) {
            int index = str.indexOf(' ');
            Integer count = Integer.valueOf(str.substring(0,index));
            str = str.substring(index + 1);
            checkDomain(map,str,count);
        }
        Set<String> keySet = map.keySet();
        List<String> result = new ArrayList<String>();
        for (String key : keySet) {
            Integer count = map.get(key);
            result.add(count.toString() + " " + key);
        }
        return result;

    }

    public void checkDomain(Map<String,Integer> map,String domain,Integer count) {
        int index = domain.indexOf('.');
        if (map.containsKey(domain) == false) {
            map.put(domain,count);
        } else {
            Integer oldCount = map.get(domain);
            map.put(domain,oldCount + count);
        }
        if (index == -1) return;
        domain = domain.substring(index + 1);
        checkDomain(map,domain,count);
    }
}
