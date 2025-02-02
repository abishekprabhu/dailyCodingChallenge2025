/*The n-queens puzzle is the problem of placing n queens on a (n × n) chessboard such that no two queens can attack each other. Note that two queens attack each other if they are placed on the same row, the same column, or the same diagonal.

Given an integer n, find all distinct solutions to the n-queens puzzle.
You can return your answer in any order but each solution should represent a distinct board configuration of the queen placements, where the solutions are represented as permutations of [1, 2, 3, ..., n]. In this representation, the number in the ith position denotes the row in which the queen is placed in the ith column.
For eg. below figure represents a chessboard [3 1 4 2].
Diagram of chessboard
[0 Q 0 0]
[0 0 0 Q]
[Q 0 0 0]
[0 0 Q 0]
Examples:

Input: n = 1
Output: [1]
Explaination: Only one queen can be placed in the single cell available.
Input: n = 4
Output: [[2 4 1 3 ] [3 1 4 2 ]]
Explaination: There are 2 possible solutions for n = 4.
Input: n = 2
Output: []
Explaination: There are no possible solutions for n = 2.
Constraints:
1 ≤ n ≤ 10
*/
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
// import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                ans.sort((list1, list2) -> {
                    int size = Math.min(list1.size(), list2.size());
                    for (int i = 0; i < size; i++) {
                        if (!list1.get(i).equals(list2.get(i))) {
                            return list1.get(i) - list2.get(i);
                        }
                    }
                    return list1.size() - list2.size();
                });

                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        boolean col[] = new boolean[n];
        boolean ndiag[] = new boolean[2*n-1]; // formula to find the diagonal size = 
        boolean rdiag[] = new boolean[2*n-1];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        solve(n,0,col,ndiag,rdiag,result,temp);
        
        return result;
    }
    static void solve(int n, int currRow, boolean col[] ,
    boolean ndiag[] , boolean rdiag[] , ArrayList<ArrayList<Integer>> result ,
    ArrayList<Integer> temp){
        if(currRow == n){
            result.add(new ArrayList<>(temp)); //add the temp to result
            return;
        }
        
        for(int i = 0 ; i < n; i++){
            if(col[i] == false //column is not marked
            && ndiag[currRow+i]==false //row+col = i 0 1 2 3 4 5 6
            && rdiag[currRow-i+n-1] == false){ //row-col+n-1 = i 6 5 4 3 2 1 0
                temp.add(i+1); // 1 based indexing for queen
                col[i] =true; //mark the column as true
                ndiag[currRow+i] = true; //mark the diagonal as true
                rdiag[currRow-i+n-1] = true; //mark the reverse diagonal as true
                solve(n,currRow+1,col,ndiag,rdiag,result,temp);
                temp.remove(temp.size()-1); //backtrack to remove the last element
                col[i] =false;  
                ndiag[currRow+i] = false;
                rdiag[currRow-i+n-1] = false;
            }
        }
    }
}