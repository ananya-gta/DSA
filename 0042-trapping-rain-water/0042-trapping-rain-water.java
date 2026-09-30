class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int l = 0, r = height.length - 1, lMax = 0, rMax = 0;
        
        while (l < r) {
            lMax = Math.max(height[l], lMax);
            rMax = Math.max(height[r], rMax);

            if (lMax < rMax) {
                ans += lMax - height[l++];
            } else {
                ans += rMax - height[r--];
            }
        }
        return ans;
    }
}