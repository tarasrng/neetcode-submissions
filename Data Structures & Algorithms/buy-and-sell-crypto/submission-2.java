class Solution {
    public int maxProfit(int[] prices) {
        // min = 2
        // prof = curr - min = 0   

        //[5,1,5,6,7,1,10]

        if (prices.length == 0) {
            return 0;
        }

        int min = prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }

        return maxProfit;
    }
}
