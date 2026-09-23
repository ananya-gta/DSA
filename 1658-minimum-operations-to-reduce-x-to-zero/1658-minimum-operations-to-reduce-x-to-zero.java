class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum < x) return -1;
        int lengthOfLongestSubarray = longestSubarrayWithSumK(nums, totalSum - x);
        if (lengthOfLongestSubarray == 0 && totalSum - x != 0) return -1;
        return nums.length - lengthOfLongestSubarray;
    }

    public int longestSubarrayWithSumK(int[] arr, int k) {
        int i = 0, maxL = 0, sum = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            while (sum > k) {
                sum -= arr[i];
                i++;
            }
            if (sum == k) {
                maxL = Math.max(maxL, j-i+1);
            }
        }
        return maxL;
    }
}