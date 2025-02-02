/*122. Best Time to Buy and Sell Stock II
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 * ex:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *            Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *           Total profit is 4 + 3 = 7.
 * ex2:
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *          Total profit is 4.
 * ex3;
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */

public class _LC_BestTimeToSellAndBuyII {
        public int maxProfit(int[] prices) {
            int profit = 0;
            for(int i = 0 ; i < prices.length-1 ; i++){
                if(prices[i+1] > prices[i]) // if next day price is greater than current day price then add the difference to profit
                    profit += prices[i+1] - prices[i]; // add the difference to profit
            }
             return profit;
        
    }
}
