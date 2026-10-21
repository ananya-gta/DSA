class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] freq = new boolean[nums.length + 1];
        for (int num : nums) {
            if (num > 0 && num <= nums.length)
                freq[num] = true;
        }

        for (int i = 1; i < freq.length; i++) {
            if (!freq[i]) return i;
        }

        return nums.length + 1;

    }
}