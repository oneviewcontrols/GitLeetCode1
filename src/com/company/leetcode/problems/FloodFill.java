package com.company.leetcode.problems;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int num = image[sr][sc];
            for (int i=0;i<image.length;i++) {
                for (int j=0;j<image[i].length;j++) {
                    fillSquares(image,i,j,num,newColor);
                }
            }
            return image;
    }

    private void fillSquares(int[][] image,int i,int j,int num,int newColor) {
        if ((i < 0) || (i >= image.length)) return;
        if ((j < 0) || (j >= image[i].length)) return;
        if (image[i][j] == num) {
            // Need to check to see if an adjacent square is colored or going to be colored.
            image[i][j] = newColor;
        } else {
            return;
        }
        fillSquares(image,i - 1,j,num,newColor);
        fillSquares(image,i + 1,j,num,newColor);
        fillSquares(image,i,j - 1,num,newColor);
        fillSquares(image,i,j + 1,num,newColor);
    }

    public static void runTestCases() {
        FloodFill f= new FloodFill();
        int[][] image =  {{1,1,1},{1,1,0},{1,0,1}};
        f.floodFill(image,1,1,2);
    }
}
