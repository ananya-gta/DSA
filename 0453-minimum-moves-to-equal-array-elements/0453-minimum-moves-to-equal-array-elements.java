class Solution {
    public int minMoves(int[] nums) {
        int moves = 0, min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            moves += Math.abs(min - nums[i]);
        }
        return moves;
    }
}