class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;

        int l = 0, r = height.length-1;
        int leftMax = height[l], rightMax = height[r];
        int total = 0;

        while (l<r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                total += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                total += rightMax - height[r];
            }
        }
        return total;

    }
}

/*
two pointer method. basic fact: water[i] = min(tallest bar to its left, tallest bar to its right) - height[i]

so we have a left and right max value. we incremeent the pointer that has the smaller max. then we update the max by taking the maximum of the current max value and the current pointer. then use the basic fact to calculate how much water can be trapped so far and add it to total. moving the smaller max makes sense since the water is limited by the left side.

Time: O(n)
Space: O(1)
*/
