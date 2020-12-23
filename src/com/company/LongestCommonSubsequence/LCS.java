package com.company.LongestCommonSubsequence;

public class LCS {
    public static void main(String[] args) {
        LCS lcs = new LCS();
        String str1 = "stone";
        String str2 = "longest";
        char[] row = str1.toCharArray();
        char[] column = str2.toCharArray();
        System.out.println("Result using dynamic programming: " + lcs.longestCommonSubsequence(row, column, row.length, column.length));
        System.out.println("result using recursion: " + lcs.longestCommonSubsequenceUsingRecursion(row, column, row.length, column.length));
    }
    //Dynamic programming approach
//    Formula:
//    if row[i-1] == column[j] then result[i][j] = 1 + result[i-1][j-1]
//    if not equal then result[i][j] = Max(result[i-1][j], result[i][j-1])
    public int longestCommonSubsequence(char[] row, char[] column, int rowStringLength, int columnStringLength) {
        int[][] LCS = new int[rowStringLength + 1][columnStringLength + 1];
        for (int i = 0; i <= rowStringLength; i++) {
            for (int j = 0; j <= columnStringLength; j++) {
                if (i == 0 || j == 0) {
                    LCS[i][j] = 0;
                } else if (row[i -1] == column[j - 1]) {
                    LCS[i][j] = 1 + LCS[i - 1][j - 1];
                } else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }
        return LCS[rowStringLength][columnStringLength];
    }

//    Recursive approach
    public int longestCommonSubsequenceUsingRecursion(char[] row, char[] column, int rowLength, int columnLength) {
        if(rowLength == 0 || columnLength == 0) return 0;

        if(row[rowLength - 1] == column[columnLength - 1])
            return 1 + longestCommonSubsequenceUsingRecursion(row, column, rowLength - 1, columnLength - 1);
        else
            return Math.max(longestCommonSubsequenceUsingRecursion(row, column, rowLength, columnLength - 1),
                    longestCommonSubsequenceUsingRecursion(row, column, rowLength - 1, columnLength));
    }


}
