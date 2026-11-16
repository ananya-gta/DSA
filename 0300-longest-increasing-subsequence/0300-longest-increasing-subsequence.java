class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(-1, 0, nums, dp);
    }

    public int solve(int prev, int curr, int[] nums, int[][] dp) {
        // base case 
        if (curr == nums.length) 
            return 0;

        if (dp[prev + 1][curr] != -1) return dp[prev + 1][curr];

        // skip element
        int skip = solve(prev, curr + 1, nums, dp);

        // take curr element
        int take = 0;

        if (prev == -1 || nums[curr] > nums[prev]) {
            take = 1 + solve(curr, curr + 1, nums, dp);
        }

        return dp[prev + 1][curr] = Math.max(take, skip);
    }
}