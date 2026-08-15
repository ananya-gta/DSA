class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0, n = nums.length;
        for (int num : nums) {
            xor ^= num;
        }

        if (xor != 0) {
            return n;
        } 

        for (int num : nums) {
            if (num != 0) {
                return n - 1;
            }
        }
        return 0;
    }
}