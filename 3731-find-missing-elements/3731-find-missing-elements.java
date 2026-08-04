class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (n < min) min = n;
            if (n > max) max = n;
            set.add(n);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) ans.add(i);
        }
        return ans;
    }
}