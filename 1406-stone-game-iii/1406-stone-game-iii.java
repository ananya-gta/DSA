class Solution {
    Integer[] dp;

    public String stoneGameIII(int[] stoneValue) {
        dp = new Integer[stoneValue.length + 1];
        int diff = solve(0, stoneValue);
        if (diff > 0)
            return "Alice";
        else if (diff < 0)
            return "Bob";
        else
            return "Tie";
    }

    public int solve(int i, int[] stones) {
        int n = stones.length;
        if (i >= n)
            return 0;
        if (dp[i] != null)
            return dp[i];
        int diff = Integer.MIN_VALUE;
        int alice = stones[i], bob = solve(i + 1, stones);
        diff = Math.max(diff, alice - bob);
        if (i + 1 < n) {
            alice = stones[i] + stones[i + 1];
            bob = solve(i + 2, stones);
            diff = Math.max(diff, alice - bob);
        }
        if (i + 2 < n) {
            alice = stones[i] + stones[i + 1] + stones[i + 2];
            bob = solve(i + 3, stones);
            diff = Math.max(diff, alice - bob);
        }
        return dp[i] = diff;
    }
}