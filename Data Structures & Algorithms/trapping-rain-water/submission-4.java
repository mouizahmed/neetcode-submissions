class Solution {
    public int trap(int[] height) {
        int total = 0;
        int l = 0, r = height.length-1;
        int lMax = 0, rMax = 0;

        while (l < r) {
            if (height[l] < height[r]) {
                lMax = Math.max(lMax, height[l]);
                total += lMax-height[l++];
            } else {
                rMax = Math.max(rMax, height[r]);
                total += rMax-height[r--];
            }
        }
        return total;
    }
}
