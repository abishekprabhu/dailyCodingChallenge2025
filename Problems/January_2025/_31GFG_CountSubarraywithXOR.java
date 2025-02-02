/*Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

Examples: 

Input: arr[] = [4, 2, 2, 6, 4], k = 6
Output: 4
Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.
Input: arr[] = [5, 6, 7, 8, 9], k = 5
Output: 2
Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]. Hence, the answer is 2.
Input: arr[] = [1, 1, 1, 1], k = 0
Output: 4
Explanation: The subarrays are [1, 1], [1, 1], [1, 1] and [1, 1, 1, 1].
Constraints:

1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤105
0 ≤ k ≤ 105
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class _31GFG_CountSubarraywithXOR {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        long ans = 0 ;
        Map<Integer,Integer> mp = new HashMap<>();
        
        mp.put(0,1);
        int currXOR = 0;
        for(int i : arr){
            currXOR = currXOR^i;
            if(mp.containsKey(currXOR^k)){
                ans += mp.get(currXOR^k);
            }
            mp.put(currXOR,mp.getOrDefault(currXOR,0)+1);
        }
        return ans;
    }
}

/*## **Problem Statement**  
We need to **count the number of subarrays** whose XOR is equal to `k`.  
- A **subarray** is a contiguous part of an array.
- **XOR** operation (`^`) follows:  
  ```
  a ^ a = 0  (same numbers cancel out)
  a ^ 0 = a  (XOR with zero gives the same number)
  ```
  
## **Understanding XOR in Subarrays**  
If we take the **XOR of all elements from index `L` to `R`**, it gives us a value.  
- Let's call `prefixXOR[R]` the **XOR from index `0` to `R`**.
- The XOR of a subarray `[L, R]` is:
  ```
  XOR(L, R) = prefixXOR[R] ^ prefixXOR[L-1]
  ```
- We want:
  ```
  prefixXOR[R] ^ prefixXOR[L-1] = k
  ```
  which means:
  ```
  prefixXOR[L-1] = prefixXOR[R] ^ k
  ```
  - This tells us that if `prefixXOR[L-1]` was seen before in the array, it means a valid subarray exists.

  
### **Tracking Execution**
| Step | `i` | Element | `currXOR` (Prefix XOR) | `currXOR ^ k` | Exists in Map? | Count Added | `mp` (Updated) |
|------|----|--------|--------------------|-------------|---------------|------------|--------------|
| 1    | 0  | 4      | `0 ^ 4 = 4`        | `4 ^ 6 = 2` | No            | 0          | `{0:1, 4:1}` |
| 2    | 1  | 2      | `4 ^ 2 = 6`        | `6 ^ 6 = 0` | Yes (`0:1`)   | 1          | `{0:1, 4:1, 6:1}` |
| 3    | 2  | 2      | `6 ^ 2 = 4`        | `4 ^ 6 = 2` | No            | 0          | `{0:1, 4:2, 6:1}` |
| 4    | 3  | 6      | `4 ^ 6 = 2`        | `2 ^ 6 = 4` | Yes (`4:2`)   | 2          | `{0:1, 4:2, 6:1, 2:1}` |
| 5    | 4  | 4      | `2 ^ 4 = 6`        | `6 ^ 6 = 0` | Yes (`0:1`)   | 1          | `{0:1, 4:2, 6:2, 2:1}` |

### **Final Answer**
```
ans = 4

## **Code Explanation**

2. **Time Complexity**:  
   - **O(n)** (since each element is processed once, and hashmap operations are O(1) on average).
   
3. **Space Complexity**:  
   - **O(n)** (storing XOR values in hashmap).

---

## **Summary**
✅ **Maintain running XOR (`currXOR`)**  
✅ **Use a hashmap (`mp`)** to track previously seen XORs  
✅ **Check if `currXOR ^ k` exists in `mp`**  
✅ **If yes, add its frequency to `ans`**  
✅ **Return `ans` (total count of subarrays with XOR = `k`)**  
*/