class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        cycleSort(nums, n);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 != i) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    public void cycleSort(int[] nums, int n) {
        int i = 0;
        while (i < n) {
            int correctIdx = nums[i] - 1;
            if (nums[i] != nums[correctIdx]) {
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
            else {
                i++;
            }
        }
    }
}