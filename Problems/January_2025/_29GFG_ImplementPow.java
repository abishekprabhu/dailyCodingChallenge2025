/*Implement the function power(b, e), which calculates b raised to the power of e (i.e. be).

Examples:

Input: b = 3.00000, e = 5
Output: 243.00000
Input: b = 0.55000, e = 3
Output: 0.16638
Input: b = -0.67000, e = -7
Output: -16.49971
Constraints:

-100.0 < b < 100.0
-109 <= e <= 109
Either b is not zero or e > 0.
-104 <= be <= 104
*/

//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class _29GFG_ImplementPow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    double power(double b, int e) {
        // code here
        if(e<0)
            return 1/power(b, -e);
        if(e == 1)
            return b;
        if(e == 0)
            return 1;
        double halfPower = power(b,e/2);
        
        //check e is even 
        if(e%2 == 0)
            return halfPower * halfPower;
        
        return b*halfPower*halfPower; // e is odd eg. 2^7 = 2*2^3*2^3
    }
}
