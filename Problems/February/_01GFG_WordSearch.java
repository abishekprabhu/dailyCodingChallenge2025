package Problems.February;
/*Word Search
Difficulty: MediumAccuracy: 32.69%Submissions: 60K+Points: 4
You are given a two-dimensional mat[][] of size n*m containing English alphabets and a string word. Check if the word exists on the mat.
 The word can be constructed by using letters from adjacent cells, either horizontally or vertically. 
 The same cell cannot be used more than once.
T E E
S G K
T E L
Examples :

Input: mat[][] = [['T', 'E', 'E'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
Output: true
Explanation:

The letter cells which are used to construct the "GEEK" are colored.
Input: mat[][] = [['T', 'E', 'U'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
Output: false
Explanation:

It is impossible to construct the string word from the mat using each cell only once.
Input: mat[][] = [['A', 'B', 'A'], ['B', 'A', 'B']], word = "AB"
Output: true
Explanation:

There are multiple ways to construct the word "AB".
Constraints:
1 ≤ n, m ≤ 6
1 ≤ L ≤ 15
mat and word consists of only lowercase and uppercase English letters.

*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

import Solution;

class _01GFG_WordSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    static public boolean isWordExist(char[][] mat, String word) {
        // Code here
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == word.charAt(0)){
                    boolean[][] visit = new boolean[mat.length][mat[0].length];
                    if(check(mat, i, j, 0, word, visit))
                        return true;
                }
            }
        }
        return false;
    }
    static boolean check(char[][] mat, int i, int j, int ind, String word, boolean[][] visit){
        if(ind == word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=mat.length || j>= mat[0].length || visit[i][j] || mat[i][j] != word.charAt(ind)){
            return false;
        }
        visit[i][j]=true;
        if(check(mat, i, j-1, ind+1, word, visit) ||
           check(mat, i, j+1, ind+1, word, visit) ||
           check(mat, i+1, j, ind+1, word, visit) ||
           check(mat, i-1, j, ind+1, word, visit))
           return true;
           
        visit[i][j]=false;
        return false;
    }
}