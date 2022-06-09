package com.company.leetcode.problems;

import java.util.*;

public class FindWordLocationGrid {

    /*
After catching your classroom students cheating before, you realize your students are getting craftier and hiding words in 2D grids of letters. The word may start anywhere in the grid, and consecutive letters can be either immediately below or immediately to the right of the previous letter.

Given a grid and a word, write a function that returns the location of the word in the grid as a list of coordinates. If there are multiple matches, return any one.

grid1 = [
    ['c', 'c', 't', 'n', 'a', 'x'],
    ['c', 'c', 'a', 't', 'n', 't'],
    ['a', 'c', 'n', 'n', 't', 't'],
    ['t', 'n', 'i', 'i', 'p', 'p'],
    ['a', 'o', 'o', 'o', 'a', 'a'],
    ['s', 'a', 'a', 'a', 'o', 'o'],
    ['k', 'a', 'i', 'o', 'k', 'i'],
]
word1 = "catnip"
word2 = "cccc"
word3 = "s"
word4 = "ant"
word5 = "aoi"
word6 = "ki"
word7 = "aaoo"
word8 = "ooo"

grid2 = [['a']]
word9 = "a"

find_word_location(grid1, word1) => [ (1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4) ]
find_word_location(grid1, word2) =>
       [(0, 0), (1, 0), (1, 1), (2, 1)]
    OR [(0, 0), (0, 1), (1, 1), (2, 1)]
find_word_location(grid1, word3) => [(5, 0)]
find_word_location(grid1, word4) => [(0, 4), (1, 4), (2, 4)] OR [(0, 4), (1, 4), (1, 5)]
find_word_location(grid1, word5) => [(4, 5), (5, 5), (6, 5)]
find_word_location(grid1, word6) => [(6, 4), (6, 5)]
find_word_location(grid1, word7) => [(5, 2), (5, 3), (5, 4), (5, 5)]
find_word_location(grid1, word8) => [(4, 1), (4, 2), (4, 3)]
find_word_location(grid2, word9) => [(0, 0)]

Complexity analysis variables:

r = number of rows
c = number of columns
w = length of the word


        public static void main(String[] argv) {
            char[][] grid1 = {
                    {'c', 'c', 't', 'n', 'a', 'x'},
                    {'c', 'c', 'a', 't', 'n', 't'},
                    {'a', 'c', 'n', 'n', 't', 't'},
                    {'t', 'n', 'i', 'i', 'p', 'p'},
                    {'a', 'o', 'o', 'o', 'a', 'a'},
                    {'s', 'a', 'a', 'a', 'o', 'o'},
                    {'k', 'a', 'i', 'o', 'k', 'i'}
            };
            String word1 = "catnip";
            String word2 = "cccc";
            String word3 = "s";
            String word4 = "ant";
            String word5 = "aoi";
            String word6 = "ki";
            String word7 = "aaoo";
            String word8 = "ooo";

            char[][] grid2 = {{'a'}};
            String word9 = "a";

        }
**/
    public static int[][] findWordLocation(char[][] grid,String word) {
        char[] letters = word.toCharArray();
        List<List<Integer>> coordinates = new ArrayList<List<Integer>>();
        int index = 0;
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                if (grid[i][j] == letters[index]) {
                    if (findLetter(grid,i,j,letters,index,coordinates) == true) {
                        System.out.print("[");
                        for (List<Integer> list : coordinates) {
                            System.out.print("[" + list.get(0) + "," + list.get(1) + "],");
                        }
                        System.out.println("]");
                    }

                }
            }
        }
        return null;
    }

    public static boolean findLetter(char[][] board,int i,int j,char[] letters,int index, List<List<Integer>> coordinates) {
        if ((i < 0) || (j < 0) || (i >= board.length) || (j >= board[i].length)) return false;
        if ((index >= letters.length)) return true;
        if (board[i][j] != letters[index]) return false;


        index++;
        boolean lookRight = findLetter(board,i, j + 1,letters,index,coordinates);
        boolean lookDown = findLetter(board,i + 1,j,letters,index,coordinates);
        if ((lookRight) || (lookDown)) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(i);
            list.add(j);
            coordinates.add(list);
            return true;
        } else {
            return false;
        }
    }

        public static String findEmbeddedWord(String[] words,String string1) {
            Map<String,Integer> map = null;
            for (int i=0;i<words.length;i++) {
                String[] chars = words[i].split("");
                StringBuilder wordCheck = new StringBuilder();
                map = loadMap(string1);
                for (int j=0;j<chars.length;j++) {
                    if (map.containsKey(chars[j])) {
                        wordCheck.append(chars[j]);
                        if (wordCheck.toString().equals(words[i])) return words[i];
                        Integer count = map.get(chars[j]);
                        if (count == 0) break;
                        map.put(chars[j],--count);
                    } else {
                        break;
                    }
                }
            }
            return null;
        }

        public static Map<String,Integer> loadMap(String string1)  {
            Map<String,Integer> map = new HashMap<String,Integer>();
            String[] letters = string1.split("");
            for (int i=0;i<letters.length;i++) {
                if (map.containsKey(letters[i]) == false) {
                    map.put(letters[i],1);
                } else {
                    Integer count = map.get(letters[i]) + 1;
                    map.put(letters[i],count);
                }
            }
            return map;
        }

    }

