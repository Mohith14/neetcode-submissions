class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
    int best = 0;

    for (int i = 1; i < prices.length; i++) {
        best = Math.max(best, prices[i] - minSoFar);
        minSoFar = Math.min(minSoFar, prices[i]);
    }
    return best;
    }
}
