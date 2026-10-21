class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstFound = 0, secondFound = 0;
        firstFound = binarySearch(nums, target, true);
        secondFound = binarySearch(nums, target, false);
        return new int[] { firstFound, secondFound };
    }

    int binarySearch(int[] nums, int target, boolean findFirst) {
        int left = 0, right = nums.length - 1;
        int foundAt = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                foundAt = mid;
                if (findFirst)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return foundAt;
    }
}