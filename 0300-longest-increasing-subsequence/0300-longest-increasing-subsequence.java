class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, -1, nums, dp, n);

    }

    public int solve(int currIdx, int prevIdx, int[] nums, int[][] dp, int n) { // we encountered overlapping problems, therefore using memoization
        int maxLen = 0;
        // base case
        if (currIdx == n) return maxLen;
        // use already calculated 
        if (dp[currIdx][prevIdx + 1] != -1) 
            return dp[currIdx][prevIdx + 1];
        // not take
        int lenIfWeDoNotTake = 0 + solve(currIdx + 1, prevIdx, nums, dp, n);

        // take
        int lenIfWeTake = 0;
        if (prevIdx == -1 || nums[currIdx] > nums[prevIdx]) {
            lenIfWeTake = 1 + solve(currIdx + 1, currIdx, nums, dp, n);
        }

        // max of both
        maxLen = Math.max(lenIfWeDoNotTake, lenIfWeTake);

        return dp[currIdx][prevIdx + 1] = maxLen;
    }
}