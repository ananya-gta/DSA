class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, n = nums.length, min = Integer.MAX_VALUE, sum = 0;
        for (int num : nums) sum += num;
        if (sum < target) return 0;
        sum = 0;
        for (int j = 0; j < n; j++) {
            sum += nums[j];
            while (sum >= target) {
                int windowL = j - i + 1;
                min = Math.min(min, windowL);
                sum -= nums[i++];
            }
        }
        return min;
    }
}