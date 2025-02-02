/*
Problem: 1752. Check if Array Is Sorted and Rotated
### **Understanding the Code**
This function **checks if the given array `nums` is sorted or can be made sorted by a single rotation**.

---

### **Approach Explanation**
1. **Detect Violations of Sorted Order**:  
   - Traverse the array and count how many times `nums[i] > nums[i+1]`.  
   - Use **modulo indexing** (`(i + 1) % n`) to compare the last element with the first element.

2. **Decision Conditions**:  
   - If the count of such violations is **more than 1**, return `false` (array cannot be sorted by a single rotation).
   - Otherwise, return `true`.

---

### **Example Walkthrough**
#### **Example 1**
```java
int[] nums = {3, 4, 5, 1, 2};
Solution sol = new Solution();
System.out.println(sol.check(nums)); // Output: true
```
**Step-by-step check**:
| i  | nums[i] | nums[(i+1) % n] | Condition (`nums[i] > nums[i+1]`?) |
|----|--------|----------------|--------------------------------|
| 0  | 3      | 4              | ❌ No                         |
| 1  | 4      | 5              | ❌ No                         |
| 2  | 5      | 1              | ✅ Yes (Violation count = 1)  |
| 3  | 1      | 2              | ❌ No                         |
| 4  | 2      | 3              | ❌ No                         |

✅ Since there is **only 1 violation**, return **`true`** (possible by a single rotation).

---

#### **Example 2**
```java
int[] nums = {2, 1, 3, 4};
System.out.println(sol.check(nums)); // Output: false
```
**Step-by-step check**:
| i  | nums[i] | nums[(i+1) % n] | Condition (`nums[i] > nums[i+1]`?) |
|----|--------|----------------|--------------------------------|
| 0  | 2      | 1              | ✅ Yes (Violation count = 1)  |
| 1  | 1      | 3              | ❌ No                         |
| 2  | 3      | 4              | ❌ No                         |
| 3  | 4      | 2              | ✅ Yes (Violation count = 2)  |

🚫 Since there are **2 violations**, return **`false`**.

---

### **Complexity Analysis**
- **Time Complexity**: \(O(n)\) → We traverse the array once.
- **Space Complexity**: \(O(1)\) → We use only a few variables (`count`, `n`).

---

### **Edge Cases Considered**
1. **Already Sorted Array** (`[1, 2, 3, 4, 5]`)  
   ✅ Should return `true` (no violations).
  
2. **Single Rotation of Sorted Array** (`[3, 4, 5, 1, 2]`)  
   ✅ Should return `true` (only 1 violation).
  
3. **More than 1 Violation** (`[2, 1, 3, 4]`)  
   🚫 Should return `false`.

4. **Array with One Element** (`[1]`)  
   ✅ Should return `true` (trivially sorted).

5. **Array with Two Elements** (`[2, 1]`)  
   ✅ Should return `true` (can be rotated).

---

### **Summary**
✔ **Efficient \(O(n)\) solution**  
✔ **Checks for sorting violations and allows one rotation**  
✔ **Uses modulo indexing to handle circular checks**  
✔ **Simple yet effective** 🚀

*/
import java.util.*;

class _02LC_CheckArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int count = 0 ;
        int n = nums.length;
        for(int i = 0; i<n; i++){
            if(nums[i] > nums[(i+1)%n]) //(i+1)%n is used to compare the last element with the first element
                count++;
            if(count>1) // More than 1 violation
                return false;
        }
        return true;
    }
}