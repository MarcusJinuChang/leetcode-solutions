class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = 0;
        boolean holding = false;

        for (int i = 0; i < prices.length-1; i++) {
            if (holding && prices[i+1] < prices[i]) {
                profit += prices[i] - buy;
                holding = false;
            }

            if (!holding && prices[i+1] > prices[i]) {
                buy = prices[i];
                holding = true;
            }
        }

        if (holding) profit += prices[prices.length-1] - buy;

        return profit;
    }
}