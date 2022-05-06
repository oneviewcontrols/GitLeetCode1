package com.company.leetcode.problems;

import java.util.*;

public class PhoneNumberConversion {
    Map<Integer,String[]> phoneNums = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) { return new ArrayList<>();}
        String[] digitsArray = digits.split("");
        phoneNums = populateMap();
        return getIt(digitsArray);
    }

    private List<String> getIt(String[] digits) {
        if (digits.length == 1) {
            return singleNumberResult(digits[0]);
        }
        Map<Integer,String[]> map = getPhoneNums();
        List<String> returnList = new ArrayList<>();
        int arrayOneLength = map.get(Integer.valueOf(digits[0])).length;
        for (int i=0;i<arrayOneLength;i++) {
            String firstChar = map.get(Integer.valueOf(digits[0]))[i];
            int arrayTwoLength = map.get(Integer.valueOf(digits[1])).length;
            for (int x=0;x< arrayTwoLength;x++) {
                String secondChar = map.get(Integer.valueOf(digits[1]))[x];
                if (digits.length == 2) {
                    returnList.add(firstChar + secondChar);
                    continue;
                }
                int arrayThreeLength = map.get(Integer.valueOf(digits[2])).length;
                for (int y = 0; y < arrayThreeLength; y++) {
                    String thirdChar = map.get(Integer.valueOf(digits[2]))[y];
                    if (digits.length == 4) {
                        int arrayFourLength = map.get(Integer.valueOf(digits[3])).length;
                        for (int z=0;z<arrayFourLength;z++) {
                            String fourthChar = map.get(Integer.valueOf(digits[3]))[z];
                            returnList.add(firstChar + secondChar + thirdChar + fourthChar);
                        }
                    } else {
                        returnList.add(firstChar + secondChar + thirdChar);
                    }

                }
            }

        }
        return returnList;
    }

    private Map<Integer,String[]> getPhoneNums() {
        return phoneNums;
    }

    private List<String> singleNumberResult(String character) {
        Map<Integer,String[]> map = getPhoneNums();
        String[] result = map.get(Integer.valueOf(character));
        return new ArrayList<>(Arrays.asList(result));
    }

    private Map<Integer,String[]> populateMap() {
        Map<Integer,String[]> map = new HashMap<>();
        String[] two = {"a","b","c"};
        String[] three = {"d","e","f"};
        String[] four = {"g","h","i"};
        String[] five = {"j","k","l"};
        String[] six = {"m","n","o"};
        String[] seven = {"p","q","r","s"};
        String[] eight = {"t","u","v"};
        String[] nine = {"w","x","y","z"};
        map.put(2,two);
        map.put(3,three);
        map.put(4,four);
        map.put(5,five);
        map.put(6,six);
        map.put(7,seven);
        map.put(8,eight);
        map.put(9,nine);
        return map;

    }
}
