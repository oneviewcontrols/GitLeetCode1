package com.company.leetcode.problems;

public class BattleshipsInAbBoard {

    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i=0;i< board.length;i++){
            for (int j=0;j<board[i].length;j++) {
                if (board[i][j] == 'X') {
                    count++;
                    clearBoard(board,i,j);
                }
            }
        }
        return count;
    }

    private void clearBoard(char[][] board,int i, int j) {
        if ((i >= board.length) || (i < 0) || ((j >= board[i].length) || (j < 0))) {
            return;
        }
        if (board[i][j] == '.') return;
        board[i][j] = '.';
        clearBoard(board,i - 1,j);
        clearBoard(board,i + 1,j);
        clearBoard(board,i,j - 1);
        clearBoard(board,i,j + 1);
    }

    public int countBattleshipsOld(char[][] board) {
        int count = 0;
        for (int i=0;i< board.length;i++) {
            for (int j=0;j< board[0].length;j++) {
                System.out.println("[" + i + "," + j + "] = " + board[i][j]);
                if (board[i][j] == 'X') {
                    count++;
                    clearShip(board,i,j);
                }
            }
        }
        return count;
    }

    private void clearShip(char[][] board,int i,int j) {
        if ((i<0) || (j<0)) return;
        if (board[i][j] != 'X') return;
        board[i][j] = '.';
        clearShip(board,i - 1,j);
        if ((i + 1) <  board.length) {
            clearShip(board, i + 1, j);
        }
        clearShip(board,i,j - 1);
        if ((j + 1) < board[0].length) {
            clearShip(board, i, j + 1);
        }
        return;
    }

    public static void runTestCases() {
        BattleshipsInAbBoard b = new BattleshipsInAbBoard();
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        System.out.println(b.countBattleships(board));
    }
}

