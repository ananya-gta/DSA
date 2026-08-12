class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        // use two pointers i and j, maintain count in hashmap for each window, if greater than k, renew
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, ans = 0;
        while ( j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.get(nums[j]) > k) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }

        return ans;
    }
}