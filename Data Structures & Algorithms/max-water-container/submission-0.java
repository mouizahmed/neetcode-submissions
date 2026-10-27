class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int area = 0;

        while (l < r) {
            int width = r - l;
            int height = Math.min(heights[l], heights[r]);
            int a = width * height;
            area = Math.max(area, a);

            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return area;
    }
}
