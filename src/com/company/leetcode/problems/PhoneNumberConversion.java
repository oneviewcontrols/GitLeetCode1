package com.company.leetcode.problems;

import java.util.*;

public class PhoneNumberConversion {
    Map<String,String[]> map = new HashMap<>();
    public List<String> letterCombinations(String number) {
        List<String> returnList = new ArrayList<>();
        if (number.length() == 0) return returnList;
        map = populateMap();
        String[] digits = number.split("");
        for (int i=0;i<digits.length;i++) {
            int letterIndex = 0;
            String letters = "";
            letters = getNext(letters,i,letterIndex,digits,map);
            returnList.add(letters);
        }
        return returnList;
    }

    private String getNext(String letters,int index,int letterIndex,String[] digits,Map<String,String[]> map) {
        if (index == digits.length) {
            return letters;
        }
        String[] str = map.get(digits[index]);
        if (letterIndex < str.length) {
            letters += str[letterIndex];
            letterIndex++;
            letters = getNext(letters,index,letterIndex,digits,map);
         }
        return letters;
    }

    static public void runTest(String number) {
        PhoneNumberConversion p = new PhoneNumberConversion();
        List<String> result = p.letterCombinations(number);
        for (String s : result) {
            System.out.println(s);
        }

    }


    public List<String> letterCombinationsOld(String number) {
        List<String> returnList = new ArrayList<>();
        if (number.length() == 0) return returnList;

        map = populateMap();
        String[] digits= number.split("");
        List<String[]> list = new ArrayList<>();
        for (String s : digits) {
            list.add(map.get(s));
        }
        for (String letter1 : list.get(0)) {
            if (list.size() > 1) {
                for (String letter2 : list.get(1)) {
                    if (list.size() > 2) {
                        for (String letter3 : list.get(2)) {
                            if (list.size() > 3) {
                                for (String letter4 : list.get(3)) {
                                    returnList.add(letter1 + letter2 + letter3 + letter4);
                                }
                            } else {
                                returnList.add(letter1 + letter2 + letter3);
                            }
                        }
                    } else {
                        returnList.add(letter1 + letter2);
                    }
                }
            }  else {
                returnList.add(letter1);
            }
        }

        return returnList;
    }



    private Map<String,String[]> populateMap() {
        Map<String,String[]> map = new HashMap<>();
        String[] two = {"a","b","c"};
        String[] three = {"d","e","f"};
        String[] four = {"g","h","i"};
        String[] five = {"j","k","l"};
        String[] six = {"m","n","o"};
        String[] seven = {"p","q","r","s"};
        String[] eight = {"t","u","v"};
        String[] nine = {"w","x","y","z"};
        map.put("2",two);
        map.put("3",three);
        map.put("4",four);
        map.put("5",five);
        map.put("6",six);
        map.put("7",seven);
        map.put("8",eight);
        map.put("9",nine);
        return map;

    }
}
