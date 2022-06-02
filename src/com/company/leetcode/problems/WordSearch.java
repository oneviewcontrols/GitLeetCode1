package com.company.leetcode.problems;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        char[] letters = word.toCharArray();
        Integer index = 0;
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[i].length;j++) {
                if (board[i][j] == letters[index]) {
                    if(findLetters(board,letters,index,i,j)) return true;
                }
            }
        }
        return false;
    }


    public static boolean findLetters(char[][] board,char[] letters, Integer index,int i,int j) {
        if (index >= letters.length) return true;
        if ((i < 0) || (j < 0)) return false;
        if ((i >= board.length) || (j >= board[i].length)) return false;
        if (board[i][j] != letters[index]) return false;

        board[i][j] = '0';
        boolean pathA = findLetters(board,letters,index + 1,i + 1,j);
        boolean pathB = findLetters(board,letters,index + 1,i - 1,j);
        boolean pathC = findLetters(board,letters,index + 1,i,j + 1);
        boolean pathD = findLetters(board,letters,index + 1,i,j - 1);
        if (pathA || pathB || pathC || pathD) return true;
        board[i][j] = letters[index];
        return false;
    }
}
