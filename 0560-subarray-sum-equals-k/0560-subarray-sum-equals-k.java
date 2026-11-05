class Solution {
    public int subarraySum(int[] nums, int k) {
       int count = 0, ps = 0;
 
       Map<Integer, Integer> map = new HashMap<>();
       // Handle subarrays that start from index 0. 
       // This ensures that whenever the current prefix sum itself equals k, 
    //     we count that subarray.
             map.put(0, 1); 
       for (int num : nums) {
            ps += num;
            int toFind = ps - k;
            count += map.getOrDefault(toFind, 0);
            map.put(ps, map.getOrDefault(ps, 0) + 1);
       }
       return count;
    }
}