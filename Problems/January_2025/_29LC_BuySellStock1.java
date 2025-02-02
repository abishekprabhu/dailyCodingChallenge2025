/*121. Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
*/
class Solution {
    public int maxProfit(int[] prices) {
        int i = 1 ; 
        int len = prices.length;
        int current = prices[0];
        int max_profit = 0 ;
        while(i < len){
            // 1 < 7
            if(prices[i]<current){
                current = prices[i]; //1
            }else{
                max_profit = Math.max(max_profit, prices[i]-current);
            }
            i++;
        }
        return max_profit;
    }
}

// class Solution {
//     public int maxProfit(int[] prices) {
//         int min=prices[0];
//         int max=0;
//         for(int i=1;i<prices.length;i++){
//             min=Math.min(min,prices[i]);
//             max=Math.max(max,prices[i]-min);
//         }
//         return max;
//     }
// }
