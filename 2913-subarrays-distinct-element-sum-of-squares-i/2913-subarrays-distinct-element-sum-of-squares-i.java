class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size(), sum = 0;;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = i; k <= j; k++) {
                    set.add(nums.get(k));
                }
                int count = set.size();
                sum += count * count;
            }
        }
        return sum;
    }
}