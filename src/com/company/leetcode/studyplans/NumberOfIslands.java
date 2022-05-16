package com.company.leetcode.studyplans;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    clearIsland(grid,i,j);
                }
            }
        }
        return islands;
    }

    private void clearIsland(char[][] grid,int i,int j) {
        if ((i < 0) || (i >= grid.length) || (j < 0) || (j >= grid[i].length)) return;
        if (grid[i][j] != '1') return;
        grid[i][j] = '0';
        clearIsland(grid, i + 1, j);
        clearIsland(grid, i - 1, j);
        clearIsland(grid,i,j + 1);
        clearIsland(grid,i,j - 1);
    }


    public static void runTestCases() {
        NumberOfIslands n = new NumberOfIslands();
        char[][] grid = {{'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}};
        char[][] grid2 = {{'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}};
        System.out.println(n.numIslands(grid2));
    }
}
