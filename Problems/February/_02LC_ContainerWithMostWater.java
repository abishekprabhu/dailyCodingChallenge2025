/*11. Container With Most Water
Medium
Topics
Companies
Hint
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

 

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
 

Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
*/

import java.io.*;
import java.lang.*;
import java.util.*;
class _02LC_ContainerWithMostWater {
    public static int maxArea(int[] height) {
            int n = height.length;
            int left = 0;
            int right = n-1;
            int max = 0;
            while(left<right){
                int h = Math.min(height[right],height[left]);// height of container is min of two heights
                int w = right-left; // width of container is difference of two indexes
                max = Math.max(max,h*w); // max of previous max and current container
                if(height[right]<height[left]){ // if right height is less than left height then move right pointer to left
                    right--;
                }else{
                    left++;
                }
            }
            return max;
        }
        public static void main(String[]  args)
        {
            int[] h={1,8,6,2,5,4,8,3,7};
            System.out.println(maxArea(h));
    }
}