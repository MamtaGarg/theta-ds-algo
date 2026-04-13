package twopointer.converging;

/**
 * Problem: Given an array prices[] where prices[i] is the price of a stock on the i-th day,
  find the maximum profit achievable from a single buy-sell transaction.
  You must buy before you sell. If no profit is possible, return 0.

 * Example:
    Input:  [3, 2, 6, 5, 0, 3]
    Output: 4  (buy at 2, sell at 6)

 * Logic:
    1. Track the minimum price seen so far (best day to buy).
    2. For each subsequent day, calculate the profit if we sold today.
    3. Update maxProfit whenever the current profit exceeds it.
    4. If today's price is lower than buyPrice, update buyPrice (better buying opportunity).

 * Time Complexity:  O(n) — single pass through the prices array.
 * Space Complexity: O(1) — only two tracking variables used.
 */
public class MaxProfitByBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        // Start with the first day as the initial buy price
        int buyPrice = prices[0];
        int maxProfit = 0;

        // Iterate from the second day onward
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < buyPrice) {
                // Found a cheaper buying day — update buyPrice
                buyPrice = prices[i];
            } else {
                // Calculate profit if we sell today
                int currentProfit = prices[i] - buyPrice;
                // Keep the maximum profit seen so far
                maxProfit = Math.max(currentProfit, maxProfit);
            }
        }
        return maxProfit;
    }

    public static int maxProfitClean(int[] prices) {
        int buyPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else {
                int currentProfit = prices[i] - buyPrice;
                maxProfit = Math.max(currentProfit, maxProfit);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        //int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        //int[] prices = new int[]{1};
        int[] prices = new int[]{3,2,6,5,0,3};
        System.out.println("Maximum Profit : " + maxProfit(prices));
    }
}
