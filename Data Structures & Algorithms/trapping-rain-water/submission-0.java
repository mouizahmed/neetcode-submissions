class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int total = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int bottom = stack.pop();
                if (stack.isEmpty()) break;
                int left = stack.peek();
                int depth = Math.min(height[left], height[i]) - height[bottom];
                int width = i - left - 1;
                total += depth*width;
            }
            stack.push(i);
        }

        return total;
        
    }
}
