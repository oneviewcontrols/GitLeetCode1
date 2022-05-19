package com.company.leetcode.assessments;

public class BloombergTwo_One {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                if (grid[i][j] == 1) {
                    int area = getArea(grid,i,j,0);
                    max = max < area ? area : max;
                }
            }
        }
        return max;
    }

    private int getArea(int[][] grid,int i,int j, int count) {
        if ((i < 0) || (j < 0)) return count;
        if (i >= grid.length) return count;
        if (j >= grid[i].length) return count;
        if (grid[i][j] == 1) {
            count++;
            grid[i][j] = 0;
            count = getArea(grid,i -1,j,count);
            count = getArea(grid,i + 1,j,count);
            count = getArea(grid,i,j - 1,count);
            count = getArea(grid,i,j + 1,count);
            return count;
        }
        return count;
    }

    public static void runTestCases() {
        BloombergTwo_One b = new BloombergTwo_One();
        int[][]  grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(b.maxAreaOfIsland(grid));
    }

}
