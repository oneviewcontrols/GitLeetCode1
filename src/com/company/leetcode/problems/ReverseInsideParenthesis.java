package com.company.leetcode.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class ReverseInsideParenthesis {

        public String reverseParentheses(String s) {
            Stack<Character> list=new Stack<>();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!=')'){
                    list.push(s.charAt(i));
                }
                else{
                    ArrayList<Character> li=new ArrayList<>();
                    while(list.peek()!='('){
                        li.add(list.pop());
                    }
                    list.pop();
                    for(int j=0;j<li.size();j++){
                        list.push(li.get(j));
                    }
                }
            }
            String ans="";
            for(int i=0;i<list.size();i++){
                ans+=list.get(i);
            }


            return ans;
        }

}
