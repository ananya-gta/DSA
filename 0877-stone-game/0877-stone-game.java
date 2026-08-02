class Solution {
    Integer[][] dp;
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        int n = piles.length;
        dp = new Integer[n][n];
        for (int pile : piles) sum += pile;
        int aliceScore = findAliceScore(0, piles.length - 1, piles);
        return aliceScore > sum/2;
    }

    public int findAliceScore(int i, int j, int[] piles) {
        if (i > j) return 0;
        if (i == j) return piles[i];
        if (dp[i][j] != null)
            return dp[i][j];
        int AliceTakesFirst = piles[i] + Math.min(
            findAliceScore(i + 2, j, piles),
            findAliceScore(i + 1, j - 1, piles)
        );
        int AliceTakesLast = piles[j] + Math.min(
            findAliceScore(i + 1, j - 1, piles),
            findAliceScore(i, j - 2, piles)
        );
        return dp[i][j] = Math.max(AliceTakesFirst, AliceTakesLast);
    }
}