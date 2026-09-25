class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for (int n : nums) {
            if (n == 0) red++;
            if (n == 1) white++;
            if (n == 2) blue++;
        }
        int i = 0;
        while (red-- > 0) nums[i++] = 0;
        while (white-- > 0) nums[i++] = 1;
        while (blue-- > 0) nums[i++] = 2;
    }
}