package com.company.leetcode.problems;

import java.util.Arrays;
<<<<<<< Updated upstream
import java.util.HashSet;
=======
>>>>>>> Stashed changes

public class CountCharacters {

    public int countCharacters(String[] words, String chars) {
<<<<<<< Updated upstream
        int [] temp=new int[26];
        int ans=0;
        HashSet<Character> st=new HashSet<>();
        for(char c:chars.toCharArray()){
            temp[c-'a']++;
        }
        System.out.print(st);
        for(String s:words){
            if(ismatch(s,temp)){

                ans+=s.length();
            }
        }
        return ans;


    }
    boolean ismatch(String s,int[] temp){
        int []temp1= Arrays.copyOf(temp, temp.length);
        for(char str:s.toCharArray()){
            if(temp1[str-'a']==0) return false;
            else temp1[str-'a']--;

        }
        return true;
    }

=======
        int[] letters = new int[26];
        int validWordCount = 0;

        for (char ch : chars.toCharArray()) letters[(int)(ch - 97)]++;

        for (String word : words){
            int[] lettersCopy = Arrays.copyOf(letters, 26);
            boolean validWord = true;

            for (char ch : word.toCharArray()){
                int charVal = (int)(ch-97);
                if (lettersCopy[charVal] <= 0) { validWord = false; break; }
                else lettersCopy[charVal]--;
            }
            if (validWord) validWordCount += word.length();
        }

        return validWordCount;
    }
}
>>>>>>> Stashed changes
}
